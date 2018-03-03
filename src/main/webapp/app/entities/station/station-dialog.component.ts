import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Station } from './station.model';
import { StationPopupService } from './station-popup.service';
import { StationService } from './station.service';

@Component({
    selector: 'jhi-station-dialog',
    templateUrl: './station-dialog.component.html'
})
export class StationDialogComponent implements OnInit {

    station: Station;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private stationService: StationService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.station.id !== undefined) {
            this.subscribeToSaveResponse(
                this.stationService.update(this.station));
        } else {
            this.subscribeToSaveResponse(
                this.stationService.create(this.station));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Station>>) {
        result.subscribe((res: HttpResponse<Station>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Station) {
        this.eventManager.broadcast({ name: 'stationListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-station-popup',
    template: ''
})
export class StationPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private stationPopupService: StationPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.stationPopupService
                    .open(StationDialogComponent as Component, params['id']);
            } else {
                this.stationPopupService
                    .open(StationDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
