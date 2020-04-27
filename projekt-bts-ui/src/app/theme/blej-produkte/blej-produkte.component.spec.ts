import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlejProdukteComponent } from './blej-produkte.component';

describe('SimplePageComponent', () => {
  let component: BlejProdukteComponent;
  let fixture: ComponentFixture<BlejProdukteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlejProdukteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlejProdukteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
