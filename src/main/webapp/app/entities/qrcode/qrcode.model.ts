import { BaseEntity, User } from './../../shared';

export class Qrcode implements BaseEntity {
    constructor(
        public id?: number,
        public transactionId?: string,
        public items?: BaseEntity[],
        public user?: User,
    ) {
    }
}
