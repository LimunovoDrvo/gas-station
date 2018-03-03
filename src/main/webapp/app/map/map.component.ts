import { Component, OnInit, Input } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Account, LoginModalService, Principal } from '../shared';
import { StationService, Station } from "../../app/entities/station";
import { HttpResponse } from "@angular/common/http";
@Component({
    selector: 'jhi-map',
    templateUrl: './map.component.html',
    styleUrls: [
        'map.scss'
    ]

})
export class MapComponent implements OnInit {
    map: any;
    account: Account;
    modalRef: NgbModalRef;
    markers: any[];
    @Input() waypoits;
    public stations: any[];
    
    start = {lat: 44.8104520, lng: 20.4621700}
    dest = null;
    destStation = null;
    
    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private stationService: StationService
    ) {
    }

    ngOnInit() {
        this.principal.identity().then((account) => {
            this.account = account;
        });
        
        this.stationService.query().subscribe(
                (res: HttpResponse<Station[]>) => {
                    this.stations = res.body;
                    this.stations.forEach((s) => {
                        s.gpsLat = Number(s.gpsLat);
                        s.gpsLon = Number(s.gpsLon);
                        
                        if(s.sifraBs == 514){
                            this.destStation = s;
                        }
                    });
                    this.dest = {lat: 44.8087, lng: 20.47428}
                }
            );
        
        this.registerAuthenticationSuccess();
    }
    
    setStation(m){
        this.dest = {lat: m.gpsLat, lng: m.gpsLon}
        this.destStation = m;
    }
    
    public loadAPIWrapper( map ) {
        this.map = map;
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }
    
    
}
