import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';
import { EstadoEnum } from './enums/estado.enum';
import { TematicaEnum } from './enums/tematica.enum';

@Component({
  selector: 'crear-persona',
  templateUrl: './crear-persona.component.html',
  styleUrls: ['./crear-persona.component.css']
})
export class CrearPersonaComponent implements OnInit {
  // Aparecer son como los atributos
  // (private) no se utilizan en html los demas si
  // Metodo de Acceso,    nombre              : tipo de Variable,="Valor de la variable"
   // 1-creamos un atributo publico saludo de tipo string
  public saludo : string;
  // 2-0creamos un atributo publico comic de tipo array
  public comics : Array<any>;
   // 2-0-2creamos un atributo publico comicsTematicaHorro de tipo array
  public comicsTematicaHorror : Array<ComicDTO>;
  // 2-0-2creamos un atributo publico comicsTematicaHumoristico de tipo array
  public comicsTematicaHumoristico : Array<ComicDTO>;
  // Atributo publico para almacenar los Datos del comic
  public nuevoComic: Array<any>;
  // Atributo que guarde el eliminado
  public eliminado:string;
  //Atributo que va mostrar los comic
  public mostrar:string;
  //Atributo del Mensaje
  public mensaje:string;
  //Atributo de validacdion delMensaje
  public validacion:string;
  public imagen : any;
  constructor() { }

