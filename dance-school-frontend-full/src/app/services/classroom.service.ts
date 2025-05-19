import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = 'http://localhost:8080/classroom';

export interface Classroom {
  id: number;
  qtdAulasSemanais: number;
  horarioInicio: string;
  horarioFim: string;
  tamanho: number;
  genero: string;
  nivel: string;
  idModalidade: number;
  cpfInstrutor: string;
}

@Injectable({
  providedIn: 'root',
})
export class ClassroomService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(BASE_URL);
  }

  getById(id: number): Observable<Classroom> {
    return this.http.get<Classroom>(`${BASE_URL}/${id}`);
  }

  create(classroom: Classroom): Observable<void> {
    return this.http.post<void>(`${BASE_URL}/add`, classroom);
  }

  update(classroom: Classroom): Observable<void> {
    return this.http.put<void>(`${BASE_URL}/update`, classroom);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${BASE_URL}/delete/${id}`);
  }
}
