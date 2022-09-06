import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {
  // Aparecer son como los atributos
  // (private) no se utilizan en html los demas si
  // Metodo de Acceso,    nombre              : tipo de Variable,="Valor de la variable"
     private              Saludoski   : String           ="Bienvenido"

  constructor() { }

  ngOnInit() {
  }

}
