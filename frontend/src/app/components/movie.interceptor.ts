import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class MovieInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const headers = new HttpHeaders().append('Authorization', 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYWJpIiwiZXhwIjoxNjc2MDM3OTYzLCJuYW1lIjoiZ2FicmllbGEifQ.vb4yOeG82hfkHDIwjw6LWFcNti986m_fGNA4Z4YHCEM');
    request = request.clone({ headers });
    return next.handle(request);
  }
}
