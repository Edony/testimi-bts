import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {PorosiaService} from '../../services/porosia-service';
import {Porosia} from '../../classes/porosia/porosia';
import {PorosiaDetajet} from '../../classes/porosia/porosia-detajet';
import {animate, style, transition, trigger} from '@angular/animations';
import {ToastOptions, ToastyService} from 'ng2-toasty';

@Component({
  selector: 'app-simple-page',
  templateUrl: './lista-porosive.component.html',
  styleUrls: ['./lista-porosive.component.scss',
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
export class ListaPorosiveComponent implements OnInit {
  msg = '';
  position = 'bottom-right';

  allPorosite: Array<Porosia>;
  porosiaDetajet: PorosiaDetajet = null;
  shfaqModal: boolean = false;

  constructor(private porosiaService: PorosiaService,
              private toastyService: ToastyService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.porosiaService.getAll().subscribe(
      success => {
        this.allPorosite = success;
      }
    );
  }

  getOne(id) {
    this.porosiaService.getOne(id).subscribe(
      success => {
        this.porosiaDetajet = success;
        this.shfaqModal = true;
      }
    );
  }

  dergo(id) {
    this.porosiaService.dergo(id).subscribe(
      success => {
        this.msg = "Porosia u dergua";
        this.toast();
        this.getAll();
      }
    );
  }

  anulo(id) {
    this.porosiaService.anulo(id).subscribe(
      success => {
        this.msg = "Porosia u anulua";
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
