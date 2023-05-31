import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Task,Credencials } from './model';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(
    private http: HttpClient
  ) { }
  getTasks():Observable<Task[]>{
    return this.http.get<Task[]>('http://localhost:8080/tasks')
  }
  login(creds:Credencials){
    return this.http.post('http://localhost:8080/login',creds,{
      observe:'response'
    }).pipe(map((response: HttpResponse<any>)=>{
      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization')!;
      const token = bearerToken.replace('Bearer','');

      localStorage.setItem('token', token);
      return body;
    }
    ))
  }
  getToken(){
    return localStorage.getItem('token');
  }
}
