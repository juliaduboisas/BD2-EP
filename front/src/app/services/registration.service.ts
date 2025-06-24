import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Registration {
  id: string;
  // Add other fields as per your backend Inscricao model
}

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private apiUrl = 'api/inscricao'; //

  constructor(private http: HttpClient) { }

  getAllRegistrations(): Observable<Registration[]> {
    return this.http.get<Registration[]>(this.apiUrl); //
  }

  getRegistrationById(id: string): Observable<Registration> {
    return this.http.get<Registration>(`${this.apiUrl}/${id}`); //
  }

  addRegistration(registration: Registration): Observable<void> {
    return this.http.post<void>(this.apiUrl, registration); //
  }

  updateRegistration(registration: Registration): Observable<void> {
    return this.http.put<void>(this.apiUrl, registration); //
  }

  deleteRegistration(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`); //
  }
}