import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AddPostService } from '../services/post.service';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.scss']
})
export class UpdatePostComponent implements OnInit {

  updatePostForm: FormGroup;
  id: number;
  username: string;
  sub: Subscription;

  constructor(private addPostService: AddPostService, private router: Router, private route: ActivatedRoute) {
    this.updatePostForm = new FormGroup({});
  }

  ngOnInit(): void {

    this.initForm();

    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
      
      this.addPostService.findById(this.id).subscribe(post => {
        this.id = post.id;
        
        this.updatePostForm.setValue({
          title: post.title,
          content: post.content,
          id: post.id,
          username: post.username
        
        })
       this.username = post.username;
       console.log(this.username);
        // post.username = this.username
      })
    })
 
  }

  initForm(){
    this.updatePostForm = new FormGroup({
      title: new FormControl(''),
      content: new FormControl(''),
      id: new FormControl(0),
      username: new FormControl('')
    });
console.log(this.updatePostForm);
  }

  updatePost(){

    const formValues = {
      id:this.id,
      title: this.updatePostForm.value.title,
      content: this.updatePostForm.value.content,
      username: this.username
    }  

    console.log(formValues);
    
    this.addPostService.update(formValues).subscribe(
      resp => {
        console.log("modification effectuée")
       this.router.navigateByUrl("/blog")
      }
    )
  }

}
