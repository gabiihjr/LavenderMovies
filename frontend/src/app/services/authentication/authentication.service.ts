import { Observable, tap } from 'rxjs';
import { UserService } from './user/user.service';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient, private userService: UserService) { }

  authenticate(username: string, password: string): Observable<any> {
    console.log(username, 'user na request');
    console.log(password, 'senha na request');
    return this.httpClient.post(
      `${API}/authenticate`,
      {
        username,
        password,
      },
      {responseType: 'text'}
    ).pipe(
      tap((res) => {
        console.log('RES', res);
        this.userService.saveToken(res);
      })
    );
  }

  logout() {
    this.userService.logout();
    return this.httpClient.get(
      `${API}/logout`
    )
  }
}
