import { YoutubeService } from 'src/app/services/youtube.service';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css'],
})
export class VideoComponent implements OnInit {
  safeSrc!: SafeResourceUrl;
  id!: number;
  video: any = '';
  videos: any[] = [];

  constructor(
    private sanitizer: DomSanitizer,
    private activatedRoute: ActivatedRoute,
    private youtubeService: YoutubeService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
    });
    this.safeSrc = this.sanitizer.bypassSecurityTrustResourceUrl(
      `https://www.youtube.com/embed/${this.id}?enablejsapi=1&origin=http://localhost:4200'`
    );
    this.youtubeService.getVideoPorUrl(this.id).subscribe((res) => {
      for (let e of res['items']) {
        console.log(e);
        this.video = e;
      }
    });
  }
}
