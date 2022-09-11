import { Component, OnInit } from '@angular/core';
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

  constructor(private formBuilder: FormBuilder) {
    this.gestionarComicForm = this.formBuilder.group([{
      nombre: [null, Validators.required],
      editorial: [null, Validators.required],
      tematicaEnum: [null, Validators.required],
      coleccion: [null],
      numeroPaginas: [null, Validators.required],
      precio: [null, Validators.required],
      autores: [null],
      color: [true],
      cantidad: [null],
      estadoEnum: [null],

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
    this.listaComics.push(this.comicDTO);
    this.comicDTO = new ComicDTO();
    this.mostrarItem = true;
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

}