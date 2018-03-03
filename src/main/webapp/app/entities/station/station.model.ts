import { BaseEntity } from './../../shared';

export class Station implements BaseEntity {
    constructor(
        public id?: number,
        public sifraBs?: string,
        public naziv?: string,
        public brend?: string,
        public adresa?: string,
        public mesto?: string,
        public gpsLat?: number,
        public gpsLon?: number,
    ) {
    }
}
