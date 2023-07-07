import { Component, OnInit } from '@angular/core';
import { ProjectDto } from '../model/project';
import { ProjectService } from '../project.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { take } from 'rxjs';

@Component({
  selector: 'app-projects-list',
  templateUrl: './projects-list.component.html',
  styleUrls: ['./projects-list.component.css']
})
export class ProjectsListComponent implements OnInit {

  public projects: ProjectDto[] = [];
  public confirmedDelete: boolean = false;
  public projectsToDelete: number[] = [];
  public isDeletingOneProject = false;

  ngOnInit(): void {
      this.getAllProjects();
  }

  constructor(
    private projectService: ProjectService,
    private formBuilder: FormBuilder,
    private router: Router) { }

  public getAllProjects(): void {
    this.projectService.getAllProjects().subscribe({
      next: (respone) => this.projects = respone,
      error: (err) => this.router.navigate(['/error'])
    });
  }

  getUpdateProject(projectNumber: number): void {
    this.router.navigate([`/projects-update`, projectNumber]);
  }

  tryDeleteProject(projectId: number): void {
    this.isDeletingOneProject = true;
    this.confirmedDelete = true;
    this.projectsToDelete.push(projectId);
  }

  cancelDelete() {
    if (this.isDeletingOneProject) {
      this.isDeletingOneProject = false;
      this.projectsToDelete.pop();
    }
    this.confirmedDelete = false;
  }

  deleteProject(projectToDelete: number) {
    this.projectService.deleteProject(projectToDelete)
      .subscribe({
        next: (value) => console.log(value),
        error: (err) => {
          this.router.navigate(['/error']);
        },
        complete: () => this.router.navigate(['/projects'])
      })
  }

  confirmDelete() {
    if (this.isDeletingOneProject) {
      const projectId = this.projectsToDelete.pop();
      this.isDeletingOneProject = false;
      if (projectId == undefined) {
        this.router.navigate(['/error']);
        this.projectsToDelete = [];
        return;
      }
      this.deleteProject(projectId);
    } else {
      this.router.navigate(['/projects']);
    }
  }
}
