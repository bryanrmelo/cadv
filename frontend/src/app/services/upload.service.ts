import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class UploadService {
  url = 'http://localhost:8080/api/v1';
  headersJSON = new HttpHeaders({
    'Content-Type': 'application/json; charset=utf-8',
  });
  headersMULTIPART = new HttpHeaders({
    'Content-Type': 'multipart/form-data; charset=utf-8',
  });
  formData: FormData = new FormData();

  constructor(private httpClient: HttpClient) {}

  postFile(fileToUpload: File) {
    this.formData.append('file', fileToUpload, fileToUpload.name);
    this.httpClient
      .post(`${this.url}/fonte`, this.formData)
      .subscribe((data) => {
        return data;
      });
  }

  enviarVideo(formUpload: FormGroup<any>) {
    this.httpClient
      .post(`${this.url}/video`, JSON.stringify(formUpload.getRawValue()), {
        headers: this.headersJSON,
      })
      .subscribe((data) => {
        return data;
      });
  }
}
