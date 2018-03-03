import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { QrcodeComponent } from './qrcode.component';
import { QrcodeDetailComponent } from './qrcode-detail.component';
import { QrcodePopupComponent } from './qrcode-dialog.component';
import { QrcodeDeletePopupComponent } from './qrcode-delete-dialog.component';

export const qrcodeRoute: Routes = [
    {
        path: 'qrcode',
        component: QrcodeComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Qrcodes'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'qrcode/:id',
        component: QrcodeDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Qrcodes'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const qrcodePopupRoute: Routes = [
    {
        path: 'qrcode-new',
        component: QrcodePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Qrcodes'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'qrcode/:id/edit',
        component: QrcodePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Qrcodes'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'qrcode/:id/delete',
        component: QrcodeDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Qrcodes'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
