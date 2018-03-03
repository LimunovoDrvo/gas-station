import { Route } from '@angular/router';

import { FuelComponent } from './';

export const FUEL_ROUTE: Route = {
    path: 'fuel',
    component: FuelComponent,
    data: {
        authorities: [],
        pageTitle: 'Welcome!'
    }
};
