import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Post } from '../models/post-payload';

@Injectable({
  providedIn: 'root'
})
export class AddPostService {


  constructor(private httpClient: HttpClient) {
  }

  baseUrl = `${environment.baseUrl}/posts`;


  create(post: Post){
    return this.httpClient.post(this.baseUrl, post);
  }

    findAll(): Observable<Array<Post>>{
    return this.httpClient.get<Array<Post>>( this.baseUrl + '/all');
  }

    findById(idPost: Number):Observable<Post>{
    return this.httpClient.get<Post>(this.baseUrl + '/get/' + idPost);
  }

  update(post: Post){
    return this.httpClient.put<Post>(this.baseUrl, post)
  }

  delete(idPost: Number):Observable<Post>{
    return this.httpClient.delete<Post>(this.baseUrl + '/' + idPost)
  }

  // deletePosts(){
  //   return this.httpClient.delete('http://localhost:8080/api/posts/')
  // }
}



