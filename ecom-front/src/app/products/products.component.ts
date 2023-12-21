import { CatalogueService } from './../catalogue.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})

export class ProductsComponent implements OnInit{
  public products: any;

   constructor (private catService:CatalogueService){

   }
   public getProducts(){
     this.catService.getResource("products").subscribe(data=>{
       this.products = data;
     },err=>{
       console.log(err);
     })
   }

   ngOnInit(): void {
     this.getProducts();
   }
 }
