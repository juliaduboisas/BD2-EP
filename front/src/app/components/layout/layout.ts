import { Component } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterModule,Sidebar],
  templateUrl: './layout.html',
  styleUrl: './layout.css'
})
export class Layout {

}