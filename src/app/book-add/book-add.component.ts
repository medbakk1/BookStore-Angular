import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Book from '../Book';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {
  books!: Book[];
  public angForm!: FormGroup;
  book=new Book();
  constructor(private fb: FormBuilder,private ps:BooksService) {
  this.createForm();
  }
  createForm() {
  this.angForm = this.fb.group({
    author: ['', Validators.required ],
    releaseDate: ['', Validators.required ],
    designation: ['', Validators.required ],
    unitprice: ['', Validators.required ],
    reference: ['', Validators.required ],
    title: ['', Validators.required ]

  });
  }
  addBook() {
    this.book.auteur =this.angForm.get('author')?.value
    this.book.releaseDate=this.angForm.get('releaseDate')?.value
    this.book.designation=this.angForm.get('designation')?.value
    this.book.prixUnitaire =this.angForm.get('unitprice')?.value
    this.book.reference=this.angForm.get('reference')?.value
    this.book.titre=this.angForm.get('title')?.value
    this.ps.ajouterbook(this.book);
    
  }
  
  ngOnInit() {
  this.ps
  .getAllLivres()
 .subscribe((data:any)=>{ this.books=data});
 }
}

 
 