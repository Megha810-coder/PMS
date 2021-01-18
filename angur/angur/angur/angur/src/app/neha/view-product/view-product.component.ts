import { Component, OnInit } from '@angular/core';
import { ProService } from '../../pro.service';
import { Pro } from '../../pro';
import { HttpClient } from 'selenium-webdriver/http';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.scss']
})
export class ViewProductComponent implements OnInit {
  private pro:Pro;

  constructor(private proService:ProService) { }
  
  ngOnInit() {
    this.pro = this.proService.getter();

  }
  
}