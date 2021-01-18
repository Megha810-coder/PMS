import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { WasteManagementComponent } from './waste-management/waste-management.component';
import { WasteFormComponent } from './waste-form/waste-form.component';
import { HazardousManagementComponent } from './hazardous-management/hazardous-management.component';
import { HazardousFormComponent } from './hazardous-form/hazardous-form.component';
export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'ehs'
    },
    children: [
     
      {
        path: 'Waste Management',   
        component: WasteManagementComponent,
        data: {
          title: 'Waste Management'
        }
      },

      {
        path: 'Waste-Form',   
        component: WasteFormComponent,
        data: {
          title: 'Waste-Form'
        }
      },

      {
        path: 'Hazardous Management',   
        component: HazardousManagementComponent,
        data: {
          title: 'Hazardous Management'
        }
      },

      {
        path: 'Hazardous-Form',   
        component: HazardousFormComponent,
        data: {
          title: 'Hazardous-Form'
        }
      },



    ]
  },
];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class EhsRoutingModule {}
  