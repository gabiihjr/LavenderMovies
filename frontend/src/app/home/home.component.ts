import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  appName = 'Lavender Movies';
  
  numberOfMovies = 10;

  hideMovies = false;
  
  constructor() { }

  ngOnInit(): void {
  }

  toggle() {
    this.hideMovies = !this.hideMovies;
  }

}
