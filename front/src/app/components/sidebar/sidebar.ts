import { Component } from '@angular/core';
import { Router, NavigationEnd, RouterModule } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './sidebar.html',
  styleUrls: ['./sidebar.css']
})
export class Sidebar {
  activeLink: string = '';

  constructor(private router: Router) {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        const url = event.urlAfterRedirects || event.url;
        if (url.startsWith('/students')) this.activeLink = 'students';
        else if (url.startsWith('/modalities')) this.activeLink = 'modalities';
        else if (url.startsWith('/rooms')) this.activeLink = 'rooms';
        else if (url.startsWith('/classes')) this.activeLink = 'classes';
        else this.activeLink = '';
      });
  }
}