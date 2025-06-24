import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Enrollment {
  id: number;
  data_matricula: string;
  valor: number;
  idTransacaoId: number;
  cpfAluno: string; // Changed from cpf_aluno to cpfAluno
  idTurmaId: number;
}

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private apiUrl = 'api/matricula';

  constructor(private http: HttpClient) { }

  getAllEnrollments(): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(this.apiUrl);
  }

  getEnrollmentById(id: number): Observable<Enrollment> {
    return this.http.get<Enrollment>(`${this.apiUrl}/${id}`);
  }
}