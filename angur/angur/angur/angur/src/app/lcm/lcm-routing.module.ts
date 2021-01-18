import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractorListComponent } from './contractor-list/contractor-list.component';
import { ContractorFormComponent } from './contractor-form/contractor-form.component';
import { LabourCheckComponent } from './labour-check/labour-check.component';


export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'lcm'
    },
    children: [
     
      {
        path: 'Contractor List',   
        component: ContractorListComponent,
        data: {
          title: 'Contractor List'
        }
      },

      {
        path: 'Contractor Form',   
        component: ContractorFormComponent,
        data: {
          title: 'Contractor Form'
        }
      },

      {
        path: 'Manual Labour Check',   
        component: LabourCheckComponent,
        data: {
          title: 'Manual Labour Check'
        }
      },
     
    ]
  },

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class LcmRoutingModule {}
  