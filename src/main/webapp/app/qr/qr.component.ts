import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Account, LoginModalService, Principal } from '../shared';

@Component( {
    selector: 'jhi-qr',
    templateUrl: './qr.component.html',
    styleUrls: [
        'qr.scss'
    ]

} )
export class QrComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    fuelType = 1;
    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.principal.identity().then(( account ) => {
            this.account = account;
        } );
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe( 'authenticationSuccess', ( message ) => {
            this.principal.identity().then(( account ) => {
                this.account = account;
            } );
        } );
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

}
