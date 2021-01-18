import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContractorListComponent } from './contractor-list/contractor-list.component';
import { LcmRoutingModule } from './lcm-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ContractorFormComponent } from './contractor-form/contractor-form.component';
import { LabourCheckComponent } from './labour-check/labour-check.component';

@NgModule({
  declarations: [ContractorListComponent, ContractorFormComponent, LabourCheckComponent],
  exports: [ContractorListComponent],
  imports: [
    CommonModule,LcmRoutingModule,  HttpClientModule,
  ]
})
export class LcmModule { }
