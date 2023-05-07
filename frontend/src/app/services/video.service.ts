import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { map, Observable } from 'rxjs';
import { Usuario } from 'src/app/models/usuario';
import { Playlist } from '../models/playlist';
import { Video } from '../models/video';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  url = environment.apiUrl;
  usuario: Usuario;
  headersJSON = new HttpHeaders({
    'Content-Type': 'application/json; charset=utf-8',
  });

  constructor(private httpClient: HttpClient) {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getPlaylistsByUserId(id: number): Observable<Playlist[]> {
    return this.httpClient.get(`${this.url}/video/playlist/${id}`).pipe(
      map((data: any) => {
        return data._embedded.playlistList as Playlist[];
      })
    );
  }

  getVideos(): Observable<Video[]> {
    return this.httpClient.get(`${this.url}/video`).pipe(
      map((data: any) => {
        return data._embedded.videoList as Video[];
      })
    );
  }

  getVideosByName(search: String): Observable<Video[]> {
    return this.httpClient.get(`${this.url}/video?search=${search}`).pipe(
      map((data: any) => {
        return data._embedded.videoList as Video[];
      })
    );
  }

  getVideo(link: number): Observable<Video> {
    return this.httpClient.get(`${this.url}/video?link=${link}`).pipe(
      map((data: any) => {
        return data as Video;
      })
    );
  }
  atualizar(formUpload: FormGroup<any>) {
    formUpload.patchValue({
      autor: formUpload.get('autor').value.nome,
    });
    this.httpClient
      .put<any>(`${this.url}/video`, JSON.stringify(formUpload.getRawValue()), {
        headers: this.headersJSON,
      })
      .subscribe(() => {});
  }
}
