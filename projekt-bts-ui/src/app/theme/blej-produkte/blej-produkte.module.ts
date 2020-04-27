import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlejProdukteComponent } from './blej-produkte.component';
import {BlejProdukteRoutingModule} from './blej-produkte-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ToastyModule} from 'ng2-toasty';

@NgModule({
    imports: [
        CommonModule,
        BlejProdukteRoutingModule,
        SharedModule,
        ToastyModule
    ],
  declarations: [BlejProdukteComponent]
})
export class BlejProdukteModule { }
