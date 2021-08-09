import { ConditionalExpr } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Post } from 'src/app/models/post-payload';
import { AddPostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {


  post: Post;
  idPost: Number;

  constructor(private router : Router, private activatedRouter: ActivatedRoute, private postService: AddPostService) {
  }

  ngOnInit() {
    this.activatedRouter.params.subscribe(params => {
      this.idPost = params['id'];
    });

    this.postService.findById(this.idPost).subscribe((data:Post) => {
      this.post = data;
    },(err: any) => {
      console.log('Failure Response');
      
    })


    // this.postService.deletePost(this.permaLink).subscribe(data => {
    //   console.log(data);
    // })
  
  }

  public deletePost(): void{
    if(confirm('Voulez-vous réellement supprimer cet article ?')){
      this.postService.delete(this.idPost).subscribe(
        data => {
          
          // CODE JS POUR REFRESH
          this.router.navigateByUrl('/blog');
          console.log(data);
        });
    }
  }

  // this.postSub = this.addPostService.delete(id).subscribe(data =>{ 
      
  //   console.log("ok")});
  //   this.posts$ = this.posts$.pipe(
  //     map(posts => posts.filter(post => post.id != id))
  //   )

  public updatePost(){
    this.router.navigateByUrl('update-post/' + this.idPost);
  }

 

}
