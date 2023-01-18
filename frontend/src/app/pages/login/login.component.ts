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

  constructor(private authService: AuthenticationService, private router: Router) {}

  ngOnInit(): void { }

  login() {
    this.authService.authenticate(this.username, this.password).subscribe({
      complete: () => {
        this.router.navigate(['home']);
      },
      error: (error) => {
        alert('User or password wrong')
        console.log('ERROR', error);
      }
    })
  }

}
