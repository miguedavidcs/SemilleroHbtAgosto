import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ComicDTO } from '../../dto/comic.dto';


@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html'
})
export class GestionarComicComponent implements OnInit {
  public gestionarComicForm: FormGroup;
  public comicDTO: ComicDTO;
  public comicDTOData: ComicDTO;
  public listaComics: Array<ComicDTO>;
  public mostrarItem: boolean;
  public eliminadoItem: boolean;
  public tituloComplemento: any;
  public mostrarData: boolean;
  public validoFormulario: boolean;

  constructor(private formBuilder: FormBuilder, private router : Router) {
    this.gestionarComicForm = this.formBuilder.group([{
      nombre: [null, [Validators.required, Validators.maxLength(50)]],
      editorial: [null, [Validators.required, Validators.maxLength(50)]],
      tematicaEnum: [null, Validators.required],
      coleccion: [null,[Validators.required, Validators.maxLength(50)] ],
      numeroPaginas: [null, [Validators.required, Validators.maxLength(5)]],
      precio: [null, Validators.required,[Validators.required, Validators.maxLength(4)]],
      autores: [null],
      color: [true],
      cantidad: [null],
      estadoEnum: [null,[Validators.required, Validators.maxLength(3)]],

    }]);
  }

  ngOnInit() {
    this.tituloComplemento = {
      nombreSemillero: "Semillero 2022"
    }
    this.listaComics = new Array<ComicDTO>();
    this.comicDTO = new ComicDTO();

  }

  public crearComic(): void {
    if(this.gestionarComicForm.invalid){
      this.validoFormulario =true;
      return;
    }
    this.validoFormulario =false;
    this.comicDTO = this.gestionarComicForm.value;
    this.listaComics.push(this.comicDTO);
    this.mostrarItem = true;
    this.limpiarForm();
  }
  private limpiarForm():void{
    this.gestionarComicForm.reset();//opcion 1 Limpliar Formulario
    /* opcion 2 ----Limpliar Formulario----
    this.f.nombre.setValue(null);
    this.f.editorial.setValue(null);
    this.f.tematicaEnum.setValue(null);
    this.f.coleccion.setValue(null);
    this.f.numeroPaginas.setValue(null);
    this.f.precio.setValue(null);
    this.f.autores.setValue(null);
    this.f.color.setValue(true);
    this.f.cantidad.setValue(null);
    this.f.estadoEnum.setValue(null);*/
  }


  public cerrar(): void {
    this.mostrarItem = false;
    this.mostrarData = false;
    this.eliminadoItem = false;
  }

  public imprimirDataComic(indice: number): void {
    this.comicDTOData = this.listaComics[indice];
    this.mostrarData = true;
  }
  public EliminarDataComic(indice: number): void {
    this.comicDTOData = this.listaComics[indice];
    this.listaComics.splice(indice, 1);
    this.eliminadoItem = true;
  }
  get f(){
    return this.gestionarComicForm.controls;
  }

}