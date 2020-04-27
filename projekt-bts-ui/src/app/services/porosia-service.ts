import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {CreatePorosi} from '../classes/porosia/create-porosi';
import {Porosia} from '../classes/porosia/porosia';
import {Product} from '../classes/product/product';
import {PorosiaDetajet} from '../classes/porosia/porosia-detajet';

@Injectable({
  providedIn: 'root'
})
export class PorosiaService {

  public options = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  constructor(private http: HttpClient) { }

  create(porosia) {
    return this.http.post<CreatePorosi>(`${environment.domain}/porosia`, porosia, this.options);
  }

  getAll(){
    return this.http.get<Array<Porosia>>(`${environment.domain}/porosia`);
  }

  getOne(id){
    let httpParams = new HttpParams().set('id', id);
    let parameter = { params: httpParams };

    return this.http.get<PorosiaDetajet>(`${environment.domain}/porosia/get-one`, parameter);
  }

  anulo(id){
    let httpParams = new HttpParams().set('id', id);
    let parameter = { params: httpParams };

    return this.http.get<PorosiaDetajet>(`${environment.domain}/porosia/anulo`, parameter);
  }

  dergo(id){
    let httpParams = new HttpParams().set('id', id);
    let parameter = { params: httpParams };

    return this.http.get<PorosiaDetajet>(`${environment.domain}/porosia/dergo`, parameter);
  }


}
