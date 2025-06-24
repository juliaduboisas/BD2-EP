import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog'; // Import MatDialogModule
import { CommonModule, DatePipe } from '@angular/common';
import { Student } from '../../../services/student.service';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-student-details-modal',
  standalone: true,
  imports: [
    CommonModule,
    DatePipe,
    MatButtonModule,
    MatIconModule,
    MatDialogModule // Add MatDialogModule here
  ],
  templateUrl: './student-details-modal.html',
  styleUrls: ['./student-details-modal.css']
})
export class StudentDetailsModal implements OnInit {
  student: Student;

  constructor(
    public dialogRef: MatDialogRef<StudentDetailsModal>,
    @Inject(MAT_DIALOG_DATA) public data: { student: Student }
  ) {
    this.student = data.student;
  }

  ngOnInit(): void {}

  closeModal(): void {
    this.dialogRef.close();
  }
}