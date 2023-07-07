import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GroupService } from '../group.service';
import { Group } from '../model/group';
import { firstValueFrom, take } from 'rxjs';
import { Router } from '@angular/router';
import { async } from '@angular/core/testing';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  groups: Group[] = [];
  employees: Employee[] = []

  projectForm: FormGroup = this.fb.group({
    projectNumber: ['', [Validators.required, Validators.min(1), Validators.max(9999)]],
    projectName: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    customer: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    groupId: ['', [Validators.required, Validators.min(1), Validators.max(19)]],
    membersAsString: '',
    status: ['', Validators.required],
    startDate: ['', Validators.required],
    endDate: ''
  });

  invalid: boolean = false;
  projectNumberAlreadyExisted = false;
  invalidVisas: string[] = [];

  constructor(
    private groupService: GroupService,
    private fb: FormBuilder,
    private projectService: ProjectService,
    private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getAllGroups();
    this.getAllEmployees();
  }

  getAllGroups() {
    this.groupService.getAllGroups().subscribe({
      next: (value) => this.groups = value,
      error: (err) => this.router.navigate(['/error']),
    });
  }

  getAllEmployees() {
    this.employeeService.getAllEmployees().subscribe({
      next: (value) => this.employees = value,
      error: (err) => this.router.navigate(['/error'])
    })
  }

  async checkIfProjectNumberExist(projectNumber: number): Promise<boolean> {
    const result = await firstValueFrom(
      this.projectService.checkIfProjectNumberExist(projectNumber));
    this.projectNumberAlreadyExisted = result;
    return result;
  }

  async submitProjectForm() {
    this.invalid = false;
    if (this.projectForm.invalid) {
      this.invalid = true;
      return;
    }

    this.projectNumberAlreadyExisted = false;
    const projectNumber = this.projectForm.get('projectNumber')?.value as number;
    await this.checkIfProjectNumberExist(projectNumber);
    if (this.projectNumberAlreadyExisted) {
      return;
    }

    let membersAsString = this.projectForm.get('membersAsString')?.value as string;
    const memberVisas = membersAsString.split(',').map(visa => visa.trim());
    const memberIds = this.employees.filter(e => memberVisas.includes(e.visa)).map(e => e.id);
    this.invalidVisas = [];
    if (memberIds.length != memberVisas.length) {
      const visas = this.employees.filter(e => memberVisas.includes(e.visa)).map(e => e.visa);
      this.invalidVisas = memberVisas.filter(m => !visas.includes(m));
      return;
    }

    const projectToAdd = {
      projectNumber: projectNumber,
      projectName: this.projectForm.get('projectName')?.value,
      customer: this.projectForm.get('customer')?.value,
      groupId: this.projectForm.get('groupId')?.value,
      members: memberIds,
      status: this.projectForm.get('status')?.value,
      startDate: this.projectForm.get('startDate')?.value,
      endDate: this.projectForm.get('endDate')?.value,
    };
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
