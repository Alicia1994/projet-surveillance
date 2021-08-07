import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import { JwtAutResponse } from '../auth/jwt-aut-response';
import { LoginPayload } from '../auth/login-payload';
import { SignupPayload } from '../auth/signup-payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = "http://localhost:8080/api/auth/"

  constructor(
    private router: Router, private httpClient: HttpClient, private localStorageService : LocalStorageService
    ) { }

    signup(signupPayload: SignupPayload): Observable<any> {
      return this.httpClient.post(this.url + "signup", signupPayload);
    }

    login(loginPayload: LoginPayload): Observable<boolean> {
      return this.httpClient.post<JwtAutResponse>(this.url + 'login', loginPayload).pipe(map(data => {
        this.localStorageService.store('authenticationToken', data.authenticationToken);
        this.localStorageService.store('username', data.username);
        return true;
      }));
    }

    isAuthenticated(): Boolean{
     return this.localStorageService.retrieve('username') != null;
    }

    logout(){
      this.localStorageService.clear('authenticationToken');
      this.localStorageService.clear('username');
      this.router.navigate(['/connexion']);

    }
}




// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Router } from '@angular/router';
// import{ map } from 'rxjs/operators';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {
//   API_URL = "https://test-node-jb.herokuapp.com/api"

//   constructor(
//     private httpClient: HttpClient,
//     private router : Router
//     ) { }

//   login(email: string, password: string) {
//     const body = {
//       email,
//       password
//     }
//     return this.httpClient.post('https://test-node-jb.herokuapp.com/api/auth/login', body)
//     .pipe(
//       map(
//         (resp: any) => {
//           localStorage.setItem('TOKEN_APPLI', resp.token);
//           localStorage.setItem('USER_ID', resp.userId);
//           console.log('Token Save');
//           return resp;
//         }
//       )
//     );
//   }

//   signup(emailParam : string, fritNameParam : string, lastNameParam : string, pseudoParam: string, passwordParam : string){
//     const body = {
//       email : emailParam,
//       firstName : fritNameParam,
//       lastName : lastNameParam,
//       pseudo : pseudoParam,
//       password : passwordParam
//     }
//     return this.httpClient.post(`${this.API_URL}/auth/signup`, body);
//   }

//   logout(){
//     localStorage.removeItem('TOKEN_APPLI');
//     this.router.navigate(['/login']);
//   }
// }
