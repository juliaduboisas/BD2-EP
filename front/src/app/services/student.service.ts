import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Student {
  cpf: string;
  nome: string;
  genero: string;
  dataNasc: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiUrl = 'api/students';

  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.apiUrl);
  }

  getStudentByCpf(cpf: string): Observable<Student> {
    return this.http.get<Student>(`${this.apiUrl}/${cpf}`);
  }

  addStudent(student: Student): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/add`, student);
  }

  updateStudent(student: Student): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, student);
  }

  deleteStudent(cpf: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${cpf}`);
  }

  getStudentByName(name: string): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.apiUrl}/name/${name}`);
  }
}