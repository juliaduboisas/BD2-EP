import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Student, StudentService } from '../../../services/student.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './student-form.html',
  styleUrls: ['./student-form.css']
})
export class StudentForm implements OnInit {
  studentForm: FormGroup;
  isEditMode = false;
  currentCpf: string | null = null;

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.studentForm = this.fb.group({
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]], // Exemplo de validação para CPF de 11 dígitos
      nome: ['', Validators.required],
      genero: ['', Validators.required],
      dataNasc: ['', Validators.required], // Pode usar um Date picker aqui
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.currentCpf = params.get('cpf');
      if (this.currentCpf) {
        this.isEditMode = true;
        this.studentForm.get('cpf')?.disable(); // Desabilita CPF em modo de edição
        this.loadStudentData(this.currentCpf);
      }
    });
  }

  loadStudentData(cpf: string): void {
    this.studentService.getStudentByCpf(cpf).subscribe(
      student => {
        this.studentForm.patchValue(student);
      },
      error => {
        console.error('Erro ao carregar dados do aluno:', error);
        alert('Erro ao carregar dados do aluno para edição.');
      }
    );
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      const studentData: Student = this.studentForm.getRawValue(); // Usa getRawValue para pegar o CPF desabilitado
      if (this.isEditMode) {
        this.studentService.updateStudent(studentData).subscribe(
          () => {
            alert('Aluno atualizado com sucesso!');
            this.router.navigate(['/students']);
          },
          error => {
            console.error('Erro ao atualizar aluno:', error);
            alert('Erro ao atualizar aluno. Verifique o console.');
          }
        );
      } else {
        this.studentService.addStudent(studentData).subscribe(
          () => {
            alert('Aluno adicionado com sucesso!');
            this.router.navigate(['/students']);
          },
          error => {
            console.error('Erro ao adicionar aluno:', error);
            alert('Erro ao adicionar aluno. Verifique o console.');
          }
        );
      }
    } else {
      alert('Por favor, preencha todos os campos obrigatórios corretamente.');
    }
  }

  cancel(): void {
    this.router.navigate(['/students']);
  }
}