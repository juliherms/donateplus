import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { ResendRegistratonTokenComponent } from './components/resend-registraton-token/resend-registraton-token.component';
import { EditUserComponent } from './components/edit-user/edit-user.component';
import { ListUserComponent } from './components/list-user/list-user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { HeaderComponent } from './shared/components/navigation/header/header.component';
import { DeleteUserModalComponent } from './shared/components/modals/delete-user-modal/delete-user-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginUserComponent,
    RegisterUserComponent,
    ResendRegistratonTokenComponent,
    EditUserComponent,
    ListUserComponent,
    WelcomeComponent,
    HeaderComponent,
    DeleteUserModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
