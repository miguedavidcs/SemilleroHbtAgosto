import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dto/comic.dto';
import { ComprarDTO } from '../dto/Comprar.dto';
import { AbstractService } from './template.service';

@Injectable({
  providedIn: 'root'
})
export class GestionarComicService extends AbstractService{

  constructor(private injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }

   
  public crearComics(comicDTO: ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/gestionarComic/crearComic', comicDTO);
  }
  public comprarComic(compraDTO : ComprarDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/gestionarCompra/comprarComic',compraDTO);
  }
       
  
  public obtenerComic(): Observable<any> {
    
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionarComic/obtenerComics');
         
  }

  
  public consultarComic(idComic: Number): Observable<any> {
    let params = new HttpParams().set('idComic', idComic.toString());
    return this.httpClient.get(`http://localhost:8085/semillero-servicios/rest/gestionarComic/consultarComic`,
      { params: params })
  }

  
  public actualizarComic(comicDTO: ComicDTO): Observable<any> {
    return this.httpClient.patch('http://localhost:8085/semillero-servicios/rest/gestionarComic/actualizarComic', comicDTO);
  }

  
  public eliminarComic(idComic: Number): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/gestionarComic/eliminarComic', idComic);
  }

  public venderComic(comicDTO: ComicDTO): Observable<any> {
    return this.httpClient.patch('http://localhost:8085/semillero-servicios/rest/gestionarVentaComic/venderComic', comicDTO);
  }

}