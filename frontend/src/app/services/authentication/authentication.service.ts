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
    return this.httpClient.post(
      `${API}/login`,
      {
        username,
        password,
      },
      {observe: 'response'}
    ).pipe(
      tap((res) => {
        const authToken = res.headers.get('x-access-token') ?? '';
        this.userService.saveToken(authToken);
      })
    );
  }
}
