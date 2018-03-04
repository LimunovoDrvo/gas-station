import { Route } from '@angular/router';

import { QrComponent } from './';

export const FUEL_ROUTE: Route = {
    path: 'qr',
    component: QrComponent,
    data: {
        authorities: [],
        pageTitle: 'Welcome!'
    }
};
