import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackegingDetailsComponent } from './packeging-details.component';

describe('PackegingDetailsComponent', () => {
  let component: PackegingDetailsComponent;
  let fixture: ComponentFixture<PackegingDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackegingDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackegingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
