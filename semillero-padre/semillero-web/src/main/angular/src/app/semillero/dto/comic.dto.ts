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

    public cantidad : number;

    public estadoEnum : string;

    constructor(){
        
    }
}