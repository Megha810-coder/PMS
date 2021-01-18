import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPackegingComponent } from './view-packeging.component';

describe('ViewPackegingComponent', () => {
  let component: ViewPackegingComponent;
  let fixture: ComponentFixture<ViewPackegingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPackegingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPackegingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
