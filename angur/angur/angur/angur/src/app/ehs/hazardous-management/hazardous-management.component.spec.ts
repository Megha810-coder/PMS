import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HazardousManagementComponent } from './hazardous-management.component';

describe('HazardousManagementComponent', () => {
  let component: HazardousManagementComponent;
  let fixture: ComponentFixture<HazardousManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HazardousManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HazardousManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
