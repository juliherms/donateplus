import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// this class responsible for application router

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
