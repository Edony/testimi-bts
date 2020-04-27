import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ShportaComponent} from './shporta.component';

const routes: Routes = [
  {
    path: '',
    component: ShportaComponent,
    data: {
      title: 'Shporta',
      icon: 'icon-layout-sidebar-left',
      status: true
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShportaRoutingModule { }
