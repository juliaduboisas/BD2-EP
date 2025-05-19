import { Component, OnInit } from '@angular/core';
import { RoomService, Room } from '../../services/room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
})
export class RoomListComponent implements OnInit {
  rooms: Room[] = [];

  constructor(private roomService: RoomService) {}

  ngOnInit(): void {
    this.loadRooms();
  }

  loadRooms() {
    this.roomService.getAll().subscribe(data => this.rooms = data);
  }

  deleteRoom(numero: number) {
    this.roomService.delete(numero).subscribe(() => this.loadRooms());
  }
}
