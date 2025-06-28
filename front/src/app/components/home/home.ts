import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Import CommonModule
import { StudentService } from '../../services/student.service'; //
import { ModalityService } from '../../services/modality.service'; //
import { ClassService } from '../../services/class.service'; //
import { RegistrationService } from '../../services/registration.service'; //


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule], // Add CommonModule for ngIf, etc.
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {
  totalStudents: number = 0;
  activeModalities: number = 0;
  upcomingClasses: number = 0; // Will represent total classes for now
  newRegistrations: number = 0; // Will represent total registrations for now

  constructor(
    private studentService: StudentService,
    private modalityService: ModalityService,
    private classService: ClassService,
    private registrationService: RegistrationService
  ) {}

  ngOnInit(): void {
    this.fetchDashboardData();
  }

  fetchDashboardData(): void {
    this.studentService.getAllStudents().subscribe({ //
      next: (students) => {
        this.totalStudents = students.length;
      },
      error: (err) => console.error('Error fetching students:', err)
    });

    this.modalityService.getAllModalities().subscribe({ //
      next: (modalities) => {
        this.activeModalities = modalities.length;
      },
      error: (err) => console.error('Error fetching modalities:', err)
    });

    this.classService.getAllClasses().subscribe({ //
      next: (classes) => {
        this.upcomingClasses = classes.length;
      },
      error: (err) => console.error('Error fetching classes:', err)
    });

    this.registrationService.getAllRegistrations().subscribe({ //
      next: (registrations) => {
        this.newRegistrations = registrations.length;
      },
      error: (err) => console.error('Error fetching registrations:', err)
    });
  }
}