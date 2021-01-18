import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventsComponentComponent } from './events-component/events-component.component';
import { EventFormComponent } from './event-form/event-form.component';
import { InviteFormComponent } from './invite-form/invite-form.component';
import { EmailComponent } from './email/email.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { PackegingComponent } from './packeging-list/packeging.component';
import { PackegingDetailsComponent } from './packeging-details/packeging-details.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { ScrapListComponent } from './scrap-list/scrap-list.component';
import { ScrapDetailsComponent } from './scrap-details/scrap-details.component';
import { BillComponent } from './bill/bill.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';

import { from } from 'rxjs';
import { ViewProductComponent } from './view-product/view-product.component';
import { ViewPackegingComponent } from './view-packeging/view-packeging.component';
import { ViewVehicleComponent } from './view-vehicle/view-vehicle.component';
import { ViewScrapComponent } from './view-scrap/view-scrap.component';
import { ViewBillComponent } from './view-bill/view-bill.component';
export const routes: Routes = [
    {
    path: '',
    data: {
      title: 'neha'
    },
    children: [
     
      {
        path: 'Events',   
        component: EventsComponentComponent,
        data: {
          title: 'Events'
        }
      },
     
    ]
  },
  {
    path: 'Form',
    component: EventFormComponent,
    data: {
      title: 'Form'
    }
  },  
  
  {
    path: 'Invite',
    component: InviteFormComponent,
    data: {
      title: 'Invite'
    }
  },
  


  {
    path: 'Email',
    component: EmailComponent,
    data: {
      title: 'Email'
    }
  },

  {
    path: 'Product',
    component: ProductFormComponent,
    data: {
      title: 'Product'
    }
  },
  {
    path: 'Packeging',
    component: PackegingComponent,
    data: {
      title: 'Packeging'
    }
  },
  {
    path: 'Packeging-Details',
    component: PackegingDetailsComponent,
    data: {
      title: 'Packeging-Details'
    }
  },
  {
    path: 'Product-Details',
    component: ProductDetailsComponent,
    data: {
      title: 'Product-Details'
    }
  }, 
  {
    path: 'Vehicle',
    component: VehicleListComponent,
    data: {
      title: 'Vehicle'
    }
  }, 
  {
    path: 'Vehicle-Details',
    component: VehicleDetailsComponent,
    data: {
      title: 'Vehicle-Details'
    }
  },
  {
    path: 'Scrap',
    component: ScrapListComponent,
    data: {
      title: 'Scrap'
    }
  },
  {
    path: 'Scrap-Details',
    component: ScrapDetailsComponent,
    data: {
      title: 'Scrap-Details'
    }
  },
  {
    path: 'bill',
    component: BillComponent,
    data: {
      title: 'bill'
    }
  },
  {
    path: 'bill-details',
    component: BillDetailsComponent,
    data: {
      title: 'bill-details'
    }
  },
  {
    path: 'view_product',
    component: ViewProductComponent,
    data: {
      title: 'view_product'
    }
  },
  {
    path: 'view_packeging',
    component: ViewPackegingComponent,
    data: {
      title: 'view_packeging'
    }
  },
  {
    path: 'view_vehicle',
    component: ViewVehicleComponent,
    data: {
      title: 'view_vehicle'
    }
  },
  {
    path: 'view_scrap',
    component: ViewScrapComponent,
    data: {
      title: 'view_scrap'
    }
  },
  {
    path: 'view_bill',
    component: ViewBillComponent,
    data: {
      title: 'view_bill'
    }
  },

];
@NgModule({
    imports: [ RouterModule.forChild(routes) ],
    exports: [ RouterModule ]
  })
export class NehaRoutingModule {}
  