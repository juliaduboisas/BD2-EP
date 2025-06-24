import { StudentsList } from './components/student/students-list/students-list';
import { ModalitiesList } from './components/modality/modalities-list/modalities-list';
import { RoomsList } from './components/room/rooms-list/rooms-list';
import { ClassroomsList } from './components/class/classrooms-list/classrooms-list'; // Import ClassroomsList
import { Routes } from '@angular/router';
import { Home } from './components/home/home';

export const routes: Routes = [
  {
    path: '',
    component: Home,
  },
  { path: 'students', component: StudentsList },
  { path: 'modalities', component: ModalitiesList },
  { path: 'rooms', component: RoomsList },
  { path: 'classes', component: ClassroomsList }, // Add classes route
  { path: '**', redirectTo: ''}
];