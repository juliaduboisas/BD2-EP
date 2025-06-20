import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.html',
  styleUrls: ['./sidebar.css']
})
export class Sidebar {
  activeLink: string = 'students';

  constructor(private router: Router) {}

  setActive(link: string) {
    this.activeLink = link;
    this.router.navigate([link]);
  }
}