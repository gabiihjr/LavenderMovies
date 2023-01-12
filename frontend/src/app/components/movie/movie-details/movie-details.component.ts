import { MovieService } from './../../../services/movie/movie.service';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Movie } from '../interfaces/movie';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit{
  movieId!: string;
  movie$!: Observable<Movie>;

  constructor(private movieService: MovieService, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void{
    this.movieId = this.activatedRoute.snapshot.params?.['movieId'];
    this.movie$ = this.movieService.findOneMovie(this.movieId);
  }
}
