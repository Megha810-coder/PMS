import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-packeging',
  templateUrl: './packeging.component.html',
  styleUrls: ['./packeging.component.scss']
})
export class PackegingComponent implements OnInit {
  myresponse: any;
  title = 'Spring Mvc Angular Tutorial';
  constructor(private proService : ProService,private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
 
   ngOnInit() {
    this._http.get(this.APP_URL + 'product/mng_packeging').subscribe(
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
  
  
    this._http.get(this.APP_URL + 'product/mng_packeging').subscribe(
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
  
  viewPackeging(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/view_packeging']);
  }
 
  save()
  {
    let pro =new Pro();
    this.proService.setter(pro);
    this.router.navigate(['/neha/Packeging-Details']);
  }

  updatePackeging(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/Packeging-Details']);
  } 
  DeletePackeging(id){
    console.log('this.idmegha',id);
    this._http.get(this.APP_URL + 'product/delete_packeging?packeging_id='+id).subscribe(
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

 
 
 