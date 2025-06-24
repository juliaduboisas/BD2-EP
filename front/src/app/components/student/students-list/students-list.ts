import { Component, OnInit } from "@angular/core";
import { Student, StudentService } from "../../../services/student.service";
import { Router, RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { MatDialog } from '@angular/material/dialog';
import { StudentDetailsModal } from '../student-details-modal/student-details-modal';
import { ConfirmDialogComponent } from '../../confirm-dialog/confirm-dialog'; // Import ConfirmDialogComponent

@Component({
  selector: "app-students-list",
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: "./students-list.html",
  styleUrls: ["./students-list.css"],
})
export class StudentsList implements OnInit {
  students: Student[] = [];
  page: number = 1;
  pageSize: number = 10;

  get paginatedStudents() {
    const start = (this.page - 1) * this.pageSize;
    return this.students.slice(start, start + this.pageSize);
  }

  nextPage() {
    if (this.page < this.totalPages) this.page++;
  }

  prevPage() {
    if (this.page > 1) this.page--;
  }

  get totalPages() {
    return Math.ceil(this.students.length / this.pageSize);
  }

  constructor(
    private studentService: StudentService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getAllStudents().subscribe({
      next: (data) => {
        this.students = data;
      },
      error: (error) => {
        console.error("Erro ao carregar alunos:", error);
      },
    });
  }

  createNewStudent(): void {
    this.router.navigate(["/students/new"]);
  }

  viewStudentDetails(cpf: string): void {
    this.studentService.getStudentByCpf(cpf).subscribe({
      next: (student) => {
        this.dialog.open(StudentDetailsModal, {
          data: { student: student },
          width: '500px'
        });
      },
      error: (error) => {
        console.error('Erro ao carregar detalhes do aluno:', error);
        alert('Erro ao carregar detalhes do aluno.');
      }
    });
  }

  deleteStudent(cpf: string): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: { message: 'Tem certeza que deseja remover este aluno?' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) { // If user clicked 'Confirmar'
        this.studentService.deleteStudent(cpf).subscribe({
          next: () => {
            alert('Aluno removido com sucesso!');
            this.loadStudents(); // Reload the list
          },
          error: (error) => {
            console.error('Erro ao remover aluno:', error);
            alert('Erro ao remover aluno. Verifique o console.');
          }
        });
      }
    });
  }
}