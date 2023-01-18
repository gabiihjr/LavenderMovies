import { environment } from './../../../environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../../components/movie/interfaces/movie';

const apiURL = environment.apiURL;
const token = environment.token;

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private httpClient: HttpClient) { }

  findAllMovies(): Observable<Movie[]> {
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    })
    return this.httpClient.get<Movie[]>(`${apiURL}/movie`)
  }

  findOneMovie(id: string): Observable<Movie>{
    return this.httpClient.get<Movie>(`${apiURL}/movie/${id}`);
  }
}
