import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from } from 'rxjs';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {


  pro_id:any;
  
  product_name:any;
  prod_type:any;
  manufa_order:any;
  manufacturing_date:any;
 
  json_data:any;

  private pro:Pro;
  constructor(private http: HttpClient,private proService:ProService) { }
  readonly APP_URL = "http://localhost:8082/ERP-Company/";
//   ngOnInit() {
//   }
 
// onClickSubmit(data) {
//   console.log(data);
 
//   this.http.post(this.APP_URL +'product/save_product', JSON.stringify(data))
//     .subscribe(res => {
//            console.log('inside postmehtod of sub.function', res);//only objects
//         })
    
// }
ngOnInit() {
  this.pro = this.proService.getter();
}
onClickSubmit() {


if(this.pro.material_id==undefined){
this.proService.createProduct(this.pro).subscribe((pro)=>{
  console.log(pro);
},(error)=>{
  console.log(error);
});

}
else{
this.proService.updateProduct(this.pro).subscribe((pro)=>{
 console.log(pro);
},(error)=>{
console.log(error);
});
}



}

}



