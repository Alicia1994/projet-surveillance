import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Post } from 'src/app/models/post-payload';
import { AddPostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {

  postSub : Subscription;
  dataPosts: Post[];
  isDeleted: boolean = false;
  posts: Post[];
  post: Post;



  posts$: Observable<Array<Post>>;
  
  constructor(private addPostService: AddPostService, private router: Router) { }

  ngOnInit() {
    this.posts$ = this.addPostService.findAll();
  }

  deletePost(id: number){
    this.postSub = this.addPostService.delete(id).subscribe(data =>{ console.log("ok")});
    //this.router.navigateByUrl('blog');
    //NOTE TROUVER UN MOYEN DE RAFRACHIR
  }
}


