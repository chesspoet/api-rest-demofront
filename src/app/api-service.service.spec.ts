import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ApiServiceService } from './api-service.service';
import { Task, Credencials } from './model';

describe('ApiServiceService', () => {
  let service: ApiServiceService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ApiServiceService]
    });
    service = TestBed.inject(ApiServiceService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should retrieve tasks', () => {
    const mockTasks: Task[] = [
      { id: 1, descripcion: 'Task 1' , titulo:''},
      { id: 2, descripcion: 'Task 2', titulo:'' }
    ];

    service.getTasks().subscribe((tasks: Task[]) => {
      expect(tasks).toEqual(mockTasks);
    });

    const req = httpMock.expectOne('http://localhost:8080/tasks');
    expect(req.request.method).toBe('GET');
    req.flush(mockTasks);
  });



  it('should retrieve token from local storage', () => {
    localStorage.setItem('token', 'mock-token');
    expect(service.getToken()).toBe('mock-token');
  });
});
