import { Component, OnInit } from '@angular/core';

import {MenuItem} from 'primeng/api';
import {TabMenuModule} from 'primeng/tabmenu';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.scss']
})
export class EmpComponent implements OnInit {

  
  items1: MenuItem[];

  activeItem: MenuItem;

  ngOnInit() {
      this.items1 = [
          {label: 'Stats', icon: 'fa fa-fw fa-bar-chart'},
          {label: 'Calendar', icon: 'fa fa-fw fa-calendar'},
          {label: 'Documentation', icon: 'fa fa-fw fa-book'},
          {label: 'Support', icon: 'fa fa-fw fa-support'},
          {label: 'Social', icon: 'fa fa-fw fa-twitter'}
      ];
    }
  constructor() { }

  
}
