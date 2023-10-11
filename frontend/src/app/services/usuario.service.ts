import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { IUsuario } from '../interfaces/IUsuario';
import { Usuario } from '../models/usuario';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

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

  constructor(private httpClient: HttpClient, private router: Router) {}

  cadastrar(usuario: Usuario) {
    return this.httpClient
    .post<Usuario>(
      `${this.url}/cadastrar`,
      JSON.stringify(usuario),
      this.httpOptions
    )
  }
}
