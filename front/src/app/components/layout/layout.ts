import { Component } from '@angular/core';
import { Sidebar } from '../sidebar/sidebar';
import { RouterModule, RouterOutlet } from '@angular/router'; // Add RouterOutlet
import { CommonModule } from '@angular/common'; // Add CommonModule

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [RouterModule, Sidebar, RouterOutlet, CommonModule], // Add RouterOutlet and CommonModule
  templateUrl: './layout.html',
  styleUrls: ['./layout.css']
})
export class Layout {
}