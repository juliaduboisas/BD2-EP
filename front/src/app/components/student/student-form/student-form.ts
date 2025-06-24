import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Student, StudentService } from '../../../services/student.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [RouterModule, CommonModule, ReactiveFormsModule],
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
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      nome: ['', Validators.required],
      genero: ['', Validators.required],
      dataNasc: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit(): void {
    this.route.url.subscribe(urlSegments => {
      const path = urlSegments.map(s => s.path).join('/');
      if (path.includes('new')) {
        this.isEditMode = false;
      } else if (path.includes('edit')) {
        this.isEditMode = true;
        this.studentForm.get('cpf')?.disable(); // CPF should be disabled when editing
        this.currentCpf = this.route.snapshot.paramMap.get('cpf');
        if (this.currentCpf) {
          this.loadStudentData(this.currentCpf);
        }
      } else { // Default to new if no specific mode is detected, or handle other paths if any
        this.isEditMode = false;
      }
    });
  }

  loadStudentData(cpf: string): void {
    this.studentService.getStudentByCpf(cpf).subscribe({
      next: student => {
        this.studentForm.patchValue(student);
      },
      error: error => {
        console.error('Erro ao carregar dados do aluno:', error);
        alert('Erro ao carregar dados do aluno para edição.');
      }
    });
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      const studentData: Student = this.studentForm.getRawValue(); // Use getRawValue to get disabled fields
      if (this.isEditMode) {
        this.studentService.updateStudent(studentData).subscribe({
          next: () => {
            alert('Aluno atualizado com sucesso!');
            this.router.navigate(['/students']);
          },
          error: error => {
            console.error('Erro ao atualizar aluno:', error);
            alert('Erro ao atualizar aluno. Verifique o console.');
          }
        });
      } else {
        this.studentService.addStudent(studentData).subscribe({
          next: () => {
            alert('Aluno adicionado com sucesso!');
            this.router.navigate(['/students']);
          },
          error: error => {
            console.error('Erro ao adicionar aluno:', error);
            alert('Erro ao adicionar aluno. Verifique o console.');
          }
        });
      }
    } else {
      alert('Por favor, preencha todos os campos obrigatórios corretamente.');
    }
  }

  cancel(): void {
    this.router.navigate(['/students']);
  }
}