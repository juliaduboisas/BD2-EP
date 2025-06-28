import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Modality, ModalityService } from '../../../services/modality.service';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-modality-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule
  ],
  templateUrl: './modality-form.html',
  styleUrls: ['./modality-form.css']
})
export class ModalityForm implements OnInit {
  modalityForm: FormGroup;
  // isEditMode property removed as it's no longer needed

  constructor(
    private fb: FormBuilder,
    private modalityService: ModalityService,
    public dialogRef: MatDialogRef<ModalityForm>,
    // data.isEdit is no longer used for logic within this form
    @Inject(MAT_DIALOG_DATA) public data: { /* isEdit: boolean */ } // Remove isEdit from data, or keep empty object if no data is passed
  ) {
    this.modalityForm = this.fb.group({
      nome: ['', Validators.required],
      descricao: ['', Validators.required]
    });
    // Removed all logic related to this.isEditMode = data.isEdit;
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.modalityForm.valid) {
      const modalityData: Omit<Modality, 'id'> = this.modalityForm.value;

      // Simplified to always call addModality
      this.modalityService.addModality(modalityData).subscribe({
        next: () => {
          alert('Modalidade adicionada com sucesso!');
          this.dialogRef.close(true); // Close with true on success
        },
        error: error => {
          console.error('Erro ao adicionar modalidade:', error);
          alert('Erro ao adicionar modalidade. Verifique o console.');
        }
      });
    } else {
      alert('Por favor, preencha todos os campos obrigatórios corretamente.');
    }
  }

  cancel(): void {
    this.dialogRef.close(false); // Close with false on cancel
  }
}