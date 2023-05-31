import { Component } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { NgForm } from '@angular/forms';
import { Task,Credencials } from '../model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  creds: Credencials = {
    email:'',
    password:''
  }
  constructor(
    private apiService: ApiServiceService,
    private router: Router
  ){}

  login(form: NgForm){
    console.log('form value', form.value);
    this.apiService.login(this.creds)
    .subscribe(response =>{
      this.router.navigate(['/'])
    })
  }
}
