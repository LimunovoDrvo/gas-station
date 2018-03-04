import { BaseEntity, User } from './../../shared';

export class Qrcode implements BaseEntity {
    constructor(
        public id?: number,
        public transactionId?: string,
        public items?: any[],
        public user?: User,
    ) {
        items = [];
    }
}
