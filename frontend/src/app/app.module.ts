import { MovieModule } from './components/movie/movie.module';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationModule } from './services/authentication/authentication.module';
import { HeaderModule } from './components/header/header.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    FormsModule,
    AuthenticationModule,
    HttpClientModule,
    MovieModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
