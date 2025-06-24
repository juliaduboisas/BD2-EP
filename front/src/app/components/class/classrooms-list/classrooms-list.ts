import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { Classroom, ClassroomService } from '../../../services/classroom.service';
import { ModalityService } from '../../../services/modality.service'; // For filtering/display if needed
import { InstructorService } from '../../../services/instructor.service'; // For filtering/display if needed
import { ClassroomForm } from '../classroom-form/classroom-form'; // New ClassroomForm
import { ClassroomDetailsModal } from '../classroom-details-modal/classroom-details-modal'; // New ClassroomDetailsModal
import { ConfirmDialogComponent } from '../../confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-classrooms-list',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './classrooms-list.html',
  styleUrls: ['./classrooms-list.css']
})
export class ClassroomsList implements OnInit {
  classrooms: Classroom[] = [];
  page: number = 1;
  pageSize: number = 10;

  get paginatedClassrooms() {
    const start = (this.page - 1) * this.pageSize;
    return this.classrooms.slice(start, start + this.pageSize);
  }

  nextPage() {
    if (this.page < this.totalPages) this.page++;
  }

  prevPage() {
    if (this.page > 1) this.page--;
  }

  get totalPages() {
    return Math.ceil(this.classrooms.length / this.pageSize);
  }

  constructor(
    private classroomService: ClassroomService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.loadClassrooms();
  }

  loadClassrooms(): void {
    this.classroomService.getAllClasses().subscribe({
      next: (data) => {
        this.classrooms = data;
      },
      error: (error) => {
        console.error('Erro ao carregar turmas:', error);
      }
    });
  }

  createNewClassroom(): void {
    const dialogRef = this.dialog.open(ClassroomForm, {
      data: { classroom: null, isEdit: false },
      width: '650px' // Adjust width as needed
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadClassrooms();
      }
    });
  }

  editClassroom(id: number): void {
    this.classroomService.getClassById(id).subscribe({
      next: (classroom) => {
        const dialogRef = this.dialog.open(ClassroomForm, {
          data: { classroom: classroom, isEdit: true },
          width: '650px'
        });

        dialogRef.afterClosed().subscribe(result => {
          if (result) {
            this.loadClassrooms();
          }
        });
      },
      error: (error) => {
        console.error('Erro ao carregar turma para edição:', error);
        alert('Erro ao carregar turma para edição.');
      }
    });
  }

  viewClassroomDetails(id: number): void {
    this.classroomService.getClassById(id).subscribe({
      next: (classroom) => {
        this.dialog.open(ClassroomDetailsModal, {
          data: { classroom: classroom },
          width: '700px' // Adjust width as needed for details
        });
      },
      error: (error) => {
        console.error('Erro ao carregar detalhes da turma:', error);
        alert('Erro ao carregar detalhes da turma.');
      }
    });
  }

  deleteClassroom(id: number | undefined): void {
    if (id === undefined || id === null) {
        alert('Não é possível remover. Turma não possui ID.');
        return;
    }

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: { message: 'Tem certeza que deseja remover esta turma?' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.classroomService.deleteClass(id).subscribe({
          next: () => {
            alert('Turma removida com sucesso!');
            this.loadClassrooms();
          },
          error: (error) => {
            console.error('Erro ao remover turma:', error);
            alert('Erro ao remover turma. Verifique o console.');
          }
        });
      }
    });
  }
}