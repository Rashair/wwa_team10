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
            const key = `${markerData.lat}/${markerData.lng}`
            console.log("Rendering marker")
            return <Marker
                position={{ lat: markerData.lat, lng: markerData.lng }}
                key={key}
                label={markerData.label}
                onClick={() => (this.showInfo(key))}
            >

                {(this.state.showInfoForKey === key) &&
                    <InfoWindow>
                        <div>
                            <div>{markerData.info}</div>
                        </div>
                    </InfoWindow>}

            </Marker>
        })

        return markers;
    }
}

export default Markers;