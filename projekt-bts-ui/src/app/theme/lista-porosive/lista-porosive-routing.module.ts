import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListaPorosiveComponent} from './lista-porosive.component';

const routes: Routes = [
  {
    path: '',
    component: ListaPorosiveComponent,
    data: {
      title: 'Lista Porosive',
      icon: 'icon-layout-sidebar-left',
      status: true
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListaPorosiveRoutingModule { }
