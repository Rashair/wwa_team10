import React, { Component } from 'react';
import './Form.css'
import DeliveryPointsTable from "./Table";

class DeliveryForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            deliveryPoint :  {
                name: 'WAW21',
                hoursFrom: '08:00',
                hoursTo: '16:00',
                address: 'Jana Pawła II 10/413 Warszawa'
            }
        }

        this.streetInput = React.createRef();
        this.houseNumberInput = React.createRef();
        this.flatNumberInput = React.createRef();
        this.postalCodeInput = React.createRef();
        this.cityInput = React.createRef();

        this.handleAddressButtonClicked = this.handleAddressButtonClicked.bind(this)
        this.address = {
            street: 'Jana Pawła II',
            buildingNumber: '22',
            flatNumber: '413',
            postalCode: '00-133',
            city: 'Warszawa'
        };

        this.deliveryPointParameters = {
            range: '1000',
            hoursFrom: '08:00',
            hoursTo: '16:00',
            parkingChecked: 'false'
        };

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    handleAddressButtonClicked() {
        this.props.onSubmit(
            {
                city: this.cityInput.current.value,
                building_number: this.houseNumberInput.current.value,
                flat_number: this.flatNumberInput.current.value,
                post_code: this.postalCodeInput.current.value,
                street: this.streetInput.current.value
            }
        )
    }

    handleDeliveryPointClicked = (pointData) => {
        this.setState({deliveryPoint: pointData})
    }

    render() {

        return (
            <div>
                <form>
                    <fieldset className="dataBlock" id="address">
                        <legend> Adres </legend>
                        <fieldset className="addressFormRow">
                            <label htmlFor="street">Ulica</label>
                            <input id="street" type="text" defaultValue={this.address.street} ref={this.streetInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="houseNumber">Numer budynku</label>
                            <input id="houseNumber" type="text" defaultValue={this.address.buildingNumber} ref={this.houseNumberInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="flatNumber">Numer mieszkania</label>
                            <input id="flatNumber" type="text" defaultValue={this.address.flatNumber} ref={this.flatNumberInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="postalCode">Kod pocztowy</label>
                            <input id="postalCode" type="text" defaultValue={this.address.postalCode} ref={this.postalCodeInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="city">Miasto</label>
                            
                            <input id="city" type="text" defaultValue={this.address.city} ref={this.cityInput} />
                        </fieldset>
                        <button type="button" onClick={this.handleAddressButtonClicked} >Wyszukaj</button>
                    </fieldset>

                    <fieldset className="dataBlock" id="defaultDeliveryPoint">
                        <legend> Wybrany punkt odbioru </legend>
                        <div>
                            {this.state.deliveryPoint.name} {this.state.deliveryPoint.hoursFrom}-
                            {this.state.deliveryPoint.hoursTo} {this.state.deliveryPoint.address}
                        </div>
                    </fieldset>

                    <fieldset className="dataBlock" id="deliveryPoints">
                        <legend>Proponowane punkty odbioru</legend>
                        <DeliveryPointsTable onPointClick={this.handleDeliveryPointClicked} />
                    </fieldset>

                    <fieldset className="dataBlock" id="deliveryPointParameters">
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
                            <input id="parking" type="checkbox" defaultChecked={this.deliveryPointParameters.parkingChecked} />
                        </fieldset>
                        <button type="button">Wyszukaj</button>
                    </fieldset>

                    <button type="button" > Podsumowanie </button>
                </form>
            </div>
        );
    }
}

export default DeliveryForm;