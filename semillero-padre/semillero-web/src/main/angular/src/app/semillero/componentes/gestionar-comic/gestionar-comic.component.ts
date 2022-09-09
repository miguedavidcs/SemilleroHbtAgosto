import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html',
  
})
export class GestionarComicComponent implements OnInit {
  public listaComics : any;
  public mostrarItem : boolean;
  public mostrarData : boolean;


  constructor() { }

  ngOnInit() {
  }

}
