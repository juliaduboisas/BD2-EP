import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Student, StudentService } from '../../../services/student.service';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog'; // Add MatDialogModule
import { MatButtonModule } from '@angular/material/button'; // Ensure MatButtonModule is imported

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule, // Add MatDialogModule for mat-dialog-title, content, actions
    MatButtonModule // For mat-button in the dialog
  ],
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
    public dialogRef: MatDialogRef<StudentForm>, // Inject MatDialogRef
    @Inject(MAT_DIALOG_DATA) public data: { student: Student | null; isEdit: boolean } // Inject data
  ) {
    this.studentForm = this.fb.group({
      cpf: ['', [Validators.required, Validators.pattern(/^\d{11}$/)]],
      nome: ['', Validators.required],
      genero: ['', Validators.required],
      dataNasc: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });

    this.isEditMode = data.isEdit; // Determine mode from injected data

    if (this.isEditMode && data.student) {
      this.currentCpf = data.student.cpf;
      this.studentForm.patchValue(data.student);
      this.studentForm.get('cpf')?.disable(); // CPF should be disabled when editing
    }
  }

  ngOnInit(): void {} // No need for route subscription here anymore

  onSubmit(): void {
    if (this.studentForm.valid) {
      const studentData: Student = this.studentForm.getRawValue(); // Use getRawValue to get disabled fields

      if (this.isEditMode) {
        this.studentService.updateStudent(studentData).subscribe({
          next: () => {
            alert('Aluno atualizado com sucesso!');
            this.dialogRef.close(true); // Close with true on success
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
            this.dialogRef.close(true); // Close with true on success
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
    this.dialogRef.close(false); // Close with false on cancel
  }
}