import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShportaComponent } from './shporta.component';
import {ShportaRoutingModule} from './shporta-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ToastyModule} from 'ng2-toasty';
import {FormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    ShportaRoutingModule,
    SharedModule,
    ToastyModule,
    FormsModule
  ],
  declarations: [ShportaComponent]
})
export class ShportaModule { }
