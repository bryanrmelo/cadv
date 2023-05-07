import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadService } from 'src/app/services/upload.service';

@Component({
  selector: 'app-enviar-fonte',
  templateUrl: './enviar-fonte.component.html',
  styleUrls: ['./enviar-fonte.component.css'],
})
export class EnviarFonteComponent implements OnInit {
  fileToUpload: File | null = null;

  constructor(private uploadService: UploadService) {}

  ngOnInit(): void {}

  handleFileInput(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    this.fileToUpload = files.item(0);
    this.uploadService.postFile(this.fileToUpload)
  }
}