  ngOnInit() {
    // 1-se invoca la variable saludo
    this.saludo = "Hola semillero 2022";
    /*
    / 2-0se invoca la variable comics señalando una 
    invocacion del metodo crearcomic();
    
    */
    this.comics = this.crearComic();
    let url = "https://alfabetajuega.com/hero/2022/09/Goku-y-Superman-intercambian-sus-trajes-en-esta-version-alternativa-que-te-encantara.jpg?width=768&aspect_ratio=16:9&format=nowebp";
    let heigth : number = 500;
    let width = 700;
    this.imagen = this.asignarImagen(url, heigth, width);
    /*
    / se creo un map que contine clave tipo string y valor array dto
    /
    */
    let comics = new Map<string,Array<ComicDTO>>();

    this.comicsTematicaHorror = new Array<ComicDTO>()
    //let comicBatman = new ComicDTO("Batman", TematicaEnum.HORROR, 900);
    //let comicDragonBall = new ComicDTO("Dragon Ball", TematicaEnum.HORROR, 800);

    this.comicsTematicaHumoristico = new Array<ComicDTO>()
    //let comicChavo = new ComicDTO("Chavo del 8", TematicaEnum.HUMORISTICO, 1900);
    //let comicChapulin = new ComicDTO("Chapulin colorado", TematicaEnum.HUMORISTICO, 600);

    //this.comicsTematicaHorror.push(comicBatman);
    //this.comicsTematicaHorror.push(comicDragonBall);

    //this.comicsTematicaHumoristico.push(comicChavo);
    //this.comicsTematicaHumoristico.push(comicChapulin);

    comics.set(TematicaEnum.HORROR, this.comicsTematicaHorror);
    comics.set(TematicaEnum.HUMORISTICO,  this.comicsTematicaHumoristico);

    let comicHumoristicos = comics.get(TematicaEnum.HUMORISTICO);
    console.log("Comics humoristicos " + JSON.stringify(comicHumoristicos));

    comics.forEach((value : Array<ComicDTO>, key : string) => {
      if(TematicaEnum.HORROR == key) {
        console.log("Lista comics horror: " + key + " " + JSON.stringify(value) );
      } else {
        console.log("Lista comics humoristico: " + key + " " + JSON.stringify(value) );
      }
      
    });
    this.nuevoComic=new Array<any>();
    this.llenarComic();
    this.mostrar=JSON.stringify(this.nuevoComic);
    this.mensaje;
    this.validacion;

  }
  private asignarImagen(url : string, heigth : number, width : number ) : any {
    return {
      url : url,
      heigth : heigth,
      width : width
    }
  
  }
  /* 2-0-1el methodo privado crearComic()  de tipo Array 
  /obtine cualquier valor (any)dentro de el existe una variable
  / listadeComic de tipo array.
  /se crearon unos comic como ComicLigaJ,ComicMarvel,ComicManga
  / se agregan listaComic.push(comicLigaJ) con elmethodo push
  / retorna la lista
  */
  private crearComic() : Array<any>{
    let listaComics : Array<any>;

    let comicLigaJ : any={
      nombre :"Superman",
      estado :EstadoEnum.ACTIVO,
      precio :600,
      tematica:TematicaEnum.CIENCIA_FICCION,
      fechaventa :new Date()
    }
    let comicMarvel: any={
      nombre :"Wofl-Man",
      estado :EstadoEnum.ACTIVO,
      precio :600,
      tematica:TematicaEnum.HORROR,
      fechaventa :new Date()
    }
    let comicManga : any={
      nombre :"Boruto",
      estado :EstadoEnum.ACTIVO,
      precio :600,
      tematica:TematicaEnum.AVENTURA,
      fechaventa :new Date()
    }
    listaComics = new Array<any>();
    listaComics.push(comicLigaJ);
    listaComics.push(comicManga);
    listaComics.push(comicMarvel);
    //elimina elementos listaComics.splice(0,1);
    return listaComics;
  }
  public mostrarDescripcionImagen() : void {
    console.log(JSON.stringify(this.imagen));
    alert("Info imagen" + JSON.stringify(this.imagen));
  }
  public llenarComic(){
    let comiccreado:any ={}
    comiccreado = {
      'id': 1,
      'nombre': ' batman',
      'editorial': 'marvel',
      'tematica': 'ACCION',
      'numeroPaginas': '120',
      'precio': 10000,
      'autores': 'extranjeros',
      'aColor': 'true',
      'fechaVenta': '2022-10-17',
      'estado': 'ACTIVO',
    };
    this.nuevoComic.push(comiccreado);
    comiccreado = {
      'id': 2,
      'nombre': ' Spider',
      'editorial': 'marvel',
      'tematica': 'AVENTURA',
      'numeroPaginas': '120',
      'precio': 5000,
      'autores': 'extranjeros',
      'aColor': 'true',
      'fechaVenta': '2022-10-17',
      'estado': 'ACTIVO',
    };
    this.nuevoComic.push(comiccreado);
    comiccreado = {
      'id': 3,
      'nombre': ' Mujer maravilla',
      'editorial': 'marvel',
      'tematica': 'AVENTURA',
      'numeroPaginas': '120',
      'precio': 5000,
      'autores': 'extranjeros',
      'aColor': 'true',
      'fechaVenta': '2022-10-17',
      'estado': 'ACTIVO',
    };
    this.nuevoComic.push(comiccreado);
    comiccreado = {
      'id': 4,
      'nombre': ' Locos Adam',
      'editorial': 'marvel',
      'tematica': 'HORROR',
      'numeroPaginas': '120',
      'precio': 5000,
      'autores': 'extranjeros',
      'aColor': 'true',
      'fechaVenta': '2022-10-17',
      'estado': 'ACTIVO',
    };
    this.nuevoComic.push(comiccreado);
    comiccreado = {
      'id': 5,
      'nombre': ' Club10',
      'editorial': 'marvel',
      'tematica': 'AVENTURA',
      'numeroPaginas': '120',
      'precio': 50000,
      'autores': 'extranjeros',
      'aColor': 'true',
      'fechaVenta': '2022-10-17',
      'estado': 'ACTIVO',
    };
    this.nuevoComic.push(comiccreado);

  }
  public eliminar(){
    let eliminado = this.nuevoComic[3];
    this.nuevoComic.splice(3,1);
    this.mensaje = 'Se ha eliminado el comic ' + eliminado.nombre + '  Informacion completa: ' + JSON.stringify(eliminado);
  }

}
