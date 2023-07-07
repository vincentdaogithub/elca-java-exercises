import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { ProjectDto } from './model/project';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllProjects(): Observable<ProjectDto[]> {
    return this.http.get<ProjectDto[]>(`${this.apiUrl}/projects/`);
  }

  public addNewProject(projectToUpdate: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/projects/add`, projectToUpdate);
  }
}
