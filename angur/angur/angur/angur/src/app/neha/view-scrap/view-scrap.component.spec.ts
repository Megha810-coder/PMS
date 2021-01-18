import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewScrapComponent } from './view-scrap.component';

describe('ViewScrapComponent', () => {
  let component: ViewScrapComponent;
  let fixture: ComponentFixture<ViewScrapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewScrapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewScrapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
