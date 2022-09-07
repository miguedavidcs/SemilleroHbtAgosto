import { EstadoEnum } from "../componentes/crear-persona/enums/estado.enum";
import { TematicaEnum } from "../componentes/crear-persona/enums/tematica.enum";

export class ComicDTO {

    public id : number;
	
	public nombre : string;
	
	public editorial : string;
	
	public tematicaEnum : string;
	
	public coleccion : string;
	
	public numeroPaginas : number;
	
	public precio : number;
	
	public autores : string;

	public color : boolean;
	
	public fechaVenta : Date;
	
	public estadoEnum : EstadoEnum;
	
	public cantidad : number;

    constructor(nombre : string, tematicaEnum : TematicaEnum, precio : number) {
        this.nombre = nombre;
        this.tematicaEnum = tematicaEnum;
        this.precio = precio;
    }
    /*constructor(id : number,nombre : string,editorial : string, tematicaEnum : TematicaEnum,coleccion : string,numeroPaginas : number, 
        precio : number,autores : string,color : boolean,fechaVenta : Date,estadoEnum : EstadoEnum,cantidad : number) {
        this.id = id;
        this.nombre = nombre;
        this.editorial =editorial;
        this.tematicaEnum = tematicaEnum;
        this.coleccion = coleccion;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.autores = autores;
        this.color= color;
        this.fechaVenta = fechaVenta;
        this.estadoEnum = estadoEnum;
        this.cantidad =*/ 
}