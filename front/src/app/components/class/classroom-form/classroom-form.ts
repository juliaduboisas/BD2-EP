import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Classroom, ClassroomService } from '../../../services/classroom.service';
import { Modality, ModalityService } from '../../../services/modality.service';
import { Instructor, InstructorService, FullInstructor } from '../../../services/instructor.service'; // Import FullInstructor
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-classroom-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule
  ],
  templateUrl: './classroom-form.html',
  styleUrls: ['./classroom-form.css']
})
export class ClassroomForm implements OnInit {
  classroomForm: FormGroup;
  isEditMode = false;
  currentClassroomId: number | null = null;

  modalities$!: Observable<Modality[]>;
  instructors$!: Observable<FullInstructor[]>; // Use FullInstructor here

  constructor(
    private fb: FormBuilder,
    private classroomService: ClassroomService,
    private modalityService: ModalityService,
    private instructorService: InstructorService,
    public dialogRef: MatDialogRef<ClassroomForm>,
    @Inject(MAT_DIALOG_DATA) public data: { classroom: Classroom | null; isEdit: boolean }
  ) {
    this.classroomForm = this.fb.group({
      id: [{ value: '', disabled: true }],
      qtdAulasSemanais: ['', [Validators.required, Validators.min(1)]],
      horarioInicio: ['', Validators.required],
      horarioFim: ['', Validators.required],
      tamanho: ['', [Validators.required, Validators.min(1)]],
      genero: ['', Validators.required],
      nivel: ['', Validators.required],
      idModalidade: ['', Validators.required],
      cpfInstrutor: ['', Validators.required]
    });

    this.isEditMode = data.isEdit;

    if (this.isEditMode && data.classroom) {
      this.currentClassroomId = data.classroom.id || null;
      this.classroomForm.patchValue(data.classroom);
    }
  }

  ngOnInit(): void {
    this.loadDropdownData();
  }

  loadDropdownData(): void {
    this.modalities$ = this.modalityService.getAllModalities();
    this.instructors$ = this.instructorService.getAllInstructors(); // This call might also need composite logic
  }

  onSubmit(): void {
    if (this.classroomForm.valid) {
      const classroomData: Classroom = this.classroomForm.getRawValue();

      if (this.isEditMode) {
        this.classroomService.updateClass(classroomData).subscribe({
          next: () => {
            alert('Turma atualizada com sucesso!');
            this.dialogRef.close(true);
          },
          error: error => {
            console.error('Erro ao atualizar turma:', error);
            alert('Erro ao atualizar turma. Verifique o console.');
          }
        });
      } else {
        const addPayload: Omit<Classroom, 'id'> = {
          qtdAulasSemanais: classroomData.qtdAulasSemanais,
          horarioInicio: classroomData.horarioInicio,
          horarioFim: classroomData.horarioFim,
          tamanho: classroomData.tamanho,
          genero: classroomData.genero,
          nivel: classroomData.nivel,
          idModalidade: classroomData.idModalidade,
          cpfInstrutor: classroomData.cpfInstrutor
        };
        this.classroomService.addClass(addPayload).subscribe({
          next: () => {
            alert('Turma adicionada com sucesso!');
            this.dialogRef.close(true);
          },
          error: error => {
            console.error('Erro ao adicionar turma:', error);
            alert('Erro ao adicionar turma. Verifique o console.');
          }
        });
      }
    } else {
      alert('Por favor, preencha todos os campos obrigatórios corretamente.');
    }
  }

  cancel(): void {
    this.dialogRef.close(false);
  }
}