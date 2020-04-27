import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BlejProdukteComponent} from './blej-produkte.component';

const routes: Routes = [
  {
    path: '',
    component: BlejProdukteComponent,
    data: {
      title: 'Blej Produkte',
      icon: 'icon-layout-sidebar-left',
      status: true
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlejProdukteRoutingModule { }
