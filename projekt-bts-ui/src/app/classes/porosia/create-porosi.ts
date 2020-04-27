export class CreatePorosi {

  emri: String;
  mbiemri: String;
  email: String;
  numriTelefonit: String;
  rruga: String;
  zipKodi: String;
  qyteti: String;

  constructor(emri: String, mbiemri: String, email: String, numriTelefonit: String, rruga: String, zipKodi: String, qyteti: String) {
    this.emri = emri;
    this.mbiemri = mbiemri;
    this.email = email;
    this.numriTelefonit = numriTelefonit;
    this.rruga = rruga;
    this.zipKodi = zipKodi;
    this.qyteti = qyteti;
  }
}
