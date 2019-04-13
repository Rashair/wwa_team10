import React, { Component } from 'react';
import { withGoogleMap, GoogleMap, Marker, InfoWindow } from 'react-google-maps';
import PropTypes from 'prop-types'
import Markers from './Markers.js'


class Map extends Component {

    state = {
        values: []
    }

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

    componentDidMount() {
        const apiUrl = "http://www.mocky.io/v2/5cb124c73300000e0e571ff9";


        fetch(apiUrl)
            .then(response => response.json())
            .then(json => {
                this.setState(json)
                console.log(this.state)
            })

    }


    render() {

        const GoogleMapRendered = withGoogleMap(props => (
            <GoogleMap
                defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
                defaultZoom={6}
            >
                <Markers markersData={this.state.values} />
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