import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InductionComponentComponent } from './induction-component.component';

describe('InductionComponentComponent', () => {
  let component: InductionComponentComponent;
  let fixture: ComponentFixture<InductionComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InductionComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InductionComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
