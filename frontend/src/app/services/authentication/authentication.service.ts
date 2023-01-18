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

  authenticate(email: string, password: string): Observable<any> {
    console.log(email, 'user na request');
    console.log(password, 'senha na request')
    return this.httpClient.post(
      `${API}/authenticate`,
      {
        email,
        password,
      },
      {responseType: 'text'}
      // {observe: 'response'}
    ).pipe(
      tap((res) => {
        console.log('RES', res);
        // const authToken = res.headers.get('x-access-token') ?? '';
        this.userService.saveToken(res);
      })
    );
  }
}
