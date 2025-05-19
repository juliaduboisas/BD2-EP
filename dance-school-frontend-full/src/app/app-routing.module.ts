const routes: Routes = [
  { path: 'students', component: StudentListComponent },
  { path: 'add-student', component: StudentFormComponent },
  { path: 'rooms', component: RoomListComponent },
  { path: 'add-room', component: RoomFormComponent },
  { path: 'classrooms', component: ClassroomListComponent },
  { path: 'add-classroom', component: ClassroomFormComponent },
  { path: '', redirectTo: 'students', pathMatch: 'full' },
];
