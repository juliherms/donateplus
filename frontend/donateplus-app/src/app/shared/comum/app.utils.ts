import { HttpHeaders } from '@angular/common/http';

export const BASE_URL = 'http://localhost:8088';

export const URL_TOKEN = BASE_URL + 'oauth/token';
export const REGISTER_URL = BASE_URL + '/users';
export const CONFIRM_REGISTER_URL = BASE_URL + 'api/public/registrationConfirm/users';
export const RESEND_REGISTER_TOKEN_URL = BASE_URL + 'api/public/resendRegistrationToken/users';

//header token
const headersToken = new HttpHeaders({
    Authorization: 'Bearer ' + window.localStorage.getItem('accessToken')
});

export const OPTIONS_OBJECTO = { headers: headersToken };

//client credentials
export const HEADERS_LOGIN = new HttpHeaders({
    Authorization: 'Basic ' + btoa('cliente' + ':' + '123')
});

export const HEADERS_REGISTER = new HttpHeaders({
    Authorization: 'Basic ' + btoa('cliente' + ':' + '123') 
});

export const HEADERS_COMMUN = new HttpHeaders({
    Authorization: 'Basic ' + btoa('cliente' + ':' + '123') 
});