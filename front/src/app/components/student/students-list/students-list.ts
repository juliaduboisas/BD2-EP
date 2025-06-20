import { Component, OnInit } from "@angular/core";
import { Student, StudentService } from "../../../services/student.service";
import { Router, RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";

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

  constructor(private studentService: StudentService, private router: Router) {}

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

  editStudent(cpf: string): void {
    this.router.navigate(["/students/edit", cpf]);
  }

  deleteStudent(cpf: string): void {
    if (confirm("Tem certeza que deseja excluir este aluno?")) {
      this.studentService.deleteStudent(cpf).subscribe({
        next: () => {
          alert("Aluno excluído com sucesso!");
          this.loadStudents();
        },
        error: (error) => {
          console.error("Erro ao excluir aluno:", error);
          alert("Erro ao excluir aluno. Verifique o console.");
        }
      });
    }
  }

  createNewStudent(): void {
    this.router.navigate(["/students/new"]);
  }
}
