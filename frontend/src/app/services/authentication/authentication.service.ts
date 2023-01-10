import { Observable, tap } from 'rxjs';
import { UserService } from './user/user.service';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

const API = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient, private userService: UserService) { }

  authenticate(username: string, password: string): Observable<HttpResponse<any>> {
    console.log(username, 'user na request');
    console.log(password, 'senha na request')
    return this.httpClient.post(
      `http://localhost:8080/authenticate`,
      {
        password,
        username,
      },
      {observe: 'response'}
    ).pipe(
      tap((res) => {
        console.log('RES', res);
        const authToken = res.headers.get('x-access-token') ?? '';
        this.userService.saveToken(authToken);
      })
    );
  }
}
