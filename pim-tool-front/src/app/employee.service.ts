import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './model/employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  apiUrl: string = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiUrl}/employees/`);
  }
}
