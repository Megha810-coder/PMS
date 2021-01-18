import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackegingComponent } from './packeging.component';

describe('PackegingComponent', () => {
  let component: PackegingComponent;
  let fixture: ComponentFixture<PackegingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackegingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackegingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
