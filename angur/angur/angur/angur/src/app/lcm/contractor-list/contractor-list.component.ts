import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-contractor-list',
  templateUrl: './contractor-list.component.html',
  styleUrls: ['./contractor-list.component.scss']
})
export class ContractorListComponent implements OnInit {



  myresponse: any;
  // employees = new Array<Employee>();
   title = 'Spring Mvc Angular Tutorial';
  // radioModel: string = 'Month';
  constructor(private router: Router,private _http: HttpClient) {
 
   }
    readonly APP_URL = 'http://localhost:9999/ERP-Company/';
 


    getAllContractors() {
   
   
    this._http.get(this.APP_URL + 'labour/mng_contract').subscribe(
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
