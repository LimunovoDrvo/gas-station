import { BaseEntity } from './../../shared';

export class Item implements BaseEntity {
    constructor(
        public id?: number,
        public nazivRobe?: string,
        public vrstaRobe?: string,
        public grupaRobe?: string,
        public hijerarhijaRobe?: string,
        public osnovnaCena?: number,
        public slika?: string,
        public kolicina?: number,
        public qrcode?: BaseEntity,
    ) {
    }
}
