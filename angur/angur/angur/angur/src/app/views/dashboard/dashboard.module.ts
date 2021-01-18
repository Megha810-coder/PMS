import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { HttpClientModule } from '@angular/common/http';
  import { CommonModule} from '@angular/common';
// import { Component } from '@angular/core';
import { DashboardComponent } from './dashboard.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
// import { BrowserModule } from '@angular/platform-browser';
@NgModule({
  imports: [
    
    FormsModule,
    DashboardRoutingModule,
    ChartsModule,
    BsDropdownModule,
    HttpClientModule,
    // BrowserModule,
     CommonModule,
    // Component,
    ButtonsModule.forRoot()
  ],
  declarations: [ DashboardComponent ]
})
export class DashboardModule { 
 
  
}
