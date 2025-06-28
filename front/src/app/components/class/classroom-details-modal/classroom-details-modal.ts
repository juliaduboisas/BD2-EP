import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { Classroom } from '../../../services/classroom.service';
import { Instructor, InstructorService, FullInstructor } from '../../../services/instructor.service';
import { Modality, ModalityService } from '../../../services/modality.service';
import { Enrollment, EnrollmentService } from '../../../services/enrollment.service';
import { Student, StudentService } from '../../../services/student.service';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { forkJoin, of, Observable } from 'rxjs';
import { switchMap, catchError, tap, map } from 'rxjs/operators';

@Component({
  selector: 'app-classroom-details-modal',
  standalone: true,
  imports: [CommonModule, MatButtonModule, MatIconModule, MatDialogModule],
  templateUrl: './classroom-details-modal.html',
  styleUrls: ['./classroom-details-modal.css']
})
export class ClassroomDetailsModal implements OnInit {
  classroom: Classroom;
  instructor: FullInstructor | null = null;
  modality: Modality | null = null;
  enrolledStudents: Student[] = [];
  isLoadingDetails = true;
  errorLoadingDetails = false;

  constructor(
    public dialogRef: MatDialogRef<ClassroomDetailsModal>,
    @Inject(MAT_DIALOG_DATA) public data: { classroom: Classroom },
    private instructorService: InstructorService,
    private modalityService: ModalityService,
    private enrollmentService: EnrollmentService,
    private studentService: StudentService
  ) {
    this.classroom = data.classroom;
  }

  ngOnInit(): void {
    this.loadRelatedData();
  }

  loadRelatedData(): void {
    this.isLoadingDetails = true;
    this.errorLoadingDetails = false;
    console.log('--- Loading data for Classroom ID:', this.classroom.id, '---');

    // Fetch Instructor details
    const instructor$ = this.classroom.cpfInstrutor
      ? this.instructorService.getInstructorByCpf(this.classroom.cpfInstrutor).pipe(
          tap(instr => console.log('Fetched Instructor (composite):', instr)),
          catchError(err => {
            console.error('Error fetching instructor (composite):', err);
            return of(null);
          })
        )
      : of(null);

    // Fetch Modality details
    const modality$ = (this.classroom.idModalidade !== undefined && this.classroom.idModalidade !== null)
      ? this.modalityService.getModalityById(String(this.classroom.idModalidade)).pipe(
          tap(mod => console.log('Fetched Modality:', mod)),
          catchError(err => {
            console.error('Error fetching modality:', err);
            return of(null);
          })
        )
      : of(null);

    // --- REVISED STUDENTS FETCH LOGIC ---
    const studentsAndEnrollments$ = forkJoin([
      this.studentService.getAllStudents().pipe(
        tap(students => console.log('Fetched ALL Students:', students)),
        catchError(err => {
          console.error('Error fetching ALL students:', err);
          return of([]);
        })
      ),
      this.enrollmentService.getAllEnrollments().pipe(
        tap(enrollments => console.log('Fetched ALL Enrollments:', enrollments)),
        catchError(err => {
          console.error('Error fetching ALL enrollments:', err);
          return of([]);
        })
      )
    ]).pipe(
      map(([allStudents, allEnrollments]) => {
        const classEnrollments = allEnrollments.filter(
          enrollment => enrollment.idTurmaId === this.classroom.id
        );
        console.log('Enrollments for current class (ID:', this.classroom.id, '):', classEnrollments);

        const enrolledStudentsData: Student[] = [];
        for (const classEnrollment of classEnrollments) {
          const student = allStudents.find(s => s.cpf === classEnrollment.cpfAluno); // CHANGED TO cpfAluno
          if (student) {
            enrolledStudentsData.push(student);
          } else {
            console.warn(`Student with CPF ${classEnrollment.cpfAluno} not found in all students list.`); // CHANGED TO cpfAluno
          }
        }
        console.log('Matched Enrolled Students:', enrolledStudentsData);
        return enrolledStudentsData;
      }),
      catchError(err => {
        console.error('Error during matching students and enrollments:', err);
        return of([]);
      })
    );
    // --- END REVISED STUDENTS FETCH LOGIC ---


    forkJoin([instructor$, modality$, studentsAndEnrollments$]).subscribe({
      next: ([instructor, modality, students]) => {
        this.instructor = instructor;
        this.modality = modality;
        this.enrolledStudents = students;
        console.log('Final Instructor:', this.instructor);
        console.log('Final Modality:', this.modality);
        console.log('Final Enrolled Students:', this.enrolledStudents);
        this.isLoadingDetails = false;
        console.log('--- Data loading complete ---');
      },
      error: (err) => {
        console.error('Error loading classroom related data in forkJoin:', err);
        this.errorLoadingDetails = true;
        this.isLoadingDetails = false;
        console.log('--- Data loading failed ---');
      }
    });
  }

  closeModal(): void {
    this.dialogRef.close();
  }
}