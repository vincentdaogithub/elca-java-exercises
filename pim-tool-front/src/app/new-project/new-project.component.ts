import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GroupService } from '../group.service';
import { Group } from '../model/group';
import { take } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  groups: Group[] = [];

  projectForm: FormGroup = this.fb.group({
    projectNumber: ['', [Validators.required, Validators.min(1), Validators.max(9999), Validators.pattern("^\d{1,}$")]],
    projectName: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    customer: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    groupId: ['', [Validators.required, Validators.min(1), Validators.max(19), Validators.pattern("^\d{1,}$")]],
    membersAsString: '',
    status: ['', Validators.required],
    startDate: ['', Validators.required],
    endDate: ['', Validators.required]
  });

  invalid: boolean = false;

  constructor(
    private groupService: GroupService,
    private fb: FormBuilder,
    private projectService: ProjectService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAllProject();
  }

  getAllProject() {
    this.groupService.getAllGroups().subscribe({
      next: (value) => this.groups = value,
      error: (err) => alert(err.message),
    });
  }

  submitProjectForm() {
    if (this.projectForm.invalid) {
      this.invalid = true;
      return;
    }
    let membersAsString = this.projectForm.get('membersAsString')?.value as string;
    const members = membersAsString.split(',').map(visa => visa.trim());
    const projectToAdd = {
      projectNumber: this.projectForm.get('projectNumber')?.value,
      projectName: this.projectForm.get('projectName')?.value,
      customer: this.projectForm.get('customer')?.value,
      groupId: this.projectForm.get('groupId')?.value,
      members: members,
      status: this.projectForm.get('status')?.value,
      startDate: this.projectForm.get('startDate')?.value,
      endDate: this.projectForm.get('endDate')?.value,
    };
    console.log(projectToAdd);
    this.addNewProject(projectToAdd);
  }

  addNewProject(projectToAdd: any): void {
    this.projectService.addNewProject(projectToAdd).pipe(take(1)).subscribe({
      next: (value) => console.log(value),
      error: (err) => this.router.navigate(['/error']),
      complete: () => this.router.navigate(['/projects'])
    });
  }

  closeError() {
    this.invalid = false;
  }
}
