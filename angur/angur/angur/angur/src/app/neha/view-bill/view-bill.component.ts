import { Component, OnInit } from '@angular/core';
import { Pro } from '../../pro';
import { ProService } from '../../pro.service';

@Component({
  selector: 'app-view-bill',
  templateUrl: './view-bill.component.html',
  styleUrls: ['./view-bill.component.scss']
})
export class ViewBillComponent implements OnInit {

  private pro:Pro;

  constructor(private proService:ProService) { }

  ngOnInit() {
    this.pro = this.proService.getter();

  }
}