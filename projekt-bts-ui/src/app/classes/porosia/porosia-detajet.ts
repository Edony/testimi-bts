import {PorosiaProdukt} from './porosia-produkt';

export class PorosiaDetajet {

  id: Number;

  emri: String;

  mbiemri: String;

  email: String;

  numriTelefonit: String;

  rruga: String;

  zipKodi: Number;

  qyteti: String;

  statusi: String;

  cmimiTotal: Number;

  listaPorosive: Array<PorosiaProdukt>;

}
