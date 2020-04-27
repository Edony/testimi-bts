import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaPorosiveComponent } from './lista-porosive.component';
import {ListaPorosiveRoutingModule} from './lista-porosive-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ToastyModule} from 'ng2-toasty';

@NgModule({
    imports: [
        CommonModule,
        ListaPorosiveRoutingModule,
        SharedModule,
        ToastyModule
    ],
  declarations: [ListaPorosiveComponent]
})
export class ListaPorosiveModule { }
