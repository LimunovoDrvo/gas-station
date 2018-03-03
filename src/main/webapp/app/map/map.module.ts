import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';
import { GasstationSharedModule } from '../shared';
import { AgmDirectionModule } from 'agm-direction';
import { MAP_ROUTE, MapComponent } from './';

@NgModule({
    imports: [
        GasstationSharedModule,
        RouterModule.forChild([ MAP_ROUTE ]),
        AgmCoreModule.forRoot( {
            apiKey: 'AIzaSyAc97EjpXR4-O9hM3iKyrdxJ-Kisa-aC6o',
            libraries: ['places']
        } ),
        AgmDirectionModule
    ],
    declarations: [
        MapComponent
    ],
    entryComponents: [
    ],
    providers: [GoogleMapsAPIWrapper
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GasstationMapModule {}
