import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GasstationTransactionModule } from './transaction/transaction.module';
import { GasstationItemModule } from './item/item.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        GasstationTransactionModule,
        GasstationItemModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GasstationEntityModule {}
