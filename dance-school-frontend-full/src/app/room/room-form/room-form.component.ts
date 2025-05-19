import { Component } from '@angular/core';
import { RoomService, Room } from '../../services/room.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
})
export class RoomFormComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private roomService: RoomService
  ) {
    this.form = this.fb.group({
      numero: [''],
      title: [''],
      capacidade: ['']
    });
  }

  onSubmit() {
    const room: Room = this.form.value;
    this.roomService.create(room).subscribe(() => this.form.reset());
  }
}
