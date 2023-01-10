import { AuthenticationService } from './../../services/authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';

  constructor(private authService: AuthenticationService) {}

  ngOnInit(): void { }

  login() {
    this.authService.authenticate(this.username, this.password).subscribe({
      complete: () => {
        alert("LOGIN FEITO");
      },
      error: (error) => {
        console.log('USERNAME', this.username);
        console.log('PASSWORD', this.password);
        alert('User or password wrong')
        console.log('ERROR', error);
      }
    })
  }

}
