import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GasstationSharedModule } from '../../shared';
import {
    StationService,
    StationPopupService,
    StationComponent,
    StationDetailComponent,
    StationDialogComponent,
    StationPopupComponent,
    StationDeletePopupComponent,
    StationDeleteDialogComponent,
    stationRoute,
    stationPopupRoute,
} from './';

const ENTITY_STATES = [
    ...stationRoute,
    ...stationPopupRoute,
];

@NgModule({
    imports: [
        GasstationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        StationComponent,
        StationDetailComponent,
        StationDialogComponent,
        StationDeleteDialogComponent,
        StationPopupComponent,
        StationDeletePopupComponent,
    ],
    entryComponents: [
        StationComponent,
        StationDialogComponent,
        StationPopupComponent,
        StationDeleteDialogComponent,
        StationDeletePopupComponent,
    ],
    providers: [
        StationService,
        StationPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GasstationStationModule {}
