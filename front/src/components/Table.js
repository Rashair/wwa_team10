import React, { Component } from 'react';
import './Table.css'

class DeliveryPointsTable extends Component {

    handleDeliveryPointClick(point) {
        // callback
        this.props.onPointClick(point);
    };

    render() {
        this.items = this.props.pointsData.map((item, key) =>
            <tr key={item.name} onClick={() => this.handleDeliveryPointClick(item)}>
                <td className="delivery-point-name">{item.name}</td>
                <td className="delivery-point-hours">{item.opening_hours}</td>
                <td>{item.address.street} {item.address.building_number} {", "} {item.address.post_code} {item.address.city}</td>
                <td></td>
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