import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
    let menuBtn = document.querySelector("#menu-mobile");
    let firstBar = document.querySelector("#menu-mobile span:first-child");
    let secondBar = document.querySelector("#menu-mobile span:nth-child(2)");
    let thirdBar = document.querySelector("#menu-mobile span:last-child");
    let menuLink = document.querySelectorAll('.menu-list-item a');
    let menu = document.querySelector(".menu");
    menuLink.forEach(link => {
      link.addEventListener("click", () => {
        firstBar?.classList.toggle('transition');
        secondBar?.classList.toggle('transition2');
        thirdBar?.classList.toggle('transition3');
        menu?.classList.toggle('show');
      })
    });

    menuBtn?.addEventListener("click", () => {
      firstBar?.classList.toggle('transition');
      secondBar?.classList.toggle('transition2');
      thirdBar?.classList.toggle('transition3');
      menu?.classList.toggle('show');
    })

  }

  logout(){
    this.authService.logout();
  }

  // alicia(){
  //   return this.authService.isAuthenticated();
  // } // puis dans TS : appeler la méthode au lieu de auth.service.isauthenticated()

}
