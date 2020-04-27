export class UpdateProduct {

  id: Number;
  emri: String;
  kodi: String;
  pershkrimi: String;
  sasia: Number;
  cmimi: Number;
  foto: String;


  constructor(id: Number, emri: String, kodi: String, pershkrimi: String, sasia: Number, cmimi: Number, foto: String) {
    this.id = id;
    this.emri = emri;
    this.kodi = kodi;
    this.pershkrimi = pershkrimi;
    this.sasia = sasia;
    this.cmimi = cmimi;
    this.foto = foto;
  }
}
