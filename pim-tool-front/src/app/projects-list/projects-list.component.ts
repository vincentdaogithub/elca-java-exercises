import { Component, OnInit } from '@angular/core';
import { ProjectDto } from '../model/project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-projects-list',
  templateUrl: './projects-list.component.html',
  styleUrls: ['./projects-list.component.css']
})
export class ProjectsListComponent implements OnInit {

  public projects: ProjectDto[] = [];

  ngOnInit(): void {
      this.getAllProjects();
  }

  constructor(private projectService: ProjectService) { }

  public getAllProjects(): void {
    this.projectService.getAllProjects().subscribe({
      next: (respone) => {
        this.projects = respone;
        console.log(this.projects);
      },
      error: (err) => alert(err.message)
    });
  }
}