import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Room, RoomService } from '../../../services/room.service';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-room-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule
  ],
  templateUrl: './room-form.html',
  styleUrls: ['./room-form.css']
})
export class RoomForm implements OnInit {
  roomForm: FormGroup;
  isEditMode = false;
  currentRoomNumero: number | null = null;

  constructor(
    private fb: FormBuilder,
    private roomService: RoomService,
    public dialogRef: MatDialogRef<RoomForm>,
    @Inject(MAT_DIALOG_DATA) public data: { room: Room | null; isEdit: boolean }
  ) {
    this.roomForm = this.fb.group({
      numero: ['', [Validators.required, Validators.min(1)]], // numero is now required
      title: ['', Validators.required],
      capacidade: ['', [Validators.required, Validators.min(1)]]
    });

    this.isEditMode = data.isEdit;

    if (this.isEditMode && data.room) {
      this.currentRoomNumero = data.room.numero;
      this.roomForm.patchValue(data.room);
      this.roomForm.get('numero')?.disable(); // Disable numero when editing
    }
  }

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.roomForm.valid) {
      const roomData: Room = this.roomForm.getRawValue(); // Use getRawValue to get disabled fields like numero

      if (this.isEditMode) {
        this.roomService.updateRoom(roomData).subscribe({
          next: () => {
            alert('Sala atualizada com sucesso!');
            this.dialogRef.close(true); // Close with true on success
          },
          error: error => {
            console.error('Erro ao atualizar sala:', error);
            alert('Erro ao atualizar sala. Verifique o console.');
          }
        });
      } else {
        this.roomService.addRoom(roomData).subscribe({
          next: () => {
            alert('Sala adicionada com sucesso!');
            this.dialogRef.close(true); // Close with true on success
          },
          error: error => {
            console.error('Erro ao adicionar sala:', error);
            alert('Erro ao adicionar sala. Verifique o console.');
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