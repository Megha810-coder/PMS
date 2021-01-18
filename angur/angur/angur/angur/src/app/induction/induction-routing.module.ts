import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InductionComponentComponent } from './induction-component/induction-component.component';
import { AppraisalComponent } from './appraisal/appraisal.component';
export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'induction'
    },
    children: [
     
      {
        path: 'Induction-form',   
        component: InductionComponentComponent,
        data: {
          title: 'Induction-form'
        }
      },

        
      {
        path: 'Appraisal-Form',   
        component: AppraisalComponent,
        data: {
          title: 'Appraisal-Form'
        }
      },
     
     
    ]
  },
//   {
//     path: 'Form',
//     component: EventFormComponent,
//     data: {
//       title: 'Form'
//     }
//   },  
  
//   {
//     path: 'Invite',
//     component: InviteFormComponent,
//     data: {
//       title: 'Invite'
//     }
//   },
  


//   {
//     path: 'Email',
//     component: EmailComponent,
//     data: {
//       title: 'Email'
//     }
//   },

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class InductionRoutingModule {}
  