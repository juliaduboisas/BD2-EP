import { Component } from '@angular/core';
import { Layout } from "./components/layout/layout";

@Component({
  selector: 'app-root',
  imports: [Layout],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'Escola de Dança';
}
