import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { Room, RoomService } from '../../../services/room.service';
import { RoomForm } from '../room-form/room-form';
import { ConfirmDialogComponent } from '../../confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-rooms-list',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './rooms-list.html',
  styleUrls: ['./rooms-list.css']
})
export class RoomsList implements OnInit {
  rooms: Room[] = [];

  constructor(
    private roomService: RoomService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.loadRooms();
  }

  loadRooms(): void {
    this.roomService.getAllRooms().subscribe({
      next: (data) => {
        this.rooms = data;
      },
      error: (error) => {
        console.error('Erro ao carregar salas:', error);
      }
    });
  }

  createNewRoom(): void {
    const dialogRef = this.dialog.open(RoomForm, {
      data: { room: null, isEdit: false }, // Pass isEdit: false for new
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadRooms();
      }
    });
  }

  editRoom(numero: number): void { // New: editRoom method
    this.roomService.getRoomByNumero(numero).subscribe({
      next: (room) => {
        const dialogRef = this.dialog.open(RoomForm, {
          data: { room: room, isEdit: true }, // Pass room data and isEdit: true
          width: '400px'
        });

        dialogRef.afterClosed().subscribe(result => {
          if (result) {
            this.loadRooms();
          }
        });
      },
      error: (error) => {
        console.error('Erro ao carregar sala para edição:', error);
        alert('Erro ao carregar sala para edição.');
      }
    });
  }

  deleteRoom(numero: number | undefined): void {
    if (numero === undefined || numero === null) {
        alert('Não é possível remover. Sala não possui número.');
        return;
    }

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: { message: 'Tem certeza que deseja remover esta sala?' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.roomService.deleteRoom(numero).subscribe({
          next: () => {
            alert('Sala removida com sucesso!');
            this.loadRooms();
          },
          error: (error) => {
            console.error('Erro ao remover sala:', error);
            alert('Erro ao remover sala. Verifique o console.');
          }
        });
      }
    });
  }
}