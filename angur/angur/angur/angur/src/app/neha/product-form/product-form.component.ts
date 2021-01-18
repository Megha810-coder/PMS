import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {
  myresponse: any;
  title = 'Spring Mvc Angular Tutorial';
  constructor(private proService : ProService, private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
  private pro:Pro[];
 
 
 
   
   
 
   ngOnInit() {
   
    this._http.get(this.APP_URL + 'product/mng_product').subscribe(
      result => {
 
        console.log('hiii') ;
        this.myresponse = result ;
        console.log('this.myresponse', this.myresponse);
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }
  getAllProduct() {
  
  
    this._http.get(this.APP_URL + 'product/mng_product').subscribe(
      result => {
 
        console.log('hiii') ;
        this.myresponse = result ;
        console.log('this.myresponse', this.myresponse);
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }
  
  viewProduct(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/view_product']);
  }
  save()
  {
    let pro =new Pro();
    this.proService.setter(pro);
    this.router.navigate(['/neha/Product-Details']);
  }

  updateProduct(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/Product-Details']);
  } 


  DeleteProduct(id){
    console.log('this.idmegha',id);
    this._http.get(this.APP_URL + 'product/delete_product?material_id='+id).subscribe(
      result => {
        alert("delete successfully!!!!");
        window.location.reload()
        // this.router.navigate(['/ehs_module/Waste']);
       
        this.myresponse = result ;
        console.log('this.myresponse', this.myresponse);
       
      },
      error => {
        console.log('Error occured', error);
      }
     ) ;

  }

 }
