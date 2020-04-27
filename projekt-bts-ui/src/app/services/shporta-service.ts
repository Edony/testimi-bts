import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Shporta} from '../classes/shporta/shporta';
import {Injectable} from '@angular/core';
import {CreateProduct} from '../classes/product/create-product';

@Injectable({
  providedIn: 'root'
})
export class ShportaService {

  public options = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  constructor(private http: HttpClient) { }

  create(shporta) {
    return this.http.post<CreateProduct>(`${environment.domain}/shporta-product`, shporta, this.options);
  }

  getAll(){
    return this.http.get<Array<Shporta>>(`${environment.domain}/shporta-product`);
  }

  delete(id){
    let httpParams = new HttpParams().set('id', id);
    let parameter = { params: httpParams };

    return this.http.get<Boolean>(`${environment.domain}/shporta-product/delete`, parameter);
  }

  shtoSasi(id, sasia){
    let httpParams = new HttpParams().set('id', id).set('sasia', sasia);
    let parameter = { params: httpParams };

    return this.http.get<Boolean>(`${environment.domain}/shporta-product/shto-sasi`, parameter);
  }

}
