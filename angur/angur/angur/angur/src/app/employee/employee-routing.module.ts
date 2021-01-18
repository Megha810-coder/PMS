import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpComponent } from './emp/emp.component';




export const routes: Routes = [
    {
    path: 'employee',
    component: EmpComponent,
    data: {
      title: 'employee'
    },
    children: [
     
      {
        path: 'employee',
        component: EmpComponent,
        data: {
          title: 'employee'
        }
      },
      
    
    ]
  }

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class EmployeeRoutingModule {}
  