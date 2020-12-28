import { Component, OnInit } from '@angular/core';

import Book from '../Book';
import { BooksService } from '../books.service';
@Component({
 selector: 'app-book-get',
 templateUrl: './book-get.component.html',
 styleUrls: ['./book-get.component.css']
})
export class BookGetComponent implements OnInit {
prix:any;
 liste : number[] =[] ;

books!:Book[];
sum: number = 0 ;
  list: any;
  index: number = 0 ;

 constructor(private ps: BooksService) {
  }
 ngOnInit() {
  this.ps
  .getAllLivres()
 .subscribe((data:any)=>{ this.books=data});
 
}
 calculer(id:number,quantite:number)
{
  this.ps.calculersomme(id,quantite).subscribe((x)=>{ 
    console.log(x);
    this.prix=x; 
    this.sum=this.prix+this.sum
    this.liste.push(this.prix)
  this.index ++

  })
 
 } 

deleteBook(id:number) {
  this.ps.deleteBook(id).subscribe(res => {
    this.books.splice(id, 1);
    this.ps
    .getAllLivres()
    .subscribe((data: any) => {this.books = data;
  });
  });
}

}