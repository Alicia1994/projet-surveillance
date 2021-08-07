import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/post-payload';
import { AddPostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-last-articles',
  templateUrl: './last-articles.component.html',
  styleUrls: ['./last-articles.component.scss']
})
export class LastArticlesComponent implements OnInit {

  posts$: Observable<Array<Post>>;


  constructor(private addPostService: AddPostService, private router: Router) { }


  ngOnInit() {
    this.posts$ = this.addPostService.findAll();
  }

}
