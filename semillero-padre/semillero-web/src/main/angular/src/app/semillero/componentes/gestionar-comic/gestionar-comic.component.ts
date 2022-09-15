import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ComicDTO } from 'src/app/semillero/dto/comic.dto';
import { GestionarComicService } from '../../servicios/gestionar-comic.service';
@Component({
  selector: 'gestionar-comic',
  templateUrl: './gestionar-comic.component.html',
})
export class GestionarComicComponent implements OnInit {

 
  public comicDTO: ComicDTO;

  public gestionarComicForm: FormGroup;
 
  public comicDTOInfo: ComicDTO;

  public listaComics: Array<ComicDTO>;

 
  public mostrarItem: boolean;

  
  public index: number;

  
  public modal: HTMLElement;

  public submitted: Boolean;

  public mensajeEjecucion: String;
   constructor(private fb: FormBuilder, private router: Router, private gestionComicService: GestionarComicService) {
    this.gestionarComicForm = this.fb.group({
      id: [null],
      nombre: [null, [Validators.required, Validators.maxLength(50)]],
      editorial: [null, [Validators.required, Validators.maxLength(50)]],
      tematicaEnum: [null, Validators.required],
      coleccion: [null, [Validators.required, Validators.maxLength(50)]],
      numeroPaginas: [null, [Validators.required, Validators.maxLength(5)]],
      precio: [null, [Validators.required, Validators.maxLength(4)]],
      autores: [null],
      color: [null],
      cantidad: [null, [Validators.required, Validators.maxLength(3)]],
    })
  }

 
  ngOnInit() {
    this.comicDTO = new ComicDTO();
    this.submitted = false;
    this.mostrarItem = false;
    this.listaComics = new Array<ComicDTO>();
    this.obtenerComics();
    this.index = -1;
    this.modal = document.getElementById('myModal');
    
  }

 
  public crearComic(): void {
    if (this.gestionarComicForm.invalid) {
      return;
    }

    this.comicDTO = new ComicDTO();
    this.comicDTO.nombre = this.gestionarComicForm.controls.nombre.value;
    this.comicDTO.editorial = this.gestionarComicForm.controls.editorial.value;
    this.comicDTO.tematicaEnum = this.gestionarComicForm.controls.tematicaEnum.value;
    this.comicDTO.coleccion = this.gestionarComicForm.controls.coleccion.value;
    this.comicDTO.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
    this.comicDTO.precio = this.gestionarComicForm.controls.precio.value;
    this.comicDTO.autores = this.gestionarComicForm.controls.autores.value;
    this.comicDTO.color = this.gestionarComicForm.controls.color.value;
    this.comicDTO.cantidad = this.gestionarComicForm.controls.cantidad.value;
    this.comicDTO.estadoEnum = "ACTIVO";

    this.gestionComicService.crearComics(this.comicDTO).subscribe(data => {
      if (data.exitoso) {
        this.mensajeEjecucion = data.mensajeEjecucion;
        this.obtenerComics();
        this.submitted = false;
      } else {
        this.mensajeEjecucion = data.mensajeEjecucion;
      }
      alert(this.mensajeEjecucion);
      this.limpiarDatosComic();
    }, error => {
      console.log(error);
    })

  }

