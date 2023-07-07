import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ProjectService } from '../project.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ProjectUpdateDto } from '../model/project-update';
import { firstValueFrom, take } from 'rxjs';
import { GroupService } from '../group.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/employee';
import { Group } from '../model/group';

@Component({
  selector: 'app-update-project',
  templateUrl: './update-project.component.html',
  styleUrls: ['./update-project.component.css']
})
export class UpdateProjectComponent implements OnInit {

  projectToUpdate!: ProjectUpdateDto;

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
    private employeeService: EmployeeService,
    private route: ActivatedRoute) { }

  async ngOnInit(): Promise<void> {
    const projectNumber = Number(this.route.snapshot.paramMap.get('projectNumber'));
    if (isNaN(projectNumber)) {
      this.router.navigate(['/error']);
      return;
    }
    await this.getProjectByProjectNumber(projectNumber);
    this.getAllGroups();
    await this.getAllEmployees();

    this.projectForm.patchValue({
      projectNumber: this.projectToUpdate.projectNumber,
      projectName: this.projectToUpdate.projectName,
      customer: this.projectToUpdate.customer,
      groupId: this.projectToUpdate.groupId,
      membersAsString: this.employees
        .filter(e => this.projectToUpdate.members.includes(e.id))
        .map(e => e.visa)
        .join(", "),
      status: this.projectToUpdate.status,
      startDate: this.projectToUpdate.startDate,
      endDate: this.projectToUpdate.endDate
    })
    console.log(this.projectToUpdate)
  }

  async getProjectByProjectNumber(projectNumber: number): Promise<ProjectUpdateDto> {
    const result = await firstValueFrom(
      this.projectService.getProjectByProjectNumber(projectNumber));
    this.projectToUpdate = result;
    return result;
  }

  getAllGroups() {
    this.groupService.getAllGroups().subscribe({
      next: (value) => this.groups = value,
      error: (err) => this.router.navigate(['/error']),
    });
  }

  async getAllEmployees(): Promise<Employee[]> {
    const result = await firstValueFrom(this.employeeService.getAllEmployees());
    this.employees = result;
    return result;
  }

  async submitProjectForm() {
    this.invalid = false;
    if (this.projectForm.invalid) {
      this.invalid = true;
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

    const projectToUpdate = {
      projectNumber: this.projectForm.get('projectNumber')?.value,
      projectName: this.projectForm.get('projectName')?.value,
      customer: this.projectForm.get('customer')?.value,
      groupId: this.projectForm.get('groupId')?.value,
      members: memberIds,
      status: this.projectForm.get('status')?.value,
      startDate: this.projectForm.get('startDate')?.value,
      endDate: this.projectForm.get('endDate')?.value,
      version: this.projectToUpdate.version
    };
    this.updateProject(projectToUpdate);
  }

  updateProject(projectToUpdate: any): void {
    this.projectService.updateProject(projectToUpdate)
      .pipe(take(1))
      .subscribe({
        error: (err) => this.router.navigate(['/error']),
        complete: () => this.router.navigate(['/projects'])
      })
  }

  closeError() {
    this.invalid = false;
  }
}
