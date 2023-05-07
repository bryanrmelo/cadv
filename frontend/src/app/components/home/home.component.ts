import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { Observable } from 'rxjs';
import { VideoService } from './../../services/video.service';
import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';
import { Video } from 'src/app/models/video';

@Injectable({
  providedIn: 'root',
})
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  user = localStorage.getItem('currentUser');
  usuario: Usuario = new Usuario(this.user);

  constructor(
    private httpClient: HttpClient,
    private spinner: NgxSpinnerService,
    private youTubeService: YoutubeService,
    private videoServico: VideoService,
    private router: Router
  ) {
    const user = localStorage.getItem('currentUser');
  }

  videos: Video[] = [];
  videosConvertidos: any[] = [];

  ngOnInit(): void {
    this.spinner.show();

    this.videoServico.getVideos().subscribe((videos: Video[]) => {
      for (let element of videos) {
        if (element.privado == false) {
          this.videos.push(element);
          console.log(JSON.stringify(this.videos));
        }
      }
      this.converterParaVideoYoutube(this.videos);
    });
    /*
    this.videoServico
      .getVideosByName(localStorage.getItem('search'))
      .subscribe((videos: Video[]) => {
        this.videos = videos;
      });
    this.youTubeService
      .getVideosPorID('UCsXVk37bltHxD1rDPwtNM8Q', 16)
      .subscribe((lista) => {
        for (let element of lista['items']) {
          this.videos!.push(element);
        }
        setTimeout(() => {
          this.spinner.hide();
        }, 3000);
      });
      */
  }

  converterParaVideoYoutube(videos: Video[]): void {
    for (let i = 0; i < videos.length; i++) {
      this.youTubeService.getVideoPorUrl(videos[i].link).subscribe((lista) => {
        for (let element of lista['items']) {
          this.videosConvertidos.push(element);
          console.log(JSON.stringify(this.videosConvertidos));
        }
      });
    }
    this.videosConvertidos.sort();
  }

  refresh(): void {
    this.videos = [];
    this.ngOnInit();
  }
}
