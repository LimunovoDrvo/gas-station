import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GasstationSharedModule } from '../../shared';
import { GasstationAdminModule } from '../../admin/admin.module';
import {
    QrcodeService,
    QrcodePopupService,
    QrcodeComponent,
    QrcodeDetailComponent,
    QrcodeDialogComponent,
    QrcodePopupComponent,
    QrcodeDeletePopupComponent,
    QrcodeDeleteDialogComponent,
    qrcodeRoute,
    qrcodePopupRoute,
} from './';

const ENTITY_STATES = [
    ...qrcodeRoute,
    ...qrcodePopupRoute,
];

@NgModule({
    imports: [
        GasstationSharedModule,
        GasstationAdminModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        QrcodeComponent,
        QrcodeDetailComponent,
        QrcodeDialogComponent,
        QrcodeDeleteDialogComponent,
        QrcodePopupComponent,
        QrcodeDeletePopupComponent,
    ],
    entryComponents: [
        QrcodeComponent,
        QrcodeDialogComponent,
        QrcodePopupComponent,
        QrcodeDeleteDialogComponent,
        QrcodeDeletePopupComponent,
    ],
    providers: [
        QrcodeService,
        QrcodePopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GasstationQrcodeModule {}
