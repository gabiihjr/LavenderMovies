import { environment } from './../../../environments/environment';
import { NewUser } from './../../pages/signup/new-user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }

  saveUser(newUser: NewUser) {
    return this.http.post(`${API}/user`, newUser);
  }
}
