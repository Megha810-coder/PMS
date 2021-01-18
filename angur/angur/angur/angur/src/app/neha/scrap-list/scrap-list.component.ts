import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';
@Component({
  selector: 'app-scrap-list',
  templateUrl: './scrap-list.component.html',
  styleUrls: ['./scrap-list.component.scss']
})
export class ScrapListComponent implements OnInit {
  myresponse: any;
  title = 'Spring Mvc Angular Tutorial';
  constructor(private proService : ProService,private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';


  ngOnInit() {
    this._http.get(this.APP_URL + 'product/mng_scrap').subscribe(
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
  
  viewScrap(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/view_scrap']);
  }
  
 
  save()
  {
    let pro =new Pro();
    this.proService.setter(pro);
    this.router.navigate(['/neha/Scrap-Details']);
  }

  updateScrap(pro){
    this.proService.setter(pro);
    this.router.navigate(['/neha/Scrap-Details']);
  } 
  DeleteScrap(id){
    console.log('this.idmegha',id);
    this._http.get(this.APP_URL + 'product/delete_scrap?scrap_id='+id).subscribe(
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

