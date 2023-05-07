import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Playlist } from 'src/app/models/playlist';
import { Usuario } from 'src/app/models/usuario';
import { UploadService } from './../../../services/upload.service';
import { VideoService } from './../../../services/video.service';

@Component({
  selector: 'app-enviar-video',
  templateUrl: './enviar.component.html',
  styleUrls: ['./enviar.component.css'],
})
export class EnviarVideoComponent implements OnInit {
  usuario: Usuario;
  formUpload: FormGroup;
  playlists: Playlist[] | undefined;

  constructor(
    private router: Router,
    private uploadService: UploadService,
    private formBuilder: FormBuilder,
    private videoService: VideoService
  ) {}

  ngOnInit(): void {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
    this.criarForm();
    this.getPlaylistsByUser();
  }

  criarForm() {
    this.formUpload = this.formBuilder.group({
      titulo: ['', [Validators.required]],
      link: ['', [Validators.required]],
      autor: [this.usuario.nome, [Validators.required]],
      privado: ['', [Validators.required]],
      categoria: ['', [Validators.required]],
      playlist: [''],
    });
  }

  getPlaylistsByUser() {
    this.videoService
      .getPlaylistsByUserId(this.usuario.id)
      .subscribe((playlists: Playlist[]) => {
        this.playlists = playlists;
      });
  }
  /*
    async getPlaylistsByUser() {
      this.playlists = await firstValueFrom(
        this.videoService.getPlaylistsByUserId(this.usuario.id)
      )
      console.log(this.playlists);
    */

  submit() {
    this.uploadService.enviarVideo(this.formUpload);
    this.router.navigateByUrl('/');
  }

  voltar() {
    this.router.navigateByUrl('/');
  }
}
