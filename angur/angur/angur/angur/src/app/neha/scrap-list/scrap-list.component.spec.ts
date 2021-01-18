import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScrapListComponent } from './scrap-list.component';

describe('ScrapListComponent', () => {
  let component: ScrapListComponent;
  let fixture: ComponentFixture<ScrapListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScrapListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScrapListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
