import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Qrcode } from './qrcode.model';
import { QrcodeService } from './qrcode.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-qrcode',
    templateUrl: './qrcode.component.html'
})
export class QrcodeComponent implements OnInit, OnDestroy {
qrcodes: Qrcode[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private qrcodeService: QrcodeService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.qrcodeService.query().subscribe(
            (res: HttpResponse<Qrcode[]>) => {
                this.qrcodes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInQrcodes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Qrcode) {
        return item.id;
    }
    registerChangeInQrcodes() {
        this.eventSubscriber = this.eventManager.subscribe('qrcodeListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
