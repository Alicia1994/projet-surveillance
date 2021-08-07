import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { SignupPayload } from '../signup-payload';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

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

  initForm() {
    
  }

  onSubmit() {
   this.signupPayload.username = this.signupForm.get('username').value;
   this.signupPayload.email = this.signupForm.get('email').value;
   this.signupPayload.password = this.signupForm.get('password').value;

    this.authService.signup(this.signupPayload).subscribe(data=>{
      console.log('register success');
      console.log(this.signupPayload)
      this.router.navigateByUrl("signup-success");
    }, error => {
      console.log("register failed")
    }

    );

}

}


// import { Component, OnInit } from '@angular/core';
// import { FormGroup, FormControl, Validators } from '@angular/forms';
// import { Router } from '@angular/router';
// import { AuthService } from '../../services/auth.service';

// @Component({
//   selector: 'app-signup',
//   templateUrl: './signup.component.html',
//   styleUrls: ['./signup.component.scss']
// })
// export class SignupComponent implements OnInit {

//   signupForm: FormGroup;

//   constructor(
//     private authService: AuthService, 
//     private router: Router) {
//     this.signupForm = new FormGroup({});
//   }

//   ngOnInit(): void {
//     this.initForm();
//   }

//   initForm() {
//     this.signupForm = new FormGroup({
//       username: new FormControl('', Validators.required),
//       email: new FormControl('', [Validators.required, Validators.email]),
//       password: new FormControl('', [Validators.minLength(8)]),
//     })
//   }

//   onSubmit() {
//     const formValues = this.signupForm?.value;
//     console.log(formValues);
//     this.authService.signup(
//       formValues['username'],
//       formValues['firstName'],
//       formValues['lastName'],
//       formValues['email'],
//       formValues['password']
//     ).subscribe(
//       (resp: any) => {
//         // console.log('Création ok');
//         this.router.navigate(['/login']);
//       }
//     )
//   }
//}