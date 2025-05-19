import { Component, OnInit } from '@angular/core';
import { StudentService, Student } from '../../services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents() {
    this.studentService.getAll().subscribe(data => this.students = data);
  }

  deleteStudent(cpf: string) {
    this.studentService.delete(cpf).subscribe(() => this.loadStudents());
  }
}
