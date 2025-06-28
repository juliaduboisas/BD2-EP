import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Class {
  id: string;
  nome: string;
  modalidadeId: string;
  nivel: string;
  cpfInstrutor: string;
  // Add other fields as per your backend Class model
}

@Injectable({
  providedIn: 'root'
})
export class ClassService {
  private apiUrl = 'api/classroom'; //

  constructor(private http: HttpClient) { }

  getAllClasses(): Observable<Class[]> {
    return this.http.get<Class[]>(this.apiUrl); //
  }

  getClassById(id: string): Observable<Class> {
    return this.http.get<Class>(`${this.apiUrl}/${id}`); //
  }

  getClassesByModality(modalityId: string): Observable<Class[]> {
    return this.http.get<Class[]>(`${this.apiUrl}/modality/${modalityId}`); //
  }

  getClassesByLevel(level: string): Observable<Class[]> {
    return this.http.get<Class[]>(`${this.apiUrl}/level/${level}`); //
  }

  getClassesByInstructor(cpfInstructor: string): Observable<Class[]> {
    return this.http.get<Class[]>(`${this.apiUrl}/instructor/${cpfInstructor}`); //
  }

  addClass(classroom: Class): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/add`, classroom); //
  }

  updateClass(classroom: Class): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, classroom); //
  }

  deleteClass(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`); //
  }
}