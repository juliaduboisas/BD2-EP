import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = 'http://localhost:8080/rooms';

export interface Room {
  numero: number;
  title: string;
  capacidade: number;
}

@Injectable({
  providedIn: 'root',
})
export class RoomService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Room[]> {
    return this.http.get<Room[]>(BASE_URL);
  }

  getById(numero: number): Observable<Room> {
    return this.http.get<Room>(`${BASE_URL}/${numero}`);
  }

  searchByName(name: string): Observable<Room[]> {
    return this.http.get<Room[]>(`${BASE_URL}/name/${name}`);
  }

  create(room: Room): Observable<void> {
    return this.http.post<void>(`${BASE_URL}/add`, room);
  }

  update(room: Room): Observable<void> {
    return this.http.put<void>(`${BASE_URL}/update`, room);
  }

  delete(numero: number): Observable<void> {
    return this.http.delete<void>(`${BASE_URL}/delete/${numero}`);
  }
}
