import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from 'src/environments/environment.prod';
import { LoginComponent } from './login/login.component';
import { pensionDetail } from './PensionDetail';

 

@Injectable({
  providedIn: "root"
})
export class AuthServiceService {
  loggedIn:any;
  private url='';

  constructor(private http:HttpClient) {}
  login(data: any):Observable<any>{
    return this.http.post(`${baseUrl}jwt/authenticate`,data);
  }

  public getPensionDetail(aadharNumber: number):Observable<pensionDetail>{
    return this.http.get<pensionDetail>(`${this.url}/${aadharNumber}`);
  }

}
