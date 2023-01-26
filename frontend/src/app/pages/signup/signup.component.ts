import { NewUser } from './new-user';
import { Router } from '@angular/router';
import { SignupService } from './../../services/signup/signup.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  username = '';
  name = '';
  email = '';
  password = '';

  newUserForm!: FormGroup;

  constructor(
    // private formBuilder: FormBuilder,
    private signupService: SignupService,
    private router: Router
    ){ }

    ngOnInit(): void {
      this.newUserForm = new FormGroup({
        username: new FormControl(),
        name: new FormControl(),
        email: new FormControl(),
        password: new FormControl(),
      })
    }

    saveUser() {
      const newUser = this.newUserForm.getRawValue() as NewUser;
     this.signupService.saveUser(newUser).subscribe({
      complete: () => this.router.navigate(['/home']),
      error: (error) => console.log(error)
     })
    }
}
