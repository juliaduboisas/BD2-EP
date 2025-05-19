import { Component } from '@angular/core';
import { ClassroomService, Classroom } from '../../services/classroom.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-classroom-form',
  templateUrl: './classroom-form.component.html',
})
export class ClassroomFormComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private classroomService: ClassroomService
  ) {
    this.form = this.fb.group({
      id: [''],
      qtdAulasSemanais: [''],
      horarioInicio: [''],
      horarioFim: [''],
      tamanho: [''],
      genero: [''],
      nivel: [''],
      idModalidade: [''],
      cpfInstrutor: ['']
    });
  }

  onSubmit() {
    const classroom: Classroom = this.form.value;
    this.classroomService.create(classroom).subscribe(() => this.form.reset());
  }
}
