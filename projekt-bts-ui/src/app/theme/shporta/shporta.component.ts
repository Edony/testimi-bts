import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ShportaService} from '../../services/shporta-service';
import {Shporta} from '../../classes/shporta/shporta';
import {animate, style, transition, trigger} from '@angular/animations';
import {ToastOptions, ToastyService} from 'ng2-toasty';
import {PorosiaService} from '../../services/porosia-service';
import {CreatePorosi} from '../../classes/porosia/create-porosi';
import {ModalBasicComponent} from '../../shared/modal-basic/modal-basic.component';
// @ts-ignore
import {FieldError} from '../../classes/common/field-error';

@Component({
  selector: 'app-simple-page',
  templateUrl: './shporta.component.html',
  styleUrls: ['./shporta.component.scss',
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
export class ShportaComponent implements OnInit {
  msg = '';
  position = 'bottom-right';

  emri: String;
  mbiemri: String;
  email: String;
  numriTelefonit: String;
  rruga: String;
  zipKodi: String;
  qyteti: String;

  emriClass: String;
  mbiemriClass: String;
  emailClass: String;
  numriTelefonitClass: String;
  rrugaClass: String;
  zipKodiClass: String;
  qytetiClass: String;

  shsportaProducts: Array<Shporta>;
  cmimiTotalIShportes: number = 0;

  constructor(private shportaService: ShportaService,
              private porosiaService: PorosiaService,
              private toastyService: ToastyService) {
  }

  ngOnInit() {
    this.getAll();
    this.setDefaultClasses();
  }

  getAll() {
    this.shportaService.getAll().subscribe(
      success => {
        this.shsportaProducts = success;
        this.kalkuloCmimin();
      }
    );
  }

  shtoSasi(id, sasia) {
    this.shportaService.shtoSasi(id, sasia).subscribe(
      success => {
        this.getAll();
      }
    );
  }

  porosit(bejePorosine: ModalBasicComponent) {
    let porosia = new CreatePorosi(this.emri,this.mbiemri,this.email,this.numriTelefonit,this.rruga,this.zipKodi,this.qyteti);
    this.porosiaService.create(porosia).subscribe(
      success => {
        bejePorosine.hide();
        this.msg = 'Porosia u krijua.';
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
          } else if (error.field == 'mbiemri') {
            this.mbiemriClass = 'form-control form-control-danger';
          } else if (error.field == 'email') {
            this.emailClass = 'form-control form-control-danger';
          } else if (error.field == 'numriTelefonit') {
            this.numriTelefonitClass = 'form-control form-control-danger';
          } else if (error.field == 'rruga') {
            this.rrugaClass = 'form-control form-control-danger';
          } else if (error.field == 'zipKodi') {
            this.zipKodiClass = 'form-control form-control-danger';
          } else if (error.field == 'qyteti') {
            this.qytetiClass = 'form-control form-control-danger';
          }
        }
      }
    );
  }

  delete(id) {
    this.shportaService.delete(id).subscribe(
      success => {
        this.msg = 'Produkti u fshi nga shporta.';
        this.toast();
        this.getAll();
      }
    );
  }

  kalkuloCmimin(){
    this.cmimiTotalIShportes = 0;
    for (let shporta of this.shsportaProducts){
      this.cmimiTotalIShportes = this.cmimiTotalIShportes + shporta.cmimiTotal;
    }
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

  setDefaultClasses(){
    this.emriClass = 'form-control form-control-primary';
    this.mbiemriClass = 'form-control form-control-primary';
    this.emailClass = 'form-control form-control-primary';
    this.numriTelefonitClass = 'form-control form-control-primary';
    this.rrugaClass = 'form-control form-control-primary';
    this.zipKodiClass = 'form-control form-control-primary';
    this.qytetiClass = 'form-control form-control-primary';
  }

  resetFields(){
    this.emri = "";
    this.mbiemri = "";
    this.email = "";
    this.numriTelefonit = "";
    this.rruga = "";
    this.zipKodi = "";
    this.qyteti = "";
  }

}
