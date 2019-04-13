import React, { Component } from 'react';
import { withGoogleMap, GoogleMap, Marker, InfoWindow } from 'react-google-maps';
import PropTypes from 'prop-types'
import Markers from './Markers.js'


class Map extends Component {

    constructor(props) {
        super(props);
        console.log(props)
    }
    static propTypes = {
        markersData: PropTypes.arrayOf(PropTypes.shape({
            lat: PropTypes.number.isRequired,
            lng: PropTypes.number.isRequired
        })).isRequired
    }

    render() {

        console.log(this.props.markersData)
        
        const GoogleMapRendered = withGoogleMap(props => (
            <GoogleMap
                defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
                defaultZoom={13}
            >
                <Markers markersData={this.props.markersData} />
            </GoogleMap>
        ));


        return (
            <div>
                <GoogleMapRendered
                    containerElement={<div style={{ height: `500px`, width: '500px' }} />}
                    mapElement={<div style={{ height: `100%` }} />}
                />
            </div>
        );
    }
};
export default Map;