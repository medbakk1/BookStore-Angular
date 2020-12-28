import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookAddComponent } from './book-add/book-add.component';
import { BookGetComponent } from './book-get/book-get.component';
import { BookEditComponent } from './book-edit/book-edit.component';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BooksService } from './books.service';
import { PurchaseComponent } from './purchase/purchase.component';
import { LineServeiceComponent } from './lineService/line-serveice/line-serveice.component';




@NgModule({
  declarations: [
    AppComponent,
    BookAddComponent,
    BookGetComponent,
    BookEditComponent,
    PurchaseComponent,
    LineServeiceComponent
  ],
  imports: [
 
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    ReactiveFormsModule,
    HttpClientModule


  ],
  providers: [ BooksService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
