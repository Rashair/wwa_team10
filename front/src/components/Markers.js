import React, { Component } from 'react';
import {Marker, InfoWindow } from 'react-google-maps';


class Markers extends Component {
    state = {
        showInfoForKey: null
    }

    showInfo(key) {
        this.setState({ showInfoForKey: key })
    }

    render() {

        const markers = this.props.markersData.map(markerData => {
            const key = `${markerData.latitude}/${markerData.longitude}`

            const infoWindowText = 
            `ul. ${markerData.address.street}\n`+
            `${markerData.address.building_number},\n`+
            `${markerData.address.post_code}\n`+
            `${markerData.address.city},\n`+
            `woj. ${markerData.address.province}.\n`+
            `Godziny otwarcia: ${markerData.opening_hours}\n`

            // const infoWindowText = "blablabla"


            console.log("Rendering marker")
            return <Marker
                position={{ lat: markerData.latitude, lng: markerData.longitude }}
                key={key}
                label={markerData.name}
                onClick={() => (this.showInfo(key))}
            >

                {(this.state.showInfoForKey === key) &&
                    <InfoWindow>
                        <div>
                            <div>{infoWindowText}</div>
                        </div>
                    </InfoWindow>}

            </Marker>
        })

        return markers;
    }
}

export default Markers;