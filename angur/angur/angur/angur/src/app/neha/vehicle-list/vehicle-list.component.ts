import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {
  myresponse: any;
  title = 'Spring Mvc Angular Tutorial';
  constructor(private proService : ProService, private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
 
   ngOnInit() {
    this._http.get(this.APP_URL + 'product/mng_vehicle').subscribe(
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
  viewVehicle(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/view_vehicle']);
  }  
 
  save()
  {
    let pro =new Pro();
    this.proService.setter(pro);
    this.router.navigate(['/neha/Vehicle-Details']);
  }

  updateVehicle(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/Vehicle-Details']);
  } 
  DeleteVehicle(id){
    console.log('this.idmegha',id);
    this._http.get(this.APP_URL + 'product/delete_vehicle?vehicle_id='+id).subscribe(
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

 
