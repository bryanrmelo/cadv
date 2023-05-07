import { NgModule, Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthModule } from '@auth0/auth0-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { MaterialModule } from './material/material.module';
import { EnviarFonteComponent } from './components/fonte/enviar-fonte/enviar-fonte.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { EditarComponent } from './components/usuario/editar/editar.component';
import { VideoComponent } from './components/video/video.component';
import { EnviarVideoComponent } from './components/video/enviar/enviar.component';
import { EditarVideoComponent } from './components/video/editar/editar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    VideoComponent,
    EnviarVideoComponent,
    EnviarFonteComponent,
    UsuarioComponent,
    EditarComponent,
    EditarVideoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    MaterialModule,
    ReactiveFormsModule,
    AuthModule.forRoot({
      domain: 'dev-kkg92p-k.us.auth0.com',
      clientId: '4QjL3qcEbFSNEgmUT2OaOdTp6cq0tiF9',
    }),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
