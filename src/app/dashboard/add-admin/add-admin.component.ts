import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { SignupPayload } from 'src/app/auth/signup-payload';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.scss']
})
export class AddAdminComponent implements OnInit {

 
  signupForm: FormGroup;
  signupPayload: SignupPayload;

  constructor(
   private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
  this.signupForm = this.formBuilder.group({
     username: '',
     email: '', 
     password:''
   });
   this.signupPayload = {
    username: '',
    email: '', 
    password:''
  }
  }

  ngOnInit(): void {
  }

  onSubmit() {
   this.signupPayload.username = this.signupForm.get('username').value;
   this.signupPayload.email = this.signupForm.get('email').value;
   this.signupPayload.password = this.signupForm.get('password').value;

    this.authService.signupAdmin(this.signupPayload).subscribe(data=>{
      console.log('register success');
      this.router.navigateByUrl("dashboard");
    }, error => {
      console.log("register failed")
    }
    );
}
}