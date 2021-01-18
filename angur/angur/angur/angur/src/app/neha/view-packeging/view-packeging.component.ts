import { Component, OnInit } from '@angular/core';
import { Pro } from '../../pro';
import { ProService } from '../../pro.service';

@Component({
  selector: 'app-view-packeging',
  templateUrl: './view-packeging.component.html',
  styleUrls: ['./view-packeging.component.scss']
})
export class ViewPackegingComponent implements OnInit {
  private pro:Pro;

  constructor(private proService:ProService) { }

  ngOnInit() {
    this.pro = this.proService.getter();

  }
}