import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StokuComponent } from './stoku.component';
import {StokuRoutingModule} from './stoku-routing.module';
import {SharedModule} from '../../shared/shared.module';
import { Ng2ImgMaxModule } from 'ng2-img-max';
import {FormsModule} from '@angular/forms';
import {ToastyModule} from 'ng2-toasty';

@NgModule({
  imports: [
    CommonModule,
    StokuRoutingModule,
    SharedModule,
    Ng2ImgMaxModule,
    FormsModule,
    ToastyModule
  ],
  declarations: [StokuComponent]
})
export class StokuModule { }
