import { TokenService } from './token/token.service';
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';

const token = `eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYWJpIiwiZXhwIjoxNjc2MDM3OTYzLCJuYW1lIjoiZ2FicmllbGEifQ.vb4yOeG82hfkHDIwjw6LWFcNti986m_fGNA4Z4YHCEM`
@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(private tokenService: TokenService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    // if(this.tokenService.hasToken()) {
    //   const token = this.tokenService.returnToken();
      const headers = new HttpHeaders().append('x-access-token', token);
      request = request.clone({ headers });
    // }

    return next.handle(request);
  }
}
