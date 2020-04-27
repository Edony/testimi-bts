import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import swal from 'sweetalert2';
import {Ng2ImgMaxService} from 'ng2-img-max';
import {ModalBasicComponent} from '../../shared/modal-basic/modal-basic.component';
import {CreateProduct} from '../../classes/product/create-product';
import {ProductService} from '../../services/product-service';
import {ToastOptions, ToastyService} from 'ng2-toasty';
import {Product} from '../../classes/product/product';
import {animate, style, transition, trigger} from '@angular/animations';
// @ts-ignore
import {FieldError} from '../../classes/common/field-error';
import {UpdateProduct} from '../../classes/product/update-product';

@Component({
  selector: 'app-simple-page',
  templateUrl: './stoku.component.html',
  styleUrls: ['./stoku.component.scss',
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
export class StokuComponent implements OnInit {
  msg = '';
  position = 'bottom-right';
  browseText = 'Browse';
  browseTextEdit = 'Browse';

  products: Array<Product>;

  productId: Number;

  uploadedImage: Blob;
  base64image200x200: string;
  createEmri: String;
  createKodiProduktit: String;
  createPershkrimi: String;
  createSasia: Number;
  createCmimi: Number;

  uploadedImageEdit: Blob;
  base64image200x200Edit: string;
  editEmri: String;
  editKodiProduktit: String;
  editPershkrimi: String;
  editSasia: Number;
  editCmimi: Number;
  editFoto: String;

  emriClass: string;
  kodiProduktitClass: string;
  pershkrimiClass: string;
  sasiaClass: string;
  cmimiClass: string;

  editEmriClass: string;
  editKodiProduktitClass: string;
  editPershkrimiClass: string;
  editSasiaClass: string;
  editCmimiClass: string;

  image: String = null;
  imageEdit: String = null;

  constructor(private ng2ImgMax: Ng2ImgMaxService,
              private productService: ProductService,
              private toastyService: ToastyService) { }

  ngOnInit() {
    this.setDefaultClasses();
    this.setDefaultClassesEdit();
    this.getAll();
  }


  save(modalShtoProdukt: ModalBasicComponent) {
    let product = null;
    if (this.base64image200x200 != null){
      product = new CreateProduct(this.createEmri, this.createKodiProduktit, this.createPershkrimi, this.createSasia, this.createCmimi,this.base64image200x200);
    }else {
      product = new CreateProduct(this.createEmri, this.createKodiProduktit, this.createPershkrimi, this.createSasia, this.createCmimi,"");
    }
    this.productService.save(product).subscribe(
      success => {
        modalShtoProdukt.hide();
        this.msg = 'Produkti u krijua.';
        this.toast();
        this.getAll();
        this.resetFields();
      }, error => {
        this.setDefaultClasses();
        let errors: Array<FieldError> = error.error;
        console.log(errors);
        for (let i = 0; i < errors.length; i++) {
          const error = errors[i];
          if (error.field == 'emri') {
            this.emriClass = 'form-control form-control-danger';
          } else if (error.field == 'cmimi') {
            this.cmimiClass = 'form-control form-control-danger';
          } else if (error.field == 'sasia') {
            this.sasiaClass = 'form-control form-control-danger';
          } else if (error.field == 'kodi') {
            this.kodiProduktitClass = 'form-control form-control-danger';
          } else if (error.field == 'pershkrimi') {
            this.pershkrimiClass = 'form-control form-control-danger';
          }
        }
      }
    );
  }

  update(modalEditoProduct: ModalBasicComponent) {
    let product = null;
    if (this.base64image200x200Edit != null){
      product = new UpdateProduct(this.productId, this.editEmri, this.editKodiProduktit, this.editPershkrimi, this.editSasia, this.editCmimi,this.base64image200x200Edit);
    }else {
      product = new UpdateProduct(this.productId, this.editEmri, this.editKodiProduktit, this.editPershkrimi, this.editSasia, this.editCmimi,this.editFoto);
    }
    this.productService.update(product).subscribe(
      success => {
        modalEditoProduct.hide();
        this.msg = 'Nryshimet jane ruajtur.';
        this.toast();
        this.getAll();
        this.resetFields();
      }, error => {
        this.setDefaultClasses();
        let errors: Array<FieldError> = error.error;
        console.log(errors);
        for (let i = 0; i < errors.length; i++) {
          const error = errors[i];
          if (error.field == 'emri') {
            this.editEmriClass = 'form-control form-control-danger';
          } else if (error.field == 'cmimi') {
            this.editCmimiClass = 'form-control form-control-danger';
          } else if (error.field == 'sasia') {
            this.editSasiaClass = 'form-control form-control-danger';
          } else if (error.field == 'kodi') {
            this.editKodiProduktitClass = 'form-control form-control-danger';
          } else if (error.field == 'pershkrimi') {
            this.editPershkrimiClass = 'form-control form-control-danger';
          }
        }
      }
    );
  }

  getAll() {
    this.productService.getAll().subscribe(
      success => {
        this.products = success;
      }
    );
  }

  getOne(id) {
    this.productService.getOne(id).subscribe(
      success => {
        this.productId = id;
        this.editEmri = success.emri;
        this.editKodiProduktit = success.kodi;
        this.editPershkrimi = success.pershkrimi;
        this.editSasia = success.sasia;
        this.editCmimi = success.cmimi;
        this.editFoto = success.foto;
      }
    );
  }

  onImageChange(event) {
    let image = event.target.files[0];
    if (image != undefined) {
      this.ng2ImgMax.resizeImage(image, 500, 500).subscribe(
        result => {
          this.uploadedImage = result;
          this.showImagePreview200x200(this.uploadedImage);
        },
        error => {
          console.log('Error: ', error);
        }
      );
    }
  }

  onImageChangeEdit(event) {
    let image = event.target.files[0];
    if (image != undefined) {
      this.ng2ImgMax.resizeImage(image, 500, 500).subscribe(
        result => {
          this.uploadedImageEdit = result;
          this.showImagePreview200x200Edit(this.uploadedImageEdit);
        },
        error => {
          console.log('Error: ', error);
        }
      );
    }
  }

  openDialog() {
    document.getElementById('browse-id').click();
  }

  openDialogEdit() {
    document.getElementById('browse-id-edit').click();
  }

  showImagePreview200x200(blob: Blob) {
    var that = this;
    var reader = new FileReader();
    reader.readAsDataURL(blob);
    reader.onloadend = function () {
      that.base64image200x200 = reader.result;
      document.getElementById('img').setAttribute('src', reader.result);
    };
  }

  showImagePreview200x200Edit(blob: Blob) {
    var that = this;
    var reader = new FileReader();
    reader.readAsDataURL(blob);
    reader.onloadend = function () {
      that.base64image200x200Edit = reader.result;
      document.getElementById('img-edit').setAttribute('src', reader.result);
    };
  }

  setDefaultClasses(){
    this.emriClass = 'form-control form-control-primary';
    this.kodiProduktitClass = 'form-control form-control-primary';
    this.pershkrimiClass = 'form-control form-control-primary';
    this.sasiaClass = 'form-control form-control-primary';
    this.cmimiClass = 'form-control form-control-primary';
  }

  setDefaultClassesEdit(){
    this.editEmriClass = 'form-control form-control-primary';
    this.editKodiProduktitClass = 'form-control form-control-primary';
    this.editPershkrimiClass = 'form-control form-control-primary';
    this.editSasiaClass = 'form-control form-control-primary';
    this.editCmimiClass = 'form-control form-control-primary';
  }

  resetFields(){
    this.uploadedImage = null;
    this.base64image200x200 = null;
    this.createEmri = "";
    this.createKodiProduktit = "";
    this.createPershkrimi = "";
    this.createSasia = 0;
    this.createCmimi = 0;

    this.image = null;
    this.uploadedImageEdit = null;
    this.base64image200x200Edit = null;
    this.editEmri = "";
    this.editKodiProduktit = "";
    this.editPershkrimi = "";
    this.editSasia = 0;
    this.editCmimi = 0;
  }


  openSuccessCancelSwal(index) {
    swal({
      title: 'A jeni i sigurt?',
      text: 'Ju nuk mund ta ktheni mbrapa kete veprim!',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Po, fshije!',
      cancelButtonText: 'Jo, anulo!',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger mr-sm'
    }).then((result) => {
      if (result.value) {
        swal(
          'Fshirë!',
          'Produkti u fshi.',
          'success'
        );
      } else if (result.dismiss) {
        swal(
          'Anuluar',
          'Fshirja e produktit u anulua ',
          'error'
        );
      }
    });
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
