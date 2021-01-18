import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';



// Buttons Routing
import { ButtonsRoutingModule } from './buttons-routing.module';

// Angular

@NgModule({
  imports: [
    CommonModule,
    ButtonsRoutingModule,
  
    FormsModule
  ],
  declarations: [
   
  ]
})
export class ButtonsModule { }
