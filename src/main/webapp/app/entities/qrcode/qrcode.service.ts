import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Qrcode } from './qrcode.model';
import { createRequestOption } from '../../shared';
import { Item } from "../item";

export type EntityResponseType = HttpResponse<Qrcode>;

@Injectable()
export class QrcodeService {
    private resourceUrl = SERVER_API_URL + 'api/qrcodes';

    private cart: Qrcode = new Qrcode();


    public addToCart( item: Item ) {
        this.cart.items.push( item );
    }

    public checkout() {
        return this.http.post<Qrcode>( this.resourceUrl, this.cart, { observe: 'response' } )
            .map(( res: EntityResponseType ) => {
                this.cart = new Qrcode(); 
        });
    }


    constructor( private http: HttpClient ) { }

    create( qrcode: Qrcode ): Observable<EntityResponseType> {
        const copy = this.convert( qrcode );
        return this.http.post<Qrcode>( this.resourceUrl, copy, { observe: 'response' } )
            .map(( res: EntityResponseType ) => this.convertResponse( res ) );
    }

    update( qrcode: Qrcode ): Observable<EntityResponseType> {
        const copy = this.convert( qrcode );
        return this.http.put<Qrcode>( this.resourceUrl, copy, { observe: 'response' } )
            .map(( res: EntityResponseType ) => this.convertResponse( res ) );
    }

    find( id: number ): Observable<EntityResponseType> {
        return this.http.get<Qrcode>( `${this.resourceUrl}/${id}`, { observe: 'response' } )
            .map(( res: EntityResponseType ) => this.convertResponse( res ) );
    }

    query( req?: any ): Observable<HttpResponse<Qrcode[]>> {
        const options = createRequestOption( req );
        return this.http.get<Qrcode[]>( this.resourceUrl, { params: options, observe: 'response' } )
            .map(( res: HttpResponse<Qrcode[]> ) => this.convertArrayResponse( res ) );
    }

    delete( id: number ): Observable<HttpResponse<any>> {
        return this.http.delete<any>( `${this.resourceUrl}/${id}`, { observe: 'response' } );
    }

    private convertResponse( res: EntityResponseType ): EntityResponseType {
        const body: Qrcode = this.convertItemFromServer( res.body );
        return res.clone( { body } );
    }

    private convertArrayResponse( res: HttpResponse<Qrcode[]> ): HttpResponse<Qrcode[]> {
        const jsonResponse: Qrcode[] = res.body;
        const body: Qrcode[] = [];
        for ( let i = 0; i < jsonResponse.length; i++ ) {
            body.push( this.convertItemFromServer( jsonResponse[i] ) );
        }
        return res.clone( { body } );
    }

    /**
     * Convert a returned JSON object to Qrcode.
     */
    private convertItemFromServer( qrcode: Qrcode ): Qrcode {
        const copy: Qrcode = Object.assign( {}, qrcode );
        return copy;
    }

    /**
     * Convert a Qrcode to a JSON which can be sent to the server.
     */
    private convert( qrcode: Qrcode ): Qrcode {
        const copy: Qrcode = Object.assign( {}, qrcode );
        return copy;
    }
}
