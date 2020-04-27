import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StokuComponent} from './stoku.component';

const routes: Routes = [
  {
    path: '',
    component: StokuComponent,
    data: {
      title: 'Stoku',
      icon: 'icon-layout-sidebar-left',
      status: true
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StokuRoutingModule { }
