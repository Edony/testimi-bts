import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from './layout/admin/admin.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
        path: '',
        redirectTo: 'blej-produkte',
        pathMatch: 'full'
      },
      {
        path: 'blej-produkte',
        loadChildren: './theme/blej-produkte/blej-produkte.module#BlejProdukteModule'
      },
      {
        path: 'shporta',
        loadChildren: './theme/shporta/shporta.module#ShportaModule'
      },
      {
        path: 'lista-porosive',
        loadChildren: './theme/lista-porosive/lista-porosive.module#ListaPorosiveModule'
      },
      {
        path: 'stoku',
        loadChildren: './theme/stoku/stoku.module#StokuModule'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
