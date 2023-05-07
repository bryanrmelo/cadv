import { Link } from "./link";

export class Usuario {

    id!: number;
    nome!: string;
    senha!: string;
    ativo!: boolean;
    perfil!: string;
    _links!: Array<Link>[];

    constructor(jsonStr: string) {
      let jsonObj = JSON.parse(jsonStr);
      for (let prop in jsonObj) {
          this[prop] = jsonObj[prop];
      }
  }
}
