import { Router } from '@angular/router';
import { AuthenticationService } from './../../services/authentication/authentication.service';
import { UserService } from './../../services/authentication/user/user.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  user$ = this.userService.returnUser();

  constructor(private userService: UserService, private authService: AuthenticationService, private router: Router) {}

  logout(){
    this.authService.logout().subscribe({
      complete: () => {
        this.router.navigate(['login']);
      },
      error: (error) => {
        console.log('ERROR', error);
        // alert('DEU ERRO SUA BURRA');
      }
    })
  }
}
