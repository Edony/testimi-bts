import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StokuComponent } from './stoku.component';

describe('SimplePageComponent', () => {
  let component: StokuComponent;
  let fixture: ComponentFixture<StokuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StokuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StokuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
