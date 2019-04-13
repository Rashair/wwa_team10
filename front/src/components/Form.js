import React, { Component } from 'react';
import './Form.css'
import DeliveryPointsTable from "./Table";

class DeliveryForm extends Component {
    constructor(props) {
        super(props);

        this.state = {
            deliveryPoint: {
                name: 'WAW21',
                hoursFrom: '08:00',
                hoursTo: '16:00',
                address: 'Jana Pawła II 10/413 Warszawa'
            },

            defaultAddress: {},


            showAdvancedDeliverySettings: false
        }

        this.streetInput = React.createRef();
        this.houseNumberInput = React.createRef();
        this.flatNumberInput = React.createRef();
        this.postalCodeInput = React.createRef();
        this.cityInput = React.createRef();
        this.rangeInput = React.createRef();

        this.handleAddressButtonClicked = this.handleAddressButtonClicked.bind(this)
        this.address = {};

        this.deliveryPointParameters = {
            range: '1000',
            parkingChecked: 'false'
        };

        this.handleChange = this.handleChange.bind(this);

        console.log("mounting..")
        const apiUrl = "http://localhost:8080/client/2/address"
        fetch(apiUrl, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        }).then(response => response.json())
         .then(json => {
                this.setState({ defaultAddress: json }, () => {
                    this.handleAddressButtonClicked();
                })

            })
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    handleAdvancedSearching = () => {
        this.setState({ showAdvancedDeliverySettings: !this.state.showAdvancedDeliverySettings })
    }

    handleAddressButtonClicked() {
        this.props.onSubmit(
            {
                address:
                {
                    city: this.cityInput.current.value,
                    building_number: this.houseNumberInput.current.value,
                    flat_number: this.flatNumberInput.current.value,
                    post_code: this.postalCodeInput.current.value,
                    street: this.streetInput.current.value
                },
                max_distance: this.rangeInput.current === null ? 1000 : this.rangeInput.current.value
            }
        )
    }

    handleDeliveryPointClicked = (pointData) => {
        this.setState({ deliveryPoint: pointData })
    }

    render() {
        return (
            <div>
                <form>
                    <fieldset className="dataBlock" id="address">
                        <legend> Adres </legend>
                        <fieldset className="addressFormRow">
                            <label htmlFor="street">Ulica</label>
                            <input id="street" type="text" defaultValue={this.state.defaultAddress.street} ref={this.streetInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="houseNumber">Numer budynku</label>
                            <input id="houseNumber" type="text" defaultValue={this.state.defaultAddress.building_number} ref={this.houseNumberInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="flatNumber">Numer mieszkania</label>
                            <input id="flatNumber" type="text" defaultValue={this.state.defaultAddress.flat_number} ref={this.flatNumberInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="postalCode">Kod pocztowy</label>
                            <input id="postalCode" type="text" defaultValue={this.state.defaultAddress.post_code} ref={this.postalCodeInput} />
                        </fieldset>
                        <fieldset className="addressFormRow">
                            <label htmlFor="city">Miasto</label>

                            <input id="city" type="text" defaultValue={this.state.defaultAddress.city} ref={this.cityInput} />
                        </fieldset>

                        {(this.state.showAdvancedDeliverySettings) &&
                            <div>
                                <p>Opcje zaawansowane</p>
                                <fieldset className="addressFormRow">
                                    <label htmlFor="range">Odległość[m]</label>
                                    <input id="range" type="number" defaultValue={this.deliveryPointParameters.range} ref={this.rangeInput}
                                        max="10000" />
                                </fieldset>
                                <fieldset className="addressFormRow">
                                    <label htmlFor="parking"> Parking </label>
                                    <input id="parking" type="checkbox" defaultChecked={this.deliveryPointParameters.parkingChecked} />
                                </fieldset>
                            </div>
                        }


                        <div className="button-group">
                            <button type="button" onClick={this.handleAddressButtonClicked}>Wyszukaj</button>
                            <button type="button" onClick={this.handleAdvancedSearching}>Wyszukiwanie zaawansowane</button>
                        </div>
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
                        <DeliveryPointsTable pointsData={this.props.pointsData} onPointClick={this.handleDeliveryPointClicked} />
                    </fieldset>
                    <button type="button" > Podsumowanie </button>
                </form>
            </div>
        );
    }
}

export default DeliveryForm;