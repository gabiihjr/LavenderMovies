import { Component, OnInit } from '@angular/core';
import { Movie } from './movie';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  appName = 'Lavender Movies';
  
  numberOfMovies = 10;

  hideMovies = false;

  movie: Movie = {
    title: 'lalala',
    summary: 'lala',
  }
  
  constructor() { }

  ngOnInit(): void {
  }

  toggle() {
    this.hideMovies = !this.hideMovies;
  }

}
