import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = 'http://localhost:8080/students';

export interface Student {
  cpf: string;
  nome: string;
  genero: string;
  dataNasc: string;
  email: string;
}

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(BASE_URL);
  }

  getByCpf(cpf: string): Observable<Student> {
    return this.http.get<Student>(`${BASE_URL}/${cpf}`);
  }

  searchByName(name: string): Observable<Student[]> {
    return this.http.get<Student[]>(`${BASE_URL}/name/${name}`);
  }

  create(student: Student): Observable<void> {
    return this.http.post<void>(`${BASE_URL}/add`, student);
  }

  update(student: Student): Observable<void> {
    return this.http.put<void>(`${BASE_URL}/update`, student);
  }

  delete(cpf: string): Observable<void> {
    return this.http.delete<void>(`${BASE_URL}/delete/${cpf}`);
  }
}
