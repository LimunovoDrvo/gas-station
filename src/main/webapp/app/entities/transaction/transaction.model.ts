import { BaseEntity } from './../../shared';

export class Transaction implements BaseEntity {
    constructor(
        public id?: number,
        public sifraBS?: string,
        public brojRacuna?: string,
        public brojStavke?: string,
        public datum?: string,
        public vreme?: string,
        public tipKupca?: string,
        public sifraRobe?: string,
        public nazivRobe?: string,
        public vrstaRobe?: string,
        public grupaRobe?: string,
        public hijerarhijaRobe?: string,
        public kolicina?: number,
        public konacnaCena?: number,
        public osnovnaCena?: number,
        public kompanijskaKartica?: string,
        public loyaltyKartica?: string,
        public loyaltyKarticaStatus?: string,
        public loyaltyPoeni?: number,
    ) {
    }
}
