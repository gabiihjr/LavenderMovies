import { MovieDetailsComponent } from './components/movie/movie-details/movie-details.component';
import { MovieComponent } from './components/movie/movie.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    pathMatch: 'full',
    component: HomeComponent,
  },
  {
    path: 'login',
    pathMatch: 'full',
    component: LoginComponent,
  },
  {
    path: 'movie',
    pathMatch: 'full',
    component: MovieComponent,
  },
  {
    path: 'movie/:movieId',
    pathMatch: 'full',
    component: MovieDetailsComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
