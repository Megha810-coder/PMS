import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-hazardous-management',
  templateUrl: './hazardous-management.component.html',
  styleUrls: ['./hazardous-management.component.scss']
})
export class HazardousManagementComponent implements OnInit {



  myresponse: any;
  // employees = new Array<Employee>();
   title = 'Spring Mvc Angular Tutorial';
  // radioModel: string = 'Month';
  constructor(private router: Router,private _http: HttpClient) {
 
   }
    readonly APP_URL = 'http://localhost:9999/ERP-Company/';
 


    getAllHazardousList() {
   
   
    this._http.get(this.APP_URL + 'ehs/mng_hazardous').subscribe(
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

  ngOnInit(): void {
  }




}
