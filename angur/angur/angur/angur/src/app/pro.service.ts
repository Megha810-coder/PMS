import { Injectable } from '@angular/core';
import { Pro } from './pro';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class ProService {
  private baseUrl:String="http://localhost:8082/ERP-Company/";
  private headers = new Headers({'Content-Type':'application/json; charset=utf8'});
  private options = new RequestOptions({headers:this.headers});
  private pro :Pro;
  constructor(private _http:Http) { }
  createProduct(pro:Pro){
    return this._http.post(this.baseUrl+'product/save_product',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateProduct(pro:Pro){
    return this._http.post(this.baseUrl+'product/update_product',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  createPackeging(pro:Pro){
    return this._http.post(this.baseUrl+'product/save_packeging',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updatePackeging(pro:Pro){
    return this._http.post(this.baseUrl+'product/update_packeging',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  createVehicle(pro:Pro){
    return this._http.post(this.baseUrl+'product/save_vehicle',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateVehicle(pro:Pro){
    return this._http.post(this.baseUrl+'product/update_vehicle',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  createScrap(pro:Pro){
    return this._http.post(this.baseUrl+'product/save_scrap',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateScrap(pro:Pro){
    return this._http.post(this.baseUrl+'product/update_scrap',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  createBill(pro:Pro){
    return this._http.post(this.baseUrl+'product/save_bill',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }

  updateBill(pro:Pro){
    return this._http.post(this.baseUrl+'product/update_bill',JSON.stringify(pro)).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
  }
  setter(pro:Pro){
    this.pro=pro;
  }
  getter(){
    return this.pro;
  }
}
