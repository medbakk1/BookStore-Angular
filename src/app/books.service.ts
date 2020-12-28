import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import Book from './Book';
@Injectable({
 providedIn: 'root'
})
export class BooksService {
 uri = 'http://localhost:8070/BuildStore/api/livre';
 constructor(private http: HttpClient) { }

getAllLivres(){
  return this.http.get(`${this.uri}/getAllLivres`);
  }

  deleteBook(id:number) {
    return this
              .http
              .delete(`${this.uri}/deleteLivre/${id}`);
  }
  ajouterbook(book:Book) {
   
    
    this.http.post("http://localhost:8070/BuildStore/api/livre/addLivre", book,{responseType : "text" })
        .subscribe(res => console.log("done"));
        
  }
  calculersomme(id:number,quantite:number) {
   
    
   return (this.http.get(`${this.uri}/calculprice/${id}/${quantite}`));
        
  }
  getLivre(){
    return this.http.get(`${this.uri}/getLivre/{id}`);
    }


}
