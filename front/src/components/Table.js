import React, { Component } from 'react';
import './Table.css'

class DeliveryPointsTable extends Component {
    handleDeliveryPointClick(point) {
        // callback
        this.props.onPointClick(point);
    }

    render() {

        const deliveryPoints = [
            {name: 'WAW21', hoursFrom: '08:00', hoursTo: '16:00', address: 'Jana Pawła II 10/413 Warszawa'},
            {name: 'WAW22', hoursFrom: '08:00', hoursTo: '16:00', address: 'Jana Pawła II 22/413 Warszawa'},
            {name: 'WAW23', hoursFrom: '08:00', hoursTo: '16:00', address: 'XXXXXXXXXXXXXXXXXXXXX'},
            {name: 'WAW24', hoursFrom: '08:00', hoursTo: '16:00', address: 'YYYYYYYYYYYYYYYYYYYYYY'},
            {name: 'WAW25', hoursFrom: '21:00', hoursTo: '23:00', address: 'ZZZZZZZZZZZZZZZZ'}
        ];

        this.items = deliveryPoints.map((item, key) =>
            <tr key={item.name} onClick={() => this.handleDeliveryPointClick(item)}>
                <td>{item.name}</td>
                <td>{item.hoursFrom}-{item.hoursTo}</td>
                <td>{item.address}</td>
            </tr>
        );

        return (
         <table id="deliveryPointsTable">
             <tbody>
                {this.items}
             </tbody>
         </table>
        )
    }
}

export default DeliveryPointsTable;