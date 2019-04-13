import React, { Component } from 'react';
import { withGoogleMap, GoogleMap, Marker, InfoWindow } from 'react-google-maps';
import PropTypes from 'prop-types'
import Markers from './Markers.js'


class Map extends Component {

    // state = {
    //     values: []
    // }

    constructor(props) {
        super(props);
        console.log(props)
    }

    render() {

        const GoogleMapRendered = withGoogleMap(props => (
            <GoogleMap
                defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
                defaultZoom={6}
            >
                <Markers markersData={this.props.markersData} />
            </GoogleMap>
        ));


        return (
            <div>
                <GoogleMapRendered
                    containerElement={<div style={{ height: `100%`, width: '100%' }} />}
                    mapElement={<div style={{ height: `100%` }} />}
                />
            </div>
        );
    }
};
export default Map;