import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  userSub : Subscription;
  users$: Observable<Array<User>>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.users$ = this.userService.findAllUsers();
    console.log("okokok");
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
