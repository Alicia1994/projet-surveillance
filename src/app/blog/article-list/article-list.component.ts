import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, pipe, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { Post } from 'src/app/models/post-payload';
import { AddPostService } from 'src/app/services/post.service';
import * as moment from "moment";

moment.locale('fr');
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
    //this.posts$ = this.addPostService.findAll();

    this.posts$ = this.addPostService.findAll().pipe(
      map((posts:Array<Post>) => {
        // posts.forEach((post:Post) => {
        // })
        return posts;
    }));
    // ajouter une fonction d'attente de chargement de la page
  }


// ****** Handle the publication of the articles *********
  setTimeToMoment(date: string){
    const date1  = moment(date, "YYYY-MM-DD h-mm");
    const date2  = moment(new Date().toLocaleString(), "DD/MM/YYYY, h:mm:s");
    const dateDiff = date2.diff(date1, "hours");
    if(dateDiff < 24){
      return "Publié le " + moment(date, "YYYY-MM-DD h-mm").fromNow();
    } else if (dateDiff>=24){
     const dateSplit = date.split(" ");
     const day = dateSplit[0].replace(/-/g, "/").split("/").reverse().join("/");
     const hour = dateSplit[1].replace("-", "h")
      return "Publié " + day + " à " + hour
    }
    //console.log(new Date('2021-08-13 13:43').getHours())
  }

  deletePost(id: number){
    this.postSub = this.addPostService.delete(id).subscribe(data =>{ 
    
      console.log("ok")});
      this.posts$ = this.posts$.pipe(
        map(posts => 
          posts.filter(post => post.id != id))
      )
  }
}

// TRANSFORMATION DE L'OBSERVABLE POUR MANIPULER LE CONTENU DU TABLEAU
// this.posts$ = this.addPostService.findAll().pipe(
//   map((posts:Array<Post>) => {
//         posts.forEach((post:Post) => {
//           post.createdOn = 'toto'
//         })
//     return posts;
// }));