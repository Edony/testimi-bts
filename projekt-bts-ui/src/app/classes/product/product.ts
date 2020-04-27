export class Product {

  id: Number;
  emri: String;
  kodi: String;
  pershkrimi: String;
  sasia: Number;
  cmimi: Number;
  foto: String;
  eshteNeStok: Boolean;

  constructor(id: Number, emri: String, kodi: String, pershkrimi: String, sasia: Number, cmimi: Number, foto: String, eshteNeStok: Boolean) {
    this.id = id;
    this.emri = emri;
    this.kodi = kodi;
    this.pershkrimi = pershkrimi;
    this.sasia = sasia;
    this.cmimi = cmimi;
    this.foto = foto;
    this.eshteNeStok = eshteNeStok;
  }
}
