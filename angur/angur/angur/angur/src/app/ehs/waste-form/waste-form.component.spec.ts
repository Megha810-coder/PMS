import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WasteFormComponent } from './waste-form.component';

describe('WasteFormComponent', () => {
  let component: WasteFormComponent;
  let fixture: ComponentFixture<WasteFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WasteFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WasteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
