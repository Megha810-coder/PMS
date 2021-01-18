import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-bill-details',
  templateUrl: './bill-details.component.html',
  styleUrls: ['./bill-details.component.scss']
})
export class BillDetailsComponent implements OnInit {

  private pro:Pro;
  constructor(private http: HttpClient,private proService:ProService) { }
  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  
//   ngOnInit() {
//   }
 
// onClickSubmit(data) {
//   console.log(data);
 
//   this.http.post(this.APP_URL +'product/save_bill', JSON.stringify(data))
//     .subscribe(res => {
//            console.log('inside postmehtod of sub.function', res);//only objects
//         })
    
// }
// }
ngOnInit() {
  this.pro = this.proService.getter();
}

// onClickSubmit(data) {
//   console.log(data);

//   this.http.post(this.APP_URL +'product/save_packeging', JSON.stringify(data))
//     .subscribe(res => {
//            console.log('inside postmehtod of sub.function', res);//only objects
//         })
  
// }


// }
onClickSubmit() {


if(this.pro.bill_id==undefined){
this.proService.createBill(this.pro).subscribe((pro)=>{
  console.log(pro);
},(error)=>{
  console.log(error);
});

}
else{
this.proService.updateBill(this.pro).subscribe((pro)=>{
 console.log(pro);
},(error)=>{
console.log(error);
});
}



}

}
