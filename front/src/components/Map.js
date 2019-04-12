import React, { Component } from 'react';
import { withGoogleMap, GoogleMap, Marker } from 'react-google-maps';
import PropTypes from 'prop-types'
class Map extends Component {

    constructor(props){
        super(props);
    }
    static propTypes = {
        markersPositions: PropTypes.arrayOf(PropTypes.shape({
            lat: PropTypes.number.isRequired,
            lng: PropTypes.number.isRequired
        })).isRequired
    }

    render() {
        
        console.log(this.props.markersPositions)
        const markers = this.props.markersPositions.map(markerPosition => {
            
            return <Marker position={markerPosition} key={`${markerPosition.lat}/${markerPosition.lng}`}/>
        })

        const GoogleMapRendered = withGoogleMap(props => (
            <GoogleMap
                defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
                defaultZoom={13}
            >
                {markers}
    
                
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