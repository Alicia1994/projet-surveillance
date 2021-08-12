import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription, Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.scss']
})
export class AdminListComponent implements OnInit {

  userSub : Subscription;
  users$: Observable<Array<User>>;


  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    // this.users$ = this.userService.findAllAdmin();
  }

}
