import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { GestionarCompraComicComponent } from './semillero/componentes/gestionar-compra-comic-component/gestionar-compra-comic-component.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent},
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'gestionar-compra-comic-component', component:GestionarCompraComicComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
