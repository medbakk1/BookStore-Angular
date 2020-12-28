import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Book from '../Book';
import { BookAddComponent } from '../book-add/book-add.component';
import { BookGetComponent } from '../book-get/book-get.component';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {
quantity!: any;
ps!:BookAddComponent;
p!:PurchaseComponent;
id: number = 0 ;
prix:number=0 ;
liste : Number[] =[] ;
  constructor(private route : ActivatedRoute) { }

  ngOnInit(): void {
;
   this.liste= this.route.snapshot.params['prix'];
   
  }
  buybook(quantity: any){
  
  }

}
