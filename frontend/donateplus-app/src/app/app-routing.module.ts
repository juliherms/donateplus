import { EditUserComponent } from './components/edit-user/edit-user.component';
import { ListUserComponent } from './components/list-user/list-user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { ResendRegistratonTokenComponent } from './components/resend-registraton-token/resend-registraton-token.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// this class responsible for application router

const routes: Routes = [
  { path: '', component : LoginUserComponent },
  { path: 'login', component: LoginUserComponent },
  { path: 'register-user', component: RegisterUserComponent },
  { path: 'resend-register-token', component: ResendRegistratonTokenComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'list-user', component: ListUserComponent },
  { path: 'edit-user/:id', component: EditUserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
