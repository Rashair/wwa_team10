import React, { Component } from 'react';

class DefaultDeliveryPoint extends React.Component {
    render() {

        const deliveryPoint =  {
            name: 'WAW21',
            hoursFrom: '08:00',
            hoursTo: '16:00',
            address: 'Jana Pawła II 10/413 Warszawa'
        };


        return (
            <div>
                {deliveryPoint.name} {deliveryPoint.hoursFrom}-{deliveryPoint.hoursTo} {deliveryPoint.address}
            </div>
        );
    };
}

export default DefaultDeliveryPoint;