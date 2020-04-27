import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPorosiveComponent } from './lista-porosive.component';

describe('SimplePageComponent', () => {
  let component: ListaPorosiveComponent;
  let fixture: ComponentFixture<ListaPorosiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaPorosiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaPorosiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
