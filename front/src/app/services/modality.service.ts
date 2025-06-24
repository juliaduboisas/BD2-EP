import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Modality {
  id: string;
  nome: string;
  descricao: string;
  // Add other fields as per your backend Modality model
}

@Injectable({
  providedIn: 'root'
})
export class ModalityService {
  private apiUrl = 'api/modality'; //

  constructor(private http: HttpClient) { }

  getAllModalities(): Observable<Modality[]> {
    return this.http.get<Modality[]>(this.apiUrl); //
  }

  getModalityById(id: string): Observable<Modality> {
    return this.http.get<Modality>(`${this.apiUrl}/${id}`); //
  }

  getModalityByName(name: string): Observable<Modality[]> {
    return this.http.get<Modality[]>(`${this.apiUrl}/by-name/${name}`); //
  }

  addModality(modality: Modality): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/add`, modality); //
  }

  updateModality(modality: Modality): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/update`, modality); //
  }
}