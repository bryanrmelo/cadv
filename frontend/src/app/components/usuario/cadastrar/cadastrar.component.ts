import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit{

  formCadastrar!: FormGroup;

  constructor (
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
    private router: Router,
  ) {}

  ngOnInit(): void {
      this.criarForm();
  }

  criarForm() {
    this.formCadastrar = this.formBuilder.group({
      nome: ['', [Validators.required]],
      email: ['', [Validators.required]],
      senha: ['', [Validators.required]],
      confSenha: ['', [Validators.required]],
    })
  }

  cadastrar() {
    if (this.formCadastrar.invalid) return;
    let usuario = this.formCadastrar.getRawValue() as Usuario;

    // var nome = usuario.nome
    // var senha = usuario.senha
    const {nome, senha} = usuario
    //usuario.nome = Md5.hashStr(nome)
    //usuario.senha = Md5.hashStr(senha)

    if (
      this.usuarioService.cadastrar(usuario).subscribe(
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
