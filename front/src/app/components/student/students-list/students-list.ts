import { Component, OnInit } from '@angular/core';
import { Student, StudentService } from '../../../services/student.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-students-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './students-list.html',
  styleUrls: ['./students-list.css']
})
export class StudentsList implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getAllStudents().subscribe(
      data => {
        this.students = data;
      },
      error => {
        console.error('Erro ao carregar alunos:', error);
      }
    );
  }

  editStudent(cpf: string): void {
    this.router.navigate(['/students/edit', cpf]);
  }

  detailsStudent(cpf: string): void {
    this.router.navigate(['/students/details', cpf]);
  }

  deleteStudent(cpf: string): void {
    if (confirm('Tem certeza que deseja excluir este aluno?')) {
      this.studentService.deleteStudent(cpf).subscribe(
        () => {
          alert('Aluno excluído com sucesso!');
          this.loadStudents();
        },
        error => {
          console.error('Erro ao excluir aluno:', error);
          alert('Erro ao excluir aluno. Verifique o console.');
        }
      );
    }
  }

  createNewStudent(): void {
    this.router.navigate(['/students/new']);
  }
}