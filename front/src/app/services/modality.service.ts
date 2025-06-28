import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Modality {
  id?: string;
  nome: string;
  descricao: string;
}

@Injectable({
  providedIn: 'root'
})
export class ModalityService {
  private apiUrl = 'api/modality';

  constructor(private http: HttpClient) { }

  getAllModalities(): Observable<Modality[]> {
    return this.http.get<Modality[]>(this.apiUrl);
  }

  getModalityById(id: string): Observable<Modality> { // ADDED THIS METHOD
    return this.http.get<Modality>(`${this.apiUrl}/${id}`);
  }

  addModality(modality: Omit<Modality, 'id'>): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/add`, modality);
  }

  updateModality(modality: Modality): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, modality);
  }

  deleteModality(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}