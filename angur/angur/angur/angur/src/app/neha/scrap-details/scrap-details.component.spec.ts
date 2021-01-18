import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScrapDetailsComponent } from './scrap-details.component';

describe('ScrapDetailsComponent', () => {
  let component: ScrapDetailsComponent;
  let fixture: ComponentFixture<ScrapDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScrapDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScrapDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
