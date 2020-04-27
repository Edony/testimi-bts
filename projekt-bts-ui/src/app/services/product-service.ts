import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Product} from '../classes/product/product';
import {environment} from '../../environments/environment';
import {CreateProduct} from '../classes/product/create-product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public options = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get<Array<Product>>(`${environment.domain}/product`);
  }

  save(product) {
    return this.http.post<CreateProduct>(`${environment.domain}/product`, product, this.options);
  }

  update(product) {
    return this.http.put<Product>(`${environment.domain}/product`, product, this.options);
  }

  getOne(id){
    let httpParams = new HttpParams().set('id', id);
    let parameter = { params: httpParams };

    return this.http.get<Product>(`${environment.domain}/product/get-one`, parameter);
  }


}
