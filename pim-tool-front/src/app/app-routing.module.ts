import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsListComponent } from './projects-list/projects-list.component';
import { NewProjectComponent } from './new-project/new-project.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [
  {path: "projects", component: ProjectsListComponent},
  {path: "projects-new", component: NewProjectComponent},
  {path: "error", component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
