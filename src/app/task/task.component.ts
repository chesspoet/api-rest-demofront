import { Component, OnInit } from '@angular/core';
import { ApiServiceService } from '../api-service.service';
import { Task } from '../model';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit{
  tasks?: Task[];

  constructor(
    private apiService: ApiServiceService
  ){}
  ngOnInit(): void {
    this.apiService.getTasks()
    .subscribe(tasks =>{
        this.tasks = tasks;
      }
    )
  }

}
