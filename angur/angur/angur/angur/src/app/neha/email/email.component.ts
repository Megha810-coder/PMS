import { Component, OnInit, ViewChild } from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.scss']
})
export class EmailComponent implements OnInit {
  myresponse: any;
  http: any;
  constructor(private router: Router,private _http: HttpClient) { }
  readonly APP_URL = 'http://localhost:8082/ERP-Company/';
  loading = false;
  buttionText = "Submit";
  element: HTMLElement;
  logo:any;
  selectedFiles: FileList;
  fileName: string;
  
 
  detectFiles(event) {
    this.selectedFiles = event.target.files;
    this.fileName = this.selectedFiles[0].name;
    console.log('selectedFiles: ' + this.fileName );
    alert(this.fileName);
  }

  
  mail(data) {
    var urlName="E:/erp_lcm/src/main/webapp/resources/cd_img/" + this.fileName;
    var upload={"to":data.to, "gmailuser":data.gmailuser,"gmailpass":data.gmailpass,"subject":data.subject,"message":data.message,"file":urlName}
    this._http.post(this.APP_URL +'mail/maill', JSON.stringify(upload))
      .subscribe(res => {
             console.log('inside postmehtod of sub.function', res);//only objects
          })
      
  }

  ngOnInit() {
  }
  
  @ViewChild('infoModal') public infoModal: ModalDirective;
 
}

