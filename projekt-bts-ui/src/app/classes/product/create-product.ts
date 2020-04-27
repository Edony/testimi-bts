export class CreateProduct {

  emri: String;
  kodi: String;
  pershkrimi: String;
  sasia: Number;
  cmimi: Number;
  foto: String;


  constructor(emri: String, kodi: String, pershkrimi: String, sasia: Number, cmimi: Number, foto: String) {
    this.emri = emri;
    this.kodi = kodi;
    this.pershkrimi = pershkrimi;
    this.sasia = sasia;
    this.cmimi = cmimi;
    this.foto = foto;
  }


}
