import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { IUsuario } from '../interfaces/IUsuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  logar(usuario: IUsuario): Observable<any> {
    throw new Error('Method not implemented.');
  }

  constructor() {}
}
