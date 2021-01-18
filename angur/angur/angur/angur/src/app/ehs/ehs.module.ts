import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WasteManagementComponent } from './waste-management/waste-management.component';
import { EhsRoutingModule } from './ehs-routing.module';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { WasteFormComponent } from './waste-form/waste-form.component';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { HazardousManagementComponent } from './hazardous-management/hazardous-management.component';
import { HazardousFormComponent } from './hazardous-form/hazardous-form.component';


@NgModule({
  declarations: [WasteManagementComponent, WasteFormComponent, HazardousManagementComponent, HazardousFormComponent],
  exports: [WasteManagementComponent],
  imports: [
    CommonModule,EhsRoutingModule,TabsModule,BsDropdownModule,DatePickerModule
  ]
})
export class EHSModule { }
