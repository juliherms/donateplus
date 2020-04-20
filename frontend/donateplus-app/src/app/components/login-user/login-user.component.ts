import { Route, Router } from '@angular/router';
import { ApiService } from './../../core/api.service';
import { User } from './../../core/model/login';
import { Component, OnInit } from '@angular/core';

/**
 * this class responsible to shows page login
 */
@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.sass']
})
export class LoginUserComponent implements OnInit {

  user = new User();

  constructor(private apiService: ApiService,
              private router: Router) { }

  ngOnInit() {
  }

  /**
   * Method responsible to login
   */
  public login(){
    this.apiService.doLogin(this.user).subscribe(data => {
      this.loginSuccess(data);
    }, error => {
      console.log('Erro ao realizar o login');
    });
  }

  /**
   * Process success login
   * @param data  - return oauth/token
   */
  loginSuccess(data: any){

    localStorage.clear();
    localStorage.setItem('accessToken',data.access_token);
    localStorage.setItem('refreshToken',data.refresh_token);

    this.apiService.getMainUser(localStorage.getItem('accessToken')).subscribe(user => {
      this.redirectPage(user);
    }, error => {
      console.log('Erro ao pegar usuário logado!');
    });
  }

  /**
   * Storage user and redirect to main page
   * @param user 
   */
  public redirectPage(user: any){
    localStorage.setItem('currentUser', JSON.stringify(user));
    this.router.navigate(['welcome']);
  }
}
