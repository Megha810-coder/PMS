import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NehaRoutingModule } from './neha-routing.module';
import { EventsComponentComponent } from './events-component/events-component.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { EventFormComponent } from './event-form/event-form.component';
import { InviteFormComponent } from './invite-form/invite-form.component';
import { EmailComponent } from './email/email.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { from } from 'rxjs';
import { PackegingComponent } from './packeging-list/packeging.component';
import { PackegingDetailsComponent } from './packeging-details/packeging-details.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { ScrapListComponent } from './scrap-list/scrap-list.component';
import { ScrapDetailsComponent } from './scrap-details/scrap-details.component';
import { BillComponent } from './bill/bill.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { ViewPackegingComponent } from './view-packeging/view-packeging.component';
import { ViewVehicleComponent } from './view-vehicle/view-vehicle.component';
import { ViewScrapComponent } from './view-scrap/view-scrap.component';
import { ViewBillComponent } from './view-bill/view-bill.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';



// import { ButtonsComponent } from './buttons.component';

@NgModule({
  declarations: [EventsComponentComponent, EventFormComponent, InviteFormComponent, EmailComponent, ProductFormComponent,ProductDetailsComponent, PackegingComponent, PackegingDetailsComponent, VehicleListComponent, VehicleDetailsComponent, ScrapListComponent, ScrapDetailsComponent, BillComponent, BillDetailsComponent, ViewProductComponent, ViewPackegingComponent, ViewVehicleComponent, ViewScrapComponent, ViewBillComponent],
  exports:[],
  imports: [
    CommonModule,Ng2SearchPipeModule,NehaRoutingModule,BsDropdownModule,TabsModule,DatePickerModule,FormsModule,HttpModule
  ]
})
export class NehaModule { }
