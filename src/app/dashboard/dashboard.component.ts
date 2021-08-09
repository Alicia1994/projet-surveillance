import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  userSub : Subscription;
  users$: Observable<Array<User>>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

    this.users$ = this.userService.findAll();

  }

  deleteUser(id: number){
    this.userSub = this.userService.delete(id).subscribe(data =>{ 

      // fonction de filtre
      this.users$ = this.users$.pipe(
        map(users=> users.filter(user => user.id != id))
      )
      console.log("ok")});
    
    //this.router.navigateByUrl('blog');
    //NOTE TROUVER UN MOYEN DE RAFRACHIR
  }

}
