import { Route } from '@angular/router';

import { MapComponent } from './';

export const MAP_ROUTE: Route = {
    path: 'map',
    component: MapComponent,
    data: {
        authorities: [],
        pageTitle: 'Welcome!'
    }
};
