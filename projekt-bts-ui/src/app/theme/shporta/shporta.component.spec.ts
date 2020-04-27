import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShportaComponent } from './shporta.component';

describe('SimplePageComponent', () => {
  let component: ShportaComponent;
  let fixture: ComponentFixture<ShportaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShportaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShportaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
