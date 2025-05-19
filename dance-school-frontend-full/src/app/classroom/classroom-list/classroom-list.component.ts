import { Component, OnInit } from '@angular/core';
import { ClassroomService, Classroom } from '../../services/classroom.service';

@Component({
  selector: 'app-classroom-list',
  templateUrl: './classroom-list.component.html',
})
export class ClassroomListComponent implements OnInit {
  classrooms: Classroom[] = [];

  constructor(private classroomService: ClassroomService) {}

  ngOnInit(): void {
    this.loadClassrooms();
  }

  loadClassrooms() {
    this.classroomService.getAll().subscribe(data => this.classrooms = data);
  }

  deleteClassroom(id: number) {
    this.classroomService.delete(id).subscribe(() => this.loadClassrooms());
  }
}
