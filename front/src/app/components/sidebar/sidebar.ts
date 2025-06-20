import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.html',
  styleUrls: ['./sidebar.css']
})
export class Sidebar {
  activeLink: string = 'students';

  setActive(link: string) {
    this.activeLink = link;
  }
}