import React, { Component } from 'react';
import './Form.css'
import DeliveryPointsTable from "./Table";

class DeliveryForm extends React.Component {
    constructor(props) {
        super(props);

        this.address = {
            street: 'Jana Pawła II',
            houseNumber: '22/13' ,
            postalCode : '00-133' ,
            city: 'Warszawa',
            phoneNumber: '+48 516 942 392' 
        };

        this.defaultDeliveryPoint = {
            name: 'WAW22',
            hoursFrom: '08:00',
            hoursTo: '16:00',
            address: 'Jana Pawła II 22/419 Warszawa'
        };

        this.deliveryPointParameters = {
            range: '1000',
            hoursFrom: '08:00',
            hoursTo:  '16:00',
            parkingChecked: 'false'
        };

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }


    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <fieldset  className="dataBlock" id="address">
                    <legend> Adres </legend>
                    <div> {this.address.street} </div>
                    <div> {this.address.houseNumber} </div>
                    <div> {this.address.postalCode} </div>
                    <div> {this.address.city} </div>
                    <div> {this.address.phoneNumber} </div>
                </fieldset>

                <fieldset className="dataBlock" id="defaultDeliveryPoint">
                    <legend> Wybrany punkt odbioru </legend>
                    <div onClick=""> 
                        <div>{this.defaultDeliveryPoint.name}</div>
                        <div>{this.defaultDeliveryPoint.hoursFrom} - {this.defaultDeliveryPoint.hoursTo}</div>
                    </div>
                </fieldset>

                <fieldset  className="dataBlock" id="deliveryPoints">
                    <legend>Proponowane punkty odbioru</legend>
                    <DeliveryPointsTable />
                </fieldset>

                <fieldset  className="dataBlock" id="deliveryPointParameters">
                    <legend>Parametry punktów odbioru</legend>

                    <fieldset className="formRow">
                        <label htmlFor="range">Odległość[m]</label>
                        <input id="range" type="number" defaultValue={this.deliveryPointParameters.range} />
                    </fieldset>
                    <fieldset className="formRow">
                        <legend>Godziny otwarcia</legend>
                        <fieldset className="formRow">
                            <label htmlFor="hoursFrom"> Od: </label>
                            <input id="hoursFrom" type="time" defaultValue={this.deliveryPointParameters.hoursFrom} />
                        </fieldset>
                        <fieldset className="formRow">
                            <label htmlFor="hoursTo"> Do: </label>
                            <input id="hoursTo" type="time" defaultValue={this.deliveryPointParameters.hoursTo} />
                        </fieldset>
                    </fieldset>
                    <fieldset className="formRow">
                        <label htmlFor="parking"> Parking </label>
                        <input id="parking" type="checkbox" defaultChecked={this.deliveryPointParameters.parkingChecked}></input>
                    </fieldset>

                </fieldset>

                <button type="submit" value="Submit" > Podsumowanie </button>
            </form>
        );
    }
}

export default DeliveryForm;