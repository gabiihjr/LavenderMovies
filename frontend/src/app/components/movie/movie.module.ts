import { MovieInterceptor } from './../movie.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieComponent } from './movie.component';



@NgModule({
  declarations: [
    MovieComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    MovieComponent,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: MovieInterceptor,
      multi: true,
    }
  ]
})
export class MovieModule { }
