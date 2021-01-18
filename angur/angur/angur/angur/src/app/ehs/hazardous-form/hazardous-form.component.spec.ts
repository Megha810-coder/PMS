import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HazardousFormComponent } from './hazardous-form.component';

describe('HazardousFormComponent', () => {
  let component: HazardousFormComponent;
  let fixture: ComponentFixture<HazardousFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HazardousFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HazardousFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
