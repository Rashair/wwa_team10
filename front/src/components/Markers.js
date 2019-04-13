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
             (markerData.opening_hours !== null ? `Godziny otwarcia: ${markerData.opening_hours}\n` : ``) + ` -- `
             + (`Wypełnienie paczkomatu: ` + markerData.occupancy) + `% -- `
             + (markerData.parking === false ? `Brak parkingu`: `Dostępny parking`) + ` -- `
             + (markerData.disabled_friendly === false ? `Łatwy dostęp dla niepełnosprawnych`: `Utrudniony dostęp dla niepełnosprawnych`) + 
             ` -- ` + (markerData.weekend_pickup === false ? `Dostęp w weekendy` : `Brak dostępu w weekendy`) + ` -- ` +
            `Czas na odbiór przesyłki: ` + markerData.time_to_pickup + ` dni.` ;

            console.log("Rendering marker")
            return <Marker
                position={{ lat: markerData.latitude, lng: markerData.longitude }}
                key={key}
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