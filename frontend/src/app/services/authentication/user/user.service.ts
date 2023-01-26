import { AuthenticationService } from './../authentication.service';
import { TokenService } from '../token/token.service';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import jwt_decode from 'jwt-decode';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userSubject = new BehaviorSubject<User>({});

  constructor(private tokenService: TokenService) {
    if (this.tokenService.hasToken()) {
      this.decodeJWT();
    }
  }

  private decodeJWT(){
    const token = this.tokenService.returnToken();
    const user = jwt_decode(token) as User;
    this.userSubject.next(user);
  };

  returnUser() {
    console.log('USER', this.userSubject.value.sub);
    return this.userSubject;
  };

  saveToken(token: string) {
    this.tokenService.saveToken(token);
    this.decodeJWT();
  };

  logout(){
    this.tokenService.eraseToken();
    this.userSubject.next({});
  };

  isLoggedIn(){
    return this.tokenService.hasToken();
  };
}
