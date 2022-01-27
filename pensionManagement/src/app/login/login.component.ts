import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from '../auth-service.service';

export const TOKEN = '';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formGroup!: FormGroup;
  login:any;
  constructor(private authService: AuthServiceService,private router: Router) { }

  ngOnInit(){
    this.initForm();
    this.login="";
    // this.TOKEN=an
  }

  initForm(){
    this.formGroup = new FormGroup({
      username: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    })
  }
  loginProcess(){    
    this.login="";
    if(this.formGroup.valid){
      this.authService.login(this.formGroup.value).subscribe(result=>{
        // console.log(result);
        if(result.status){
          // alert(result.jwtToken);
          
          localStorage.setItem('token',result.jwtToken);
          // console.log("successs");
          this.authService.loggedIn = true;
          this.router.navigate(['search']);
          // this.login=true;
          // this.TOKEN = result.jwtToken;
        }else{
          // alert("Wrong Credentials, Try Again");
          this.authService.loggedIn=false;
          this.login=true;
        }
      })
    }
  }

}
