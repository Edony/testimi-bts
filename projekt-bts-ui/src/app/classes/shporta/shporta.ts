import {Product} from '../product/product';

export class Shporta {

  id: number;
  cmimiTotal: number;
  sasia: number;
  product: Product;

  constructor(id: number, cmimiTotal: number, sasia: number, product: Product) {
    this.id = id;
    this.cmimiTotal = cmimiTotal;
    this.sasia = sasia;
    this.product = product;
  }
}
