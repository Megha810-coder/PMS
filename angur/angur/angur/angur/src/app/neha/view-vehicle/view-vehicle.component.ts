import { Component, OnInit } from '@angular/core';
import { Pro } from '../../pro';
import { ProService } from '../../pro.service';

@Component({
  selector: 'app-view-vehicle',
  templateUrl: './view-vehicle.component.html',
  styleUrls: ['./view-vehicle.component.scss']
})
export class ViewVehicleComponent implements OnInit {
  private pro:Pro;

  constructor(private proService:ProService) { }

  ngOnInit() {
    this.pro = this.proService.getter();

  }
}
