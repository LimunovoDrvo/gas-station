import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { Qrcode } from './qrcode.model';
import { QrcodeService } from './qrcode.service';

@Component({
    selector: 'jhi-qrcode-detail',
    templateUrl: './qrcode-detail.component.html'
})
export class QrcodeDetailComponent implements OnInit, OnDestroy {

    qrcode: Qrcode;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private qrcodeService: QrcodeService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInQrcodes();
    }

    load(id) {
        this.qrcodeService.find(id)
            .subscribe((qrcodeResponse: HttpResponse<Qrcode>) => {
                this.qrcode = qrcodeResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInQrcodes() {
        this.eventSubscriber = this.eventManager.subscribe(
            'qrcodeListModification',
            (response) => this.load(this.qrcode.id)
        );
    }
}
