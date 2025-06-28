import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Room {
  numero: number; // Numero is now required
  title: string;
  capacidade: number;
}

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private apiUrl = 'api/rooms';

  constructor(private http: HttpClient) { }

  getAllRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(this.apiUrl);
  }

  getRoomByNumero(numero: number): Observable<Room> { // New: get room by numero
    return this.http.get<Room>(`${this.apiUrl}/${numero}`);
  }

  addRoom(room: Room): Observable<void> { // numero is now expected in payload for add
    return this.http.post<void>(`${this.apiUrl}/add`, room);
  }

  updateRoom(room: Room): Observable<void> { // New: update room
    return this.http.put<void>(`${this.apiUrl}/update`, room);
  }

  deleteRoom(numero: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${numero}`);
  }
}