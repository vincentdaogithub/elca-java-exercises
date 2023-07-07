import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsListComponent } from './projects-list/projects-list.component';
import { NewProjectComponent } from './new-project/new-project.component';
import { ErrorComponent } from './error/error.component';
import { UpdateProjectComponent } from './update-project/update-project.component';

const routes: Routes = [
  {path: "", redirectTo: "projects", pathMatch: "full"},
  {path: "projects-update/:projectNumber", component: UpdateProjectComponent},
  {path: "projects-new", component: NewProjectComponent},
  {path: "projects", component: ProjectsListComponent},
  {path: "error", component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
