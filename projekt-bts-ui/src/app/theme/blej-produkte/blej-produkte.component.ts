import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ProductService} from '../../services/product-service';
import {Product} from '../../classes/product/product';
import {CreateShporta} from '../../classes/shporta/create-shporta';
import {ToastOptions, ToastyService} from 'ng2-toasty';
import {animate, style, transition, trigger} from '@angular/animations';
import {ShportaService} from '../../services/shporta-service';

@Component({
  selector: 'app-simple-page',
  templateUrl: './blej-produkte.component.html',
  styleUrls: ['./blej-produkte.component.scss',
    '../../../assets/icon/icofont/css/icofont.scss',
    '../../../../node_modules/ng2-toasty/style-material.css'],
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('fadeInOutTranslate', [
      transition(':enter', [
        style({opacity: 0}),
        animate('400ms ease-in-out', style({opacity: 1}))
      ]),
      transition(':leave', [
        style({transform: 'translate(0)'}),
        animate('400ms ease-in-out', style({opacity: 0}))
      ])
    ])
  ]
})
export class BlejProdukteComponent implements OnInit {
  msg = '';
  position = 'bottom-right';

  products: Array<Product>;

  constructor(private productService: ProductService,
              private shportaService: ShportaService,
              private toastyService: ToastyService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(
      success => {
        this.products = success;
      }
    );
  }

  create(id) {
    this.shportaService.create(new CreateShporta(id,1)).subscribe(
      success => {
        this.msg = 'Produkti u shtua ne shporte.';
        this.toast();
        this.getAll();
      }
    );
  }

  toast() {
    this.toastyService.clearAll();
    const toastOptions: ToastOptions = {
      title: 'SUKSES',
      msg: this.msg,
      showClose: true,
      timeout: 6000,
      theme: 'material'
    };
    this.toastyService.success(toastOptions);
  }

}
