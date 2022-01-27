import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { baseUrl } from 'src/environments/environment.prod';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {
  aadharNumber:any;
  details : any;
  requestSent : any;
  isInvalid : any;

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void {
    this.aadharNumber="";
    this.details={};
    this.requestSent=false;
    this.isInvalid=false;
  }
  
  LogOut(){
    this.router.navigate(['']);
  }

  searchAadhar():any{
    
    const httpOptions = {
      headers: new HttpHeaders({
        "Authorization": "Bearer " + localStorage.getItem("token")
      })
    };
      // alert(localStorage.getItem("token"));
      this.isInvalid=false;
      this.details={};
      this.http.post(`${baseUrl}Process/ProcessPension/${this.aadharNumber}`,null,httpOptions).subscribe((result)=>{
        // console.log(result);
        this.details = result;
      },
      error => {this.isInvalid=true}
        // console.log("adfsfsaf");
      );

      // this.http.get(`http://localhost:8081/Process/ProcessPension/${this.aadharNumber}`).subscribe((result)=>{
      //   // console.log(result);
      //   this.details = result;
      // },
      // error => this.isInvalid=true);

  }

  setAadhar(e:any){
    this.aadharNumber=e.target.value;
  }
}
