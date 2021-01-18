import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmpComponent } from './emp/emp.component';
import { EmployeeRoutingModule } from './employee-routing.module';

import { TabsModule } from 'ngx-bootstrap/tabs';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
@NgModule({
  declarations: [EmpComponent],
  exports:[EmpComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,TabsModule,DatePickerModule
    
  ]
})
export class EmployeeModule {
  
 }
