import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Qrcode } from './qrcode.model';
import { QrcodePopupService } from './qrcode-popup.service';
import { QrcodeService } from './qrcode.service';

@Component({
    selector: 'jhi-qrcode-delete-dialog',
    templateUrl: './qrcode-delete-dialog.component.html'
})
export class QrcodeDeleteDialogComponent {

    qrcode: Qrcode;

    constructor(
        private qrcodeService: QrcodeService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.qrcodeService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'qrcodeListModification',
                content: 'Deleted an qrcode'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-qrcode-delete-popup',
    template: ''
})
export class QrcodeDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private qrcodePopupService: QrcodePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.qrcodePopupService
                .open(QrcodeDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
