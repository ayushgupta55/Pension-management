import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardGuard } from './auth-guard.guard';
import { LoginComponent } from './login/login.component';
import { ResultPageComponent } from './result-page/result-page.component';
import { SearchPageComponent } from './search-page/search-page.component';
// import { CanActivateRouteGuard } from './can-activate-route.guard';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'search',canActivate:[AuthGuardGuard], component:SearchPageComponent},
  // {path:'result',component:ResultPageComponent}
]
// canActivate:[AuthGuardGuard],

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [LoginComponent,SearchPageComponent,ResultPageComponent];