import { User } from './model/login';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import * as AppUtils from '../shared/comum/app.utils';
import { HttpParams, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public baseUrl: string;


  constructor(private httpClient: HttpClient) {

    this.baseUrl = `${AppUtils.BASE_URL}` + 'user';

   }

   /**
    * Method responsible to login in api
    * @param user 
    */
  doLogin(user: User): Observable <any> {

    console.log(user);

    //user 
    const params = new HttpParams()
      .set('username', user.login)
      .set('password', user.password)
      .set('grant_type', 'password');

    //Oauth2 params
    const options = {
      headers: AppUtils.HEADERS_COMMUN,
      params
    };

    console.log(AppUtils.URL_TOKEN);

    console.log(options);

    return this.httpClient.post(AppUtils.URL_TOKEN,null,options); 
 
  }

  getMainUser(token: any): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}`, AppUtils.OPTIONS_OBJECTO)
  }
}
