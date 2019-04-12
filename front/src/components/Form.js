import React, { Component } from 'react';
import './Form.css'

class DeliveryForm extends React.Component {
    constructor(props) {
        super(props);

        this.street = { value: 'Jana Pawła II' };
        this.houseNumber = { value: '22/13' };
        this.postalCode = { value: '00-133' };
        this.city = { value: 'Warszawa' };
        this.phoneNumber = { value: '+48 516 942 392' };

        this.range = {value: '1000'};
        this.hoursFrom = {value: '08:00'};
        this.hoursTo = {value: '16:00'};
        this.parkingChecked = {value: 'false'}

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
                    <div> {this.street.value} </div>
                    <div> {this.houseNumber.value} </div>
                    <div> {this.postalCode.value} </div>
                    <div> {this.city.value} </div>
                    <div> {this.phoneNumber.value} </div>
                </fieldset>

                <fieldset className="dataBlock" id="defaultDeliveryPoint">
                    
                </fieldset>

                <fieldset  className="dataBlock" id="deliveryPoints">

                </fieldset>

                <fieldset  className="dataBlock" id="deliveryParameters">
                    <legend>Parametry punktów odbioru</legend>

                    <fieldset className="formRow">
                        <label htmlFor="range">Odległość[m]</label>
                        <input id="range" type="number" defaultValue={this.range.value} />
                    </fieldset>
                    <fieldset className="formRow">
                        <legend>Godziny otwarcia</legend>
                        <fieldset className="formRow">
                            <label htmlFor="hoursFrom"> Od: </label>
                            <input id="hoursFrom" type="time" defaultValue={this.hoursFrom.value} />
                        </fieldset>
                        <fieldset className="formRow">
                            <label htmlFor="hoursTo"> Do: </label>
                            <input id="hoursTo" type="time" defaultValue={this.hoursTo.value} />
                        </fieldset>
                    </fieldset>
                    <fieldset className="formRow">
                        <label htmlFor="parking"> Parking </label>
                        <input id="parking" type="checkbox" defaultChecked={this.parkingChecked.value}></input>
                    </fieldset>

                </fieldset>

                <button type="submit" value="Submit" > Podsumowanie </button>
            </form>
        );
    }
}

export default DeliveryForm;