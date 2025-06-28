import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Classroom {
  id?: number; // ID is optional for add, required for update/delete
  qtdAulasSemanais: number;
  horarioInicio: string;
  horarioFim: string;
  tamanho: number;
  genero: string;
  nivel: string;
  idModalidade: number; // Foreign key to Modality
  cpfInstrutor: string; // Foreign key to Instructor
}

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {
  private apiUrl = 'api/classroom';

  constructor(private http: HttpClient) { }

  getAllClasses(): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(this.apiUrl);
  }

  getClassById(id: number): Observable<Classroom> {
    return this.http.get<Classroom>(`${this.apiUrl}/${id}`);
  }

  addClass(classroom: Omit<Classroom, 'id'>): Observable<void> { // ID should be omitted for add
    return this.http.post<void>(`${this.apiUrl}/add`, classroom);
  }

  updateClass(classroom: Classroom): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, classroom);
  }

  deleteClass(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  // Optional methods for filtering, as per API:
  getClassesByModality(idModalidade: number): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(`${this.apiUrl}/modality/${idModalidade}`);
  }

  getClassesByLevel(level: string): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(`${this.apiUrl}/level/${level}`);
  }

  getClassesByInstructor(cpfInstrutor: string): Observable<Classroom[]> {
    return this.http.get<Classroom[]>(`${this.apiUrl}/instructor/${cpfInstrutor}`);
  }
}