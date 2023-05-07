import { HomeComponent } from './components/home/home.component';
import { VideoService } from './services/video.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'src/app/services/login.service';
import { YoutubeService } from './services/youtube.service';
import { Video } from './models/video';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Conhecimento entre videos';
  user = localStorage.getItem('currentUser');
  videos: Video[];
  search: string = '';

  constructor(
    private loginService: LoginService,
    private videoService: VideoService,
    private homeComponent: HomeComponent
  ) {
    const user = localStorage.getItem('currentUser');
  }

  buscarVideoPorNome() {
    localStorage.removeItem('search');
    localStorage.setItem('search', this.search);

    //this.homeComponent.refresh();
  }

  logout() {
    this.loginService.logout();
    location.reload();
  }

  ngOnInit(): void {}
}
