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

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }


    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <fieldset id="address" >
                    <legend> Adres </legend>
                    <div> {this.street.value} </div>
                    <div> {this.houseNumber.value} </div>
                    <div> {this.postalCode.value} </div>
                    <div> {this.city.value} </div>
                    <div> {this.phoneNumber.value} </div>
                </fieldset>
                <fieldset id="deliveryParameters">
                    <legend>Parametry punktów odbioru</legend>

                    <fieldset className="formRow">
                        <label htmlFor="range">Odległość[m]</label>
                        <input id="range" type="number" />
                    </fieldset>
                    <fieldset className="formRow">
                        <legend>Godziny otwarcia</legend>
                        <fieldset className="formRow">
                            <label htmlFor="hoursFrom"> Od: </label>
                            <input id="hoursFrom" type="time" defaultValue="08:00" />
                        </fieldset>
                        <fieldset className="formRow">
                            <label htmlFor="hoursTo"> Do: </label>
                            <input id="hoursTo" type="time" defaultValue="16:00" />
                        </fieldset>
                    </fieldset>

                </fieldset>

                <button type="submit" value="Submit" > Podsumowanie </button>
            </form>
        );
    }
}

export default DeliveryForm;