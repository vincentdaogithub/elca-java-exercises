import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { ProjectDto } from './model/project';
import { environment } from 'src/environments/environment';
import { ProjectUpdateDto } from './model/project-update';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllProjects(): Observable<ProjectDto[]> {
    return this.http.get<ProjectDto[]>(`${this.apiUrl}/projects/`);
  }

  public addNewProject(projectToAdd: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/projects/add`, projectToAdd);
  }

  public checkIfProjectNumberExist(projectNumber: number): Observable<boolean> {
    return this.http.get<boolean>(`${this.apiUrl}/projects/check/${projectNumber}`);
  }

  public getProjectByProjectNumber(projectNumber: number): Observable<ProjectUpdateDto> {
    return this.http.get<ProjectUpdateDto>(`${this.apiUrl}/projects/${projectNumber}`);
  }

  public updateProject(projectToUpdate: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/projects/update`, projectToUpdate);
  }

  public deleteProject(projectToDelete: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/projects/remove`, {body: projectToDelete});
  }

  public deleteProjects(projectToDelete: number[]): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/projects/remove`, {body: projectToDelete});
  }
}
