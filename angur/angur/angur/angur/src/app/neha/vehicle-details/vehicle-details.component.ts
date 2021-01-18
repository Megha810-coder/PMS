import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.scss']
})
export class VehicleDetailsComponent implements OnInit {
  private pro:Pro;
  constructor(private http: HttpClient,private proService:ProService) { }
  readonly APP_URL = "http://localhost:8082/ERP-Company/";
  
 
// onClickSubmit(data) {
//   console.log(data);
 
//   this.http.post(this.APP_URL +'product/save_vehicle', JSON.stringify(data))
//     .subscribe(res => {
//            console.log('inside postmehtod of sub.function', res);//only objects
//         })
    
// }


// }
ngOnInit() {
  this.pro = this.proService.getter();
}
onClickSubmit() {


if(this.pro.vehicle_id==undefined){
this.proService.createVehicle(this.pro).subscribe((pro)=>{
  console.log(pro);
},(error)=>{
  console.log(error);
});

}
else{
this.proService.updateVehicle(this.pro).subscribe((pro)=>{
 console.log(pro);
},(error)=>{
console.log(error);
});
}



}

}