  private obtenerComics() : void {
    this.gestionComicService.obtenerComic().subscribe( (comics : any )=> {
      if(comics[0].exitoso) {
        this.listaComics = comics;
      } else {
        this.mensajeEjecucion = comics[0].mensajeEjecucion;
      }
    });
  }
  public IrAVenderComic(comic: ComicDTO): void {
    this.router.navigate(['gestionar-venta-comic', comic]);
  } 
  public consultarComic(idComic: Number) {
    this.gestionComicService.consultarComic(idComic).subscribe(data => {
      console.log(data);
      if (data.exitoso) {
        this.gestionarComicForm.controls.id.setValue(data.id);
        this.gestionarComicForm.controls.nombre.setValue(data.nombre);
        this.gestionarComicForm.controls.editorial.setValue(data.editorial);
        this.gestionarComicForm.controls.tematicaEnum.setValue(data.tematicaEnum);
        this.gestionarComicForm.controls.coleccion.setValue(data.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(data.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(data.precio);
        this.gestionarComicForm.controls.autores.setValue(data.autores);
        this.gestionarComicForm.controls.color.setValue(data.color);
        this.gestionarComicForm.controls.cantidad.setValue(data.cantidad);
      } else {
        console.log(data.mensajeEjecucion);
      }
    }, error => {
      console.log(error);
    })
  }

  public actualizarComic() {
    this.comicDTO = new ComicDTO();
    this.comicDTO.id = this.gestionarComicForm.controls.id.value;
    this.comicDTO.nombre = this.gestionarComicForm.controls.nombre.value;
    this.comicDTO.editorial = this.gestionarComicForm.controls.editorial.value;
    this.comicDTO.tematicaEnum = this.gestionarComicForm.controls.tematicaEnum.value;
    this.comicDTO.coleccion = this.gestionarComicForm.controls.coleccion.value;
    this.comicDTO.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
    this.comicDTO.precio = this.gestionarComicForm.controls.precio.value;
    this.comicDTO.autores = this.gestionarComicForm.controls.autores.value;
    this.comicDTO.color = this.gestionarComicForm.controls.color.value;
    this.comicDTO.cantidad = this.gestionarComicForm.controls.cantidad.value;
    this.comicDTO.estadoEnum = "ACTIVO";

    this.gestionComicService.actualizarComic(this.comicDTO).subscribe(data => {
      if (data.exitoso) {
        this.obtenerComics();
        alert(data.mensajeEjecucion);
      } else {
        console.log(data.mensajeEjecucion);
      }
    }, error => {
      console.log(error);
    })

    this.index = -1;
  }

  public eliminarComic(idComic: Number): void {
    if (confirm("¿Desea eliminar este registro?")) {
      this.gestionComicService.eliminarComic(idComic).subscribe(eliminar => {
        if (eliminar.exitoso) {
          
          this.obtenerComics();
          alert(eliminar.mensajeEjecucion);
        } else {
          console.log(eliminar.mensajeEjecucion);
        }
      }, error => {
        console.log(error);
      })
    };
  }

  public abrirForm(posicion: number): void {
    this.limpiarDatosComic();
    this.index = posicion;
    let comic = this.listaComics[posicion];
    let idComic = comic.id;

    if (this.index >= 0) {
      this.gestionarComicForm.controls.idComic;
      this.gestionarComicForm.controls.nombre;
      this.gestionarComicForm.controls.editorial;
      this.gestionarComicForm.controls.tematicaEnum;
      this.gestionarComicForm.controls.coleccion;
      this.gestionarComicForm.controls.numeroPaginas;
      this.gestionarComicForm.controls.precio;
      this.gestionarComicForm.controls.autores;
      this.consultarComic(idComic);
    } else {
      this.gestionarComicForm.controls.idComic.enable();
      this.gestionarComicForm.controls.nombre.enable();
      this.gestionarComicForm.controls.editorial.enable();
      this.gestionarComicForm.controls.tematicaEnum.enable();
      this.gestionarComicForm.controls.coleccion.enable();
      this.gestionarComicForm.controls.numeroPaginas.enable();
      this.gestionarComicForm.controls.precio.enable();
      this.gestionarComicForm.controls.autores.enable();
      this.gestionarComicForm.controls.color.enable();
    }

    var inputNombreComic = document.getElementById('nombreComic')

    this.modal.addEventListener('show.bs.modal', function () {
      inputNombreComic.focus()
    })
  }

 
  public guardarComic(): void {
    this.submitted = true;
    if (this.index >= 0) {
      this.actualizarComic();
    } else {
      this.crearComic();
    }
    this.obtenerComics();
  }

  private limpiarDatosComic(): void {
    this.submitted = false;
    this.gestionarComicForm.controls.id.setValue(null);
    this.gestionarComicForm.controls.nombre.setValue(null);
    this.gestionarComicForm.controls.coleccion.setValue(null);
    this.gestionarComicForm.controls.color.setValue(null);
    this.gestionarComicForm.controls.editorial.setValue(null);
    this.gestionarComicForm.controls.tematicaEnum.setValue(null);
    this.gestionarComicForm.controls.precio.setValue(null);
    this.gestionarComicForm.controls.numeroPaginas.setValue(null);
    this.gestionarComicForm.controls.autores.setValue(null);
    this.gestionarComicForm.controls.cantidad.setValue(null);
  }
 
  public imprimirInfoComic(comic: ComicDTO): void {
    this.comicDTOInfo = comic;
    this.mostrarItem = true;
  }

  public cerrar(): void {
    this.mostrarItem = false;
  }
  
  get f() {
    return this.gestionarComicForm.controls
  }
}