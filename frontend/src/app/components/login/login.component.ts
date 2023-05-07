import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { LoginService } from 'src/app/services/login.service';
import {Md5} from 'ts-md5';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  formLogin!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.criarForm();
  }

  criarForm() {
    this.formLogin = this.formBuilder.group({
      nome: ['', [Validators.required]],
      senha: ['', [Validators.required]],
    });
  }

  logar() {
    if (this.formLogin.invalid) return;
    let usuario = this.formLogin.getRawValue() as Usuario;

    // var nome = usuario.nome
    // var senha = usuario.senha
    const {nome, senha} = usuario
    //usuario.nome = Md5.hashStr(nome)
    //usuario.senha = Md5.hashStr(senha)

    if (
      this.loginService.logar(usuario).subscribe(
        () => {

          this.router.navigateByUrl('/');
        },
        (err) => {
          console.log(err);
        }
      )
    ) {
    }
  }
}
