import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent implements OnInit {
  myresponse: any;
  title = 'Spring Mvc Angular Tutorial';
  constructor(private proService : ProService,private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
  

  ngOnInit() {
    this._http.get(this.APP_URL + 'product/mng_bill').subscribe(
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
  viewBill(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/view_bill']);
  }
  
  save()
  {
    let pro =new Pro();
    this.proService.setter(pro);
    this.router.navigate(['/neha/bill-details']);
  }

  updateBill(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/bill-details']);
  } 
  DeleteBill(id){
    console.log('this.idmegha',id);
    this._http.get(this.APP_URL + 'product/delete_bill?bill_id='+id).subscribe(
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

 

