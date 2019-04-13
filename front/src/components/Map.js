import React, { Component } from 'react';
import { withGoogleMap, GoogleMap} from 'react-google-maps';
import Markers from './Markers.js'

const GoogleMapRendered = withGoogleMap(props => (
    <GoogleMap
        defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
        defaultZoom={6}
    >
        {props.children}
    </GoogleMap>
));

class Map extends Component {

    // state = {
    //     values: []
    // }

    constructor(props) {
        super(props);
        console.log(props)

    }

    render() {
        return (
            <div>
                <GoogleMapRendered
                    containerElement={<div style={{ height: `1000px`, width: '100%' }} />}
                    mapElement={<div style={{ height: `100%` }} />}
                >
                    <Markers markersData={this.props.markersData} />
                </GoogleMapRendered>
            </div>
        );
    }
};
export default Map;