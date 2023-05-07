import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  url = 'http://localhost:8080/api/v1';
  public currentUser: Observable<Usuario>;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers':
        'Origin, X-Requested-With, Content-Type, Accept',
    }),
  };

  constructor(private httpClient: HttpClient, private router: Router) {
    const user = localStorage.getItem('currentUser');
  }

  logar(usuario: Usuario) {
    if (this.currentUser == null) {
      return this.httpClient
        .post<Usuario>(
          `${this.url}/autenticar`,
          JSON.stringify(usuario),
          this.httpOptions
        )
        .pipe(
          map((user) => {
            localStorage.setItem('currentUser', JSON.stringify(user));
            return user;
          })
        );
    } else {
      this.router.navigateByUrl('/');
      location.reload()
      return null;
    }
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

  getUser() {
    //if (this.id != null) {
    let id = JSON.parse(localStorage.getItem('currentUser')).id;
    return this.httpClient.get<any>(`${this.url}/usuario/${id}`);
    //}
  }
}
