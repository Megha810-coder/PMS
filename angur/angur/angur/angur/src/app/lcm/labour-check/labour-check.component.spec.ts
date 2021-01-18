import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LabourCheckComponent } from './labour-check.component';

describe('LabourCheckComponent', () => {
  let component: LabourCheckComponent;
  let fixture: ComponentFixture<LabourCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LabourCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LabourCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
