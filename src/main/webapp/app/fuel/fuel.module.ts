import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GasstationSharedModule } from '../shared';

import { FUEL_ROUTE, FuelComponent } from './';

@NgModule({
    imports: [
        GasstationSharedModule,
        RouterModule.forChild([ FUEL_ROUTE ])
    ],
    declarations: [
        FuelComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GasstationFuelModule {}
