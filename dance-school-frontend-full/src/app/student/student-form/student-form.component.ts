import { Component } from '@angular/core';
import { StudentService, Student } from '../../services/student.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
})
export class StudentFormComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService
  ) {
    this.form = this.fb.group({
      cpf: [''],
      nome: [''],
      genero: [''],
      dataNasc: [''],
      email: ['']
    });
  }

  onSubmit() {
    const student: Student = this.form.value;
    this.studentService.create(student).subscribe(() => this.form.reset());
  }
}
