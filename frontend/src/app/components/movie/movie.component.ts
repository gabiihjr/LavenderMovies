import { MovieService } from './../../services/movie.service';
import { Component, OnInit } from '@angular/core';
import { Movie } from './movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit{
  movies!: Movie[]

  constructor(private movieService: MovieService){}

  ngOnInit(): void {
    this.movieService.findAllMovies().subscribe((movies) => {
      this.movies = movies;
    })
  }
}
