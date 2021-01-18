import { Component, OnInit } from '@angular/core';
import { Pro } from '../../pro';
import { ProService } from '../../pro.service';

@Component({
  selector: 'app-view-scrap',
  templateUrl: './view-scrap.component.html',
  styleUrls: ['./view-scrap.component.scss']
})
export class ViewScrapComponent implements OnInit {
  private pro:Pro;

  constructor(private proService:ProService) { }

  ngOnInit() {
    this.pro = this.proService.getter();

  }
}
