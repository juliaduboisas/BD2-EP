import { StudentsList } from './components/student/students-list/students-list';
import { StudentForm } from './components/student/student-form/student-form';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '**', redirectTo: '' },
  { path: 'students', component: StudentsList },
  { path: 'students/new', component: StudentForm },
  { path: 'students/edit/:cpf', component: StudentForm },
  { path: 'students/details/:cpf', component: StudentForm }
];