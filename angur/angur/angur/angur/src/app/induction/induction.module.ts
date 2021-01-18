import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InductionComponentComponent } from './induction-component/induction-component.component';
import { InductionRoutingModule } from './induction-routing.module';
import { AppraisalComponent } from './appraisal/appraisal.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';

@NgModule({
  declarations: [InductionComponentComponent,AppraisalComponent],
exports:[],
  imports: [
    CommonModule,InductionRoutingModule,TabsModule,DatePickerModule,DateTimePickerModule,
  ]
})
export class InductionModule { }
