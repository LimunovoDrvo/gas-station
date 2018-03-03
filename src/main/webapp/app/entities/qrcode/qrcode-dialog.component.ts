import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Qrcode } from './qrcode.model';
import { QrcodePopupService } from './qrcode-popup.service';
import { QrcodeService } from './qrcode.service';
import { User, UserService } from '../../shared';

@Component({
    selector: 'jhi-qrcode-dialog',
    templateUrl: './qrcode-dialog.component.html'
})
export class QrcodeDialogComponent implements OnInit {

    qrcode: Qrcode;
    isSaving: boolean;

    users: User[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private qrcodeService: QrcodeService,
        private userService: UserService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.userService.query()
            .subscribe((res: HttpResponse<User[]>) => { this.users = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.qrcode.id !== undefined) {
            this.subscribeToSaveResponse(
                this.qrcodeService.update(this.qrcode));
        } else {
            this.subscribeToSaveResponse(
                this.qrcodeService.create(this.qrcode));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Qrcode>>) {
        result.subscribe((res: HttpResponse<Qrcode>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Qrcode) {
        this.eventManager.broadcast({ name: 'qrcodeListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackUserById(index: number, item: User) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-qrcode-popup',
    template: ''
})
export class QrcodePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private qrcodePopupService: QrcodePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.qrcodePopupService
                    .open(QrcodeDialogComponent as Component, params['id']);
            } else {
                this.qrcodePopupService
                    .open(QrcodeDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
