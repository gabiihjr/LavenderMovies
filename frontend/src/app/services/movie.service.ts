import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../components/movie/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private httpClient: HttpClient) { }

  findAllMovies(): Observable<Movie[]> {
    const headers = new Headers({
      'Content-Type': 'application/json',
      'Authorization': `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYWJpIiwiZXhwIjoxNjc2MDM3OTYzLCJuYW1lIjoiZ2FicmllbGEifQ.vb4yOeG82hfkHDIwjw6LWFcNti986m_fGNA4Z4YHCEM`
    })
    return this.httpClient.get<Movie[]>(`http://localhost:8080/movie`)
  }
}
