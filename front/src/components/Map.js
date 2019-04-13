import React, { Component } from 'react';
import { withGoogleMap, GoogleMap} from 'react-google-maps';
import Markers from './Markers.js'

// const GoogleMapRendered = withGoogleMap(props => (
//     <GoogleMap
//         defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
//         defaultZoom={6}

//     >
//         {props.children}
//     </GoogleMap>
// ));

class Map extends Component {

    // state = {
    //     zoom: 5,
    //     centerLat: 52.2297,
    //     centerLng: 21.0122
    // }



    // state = {
    //     values: []
    // }

    constructor(props) {
        super(props);
        console.log("props:")
        console.log(props)
        this.googleMap = React.createRef();
        

    }
    GoogleMapRendered = withGoogleMap(props => (
            <GoogleMap
                defaultCenter={{ lat: 52.2297, lng: 21.0122 }}
                defaultZoom={16}
                ref={this.googleMap}
               // ref={(map) => map && map.panTo({lat: props.centerLat, lng: props.centerLng})}
            //    ref={(map) => map && map.panTo({ lat: 52.2297, lng: 21.0122 })}
    
            >
                {props.children}
            </GoogleMap>
        ));
    

    pan(location){
        console.log("check pan")
        if(this.googleMap.current != null){
            console.log("paneedddd")
        this.googleMap.current.panTo(location)
        }
    }

    render() {
        
        return (
            <div>
                <this.GoogleMapRendered
                    containerElement={<div style={{ height: `1000px`, width: '100%' }} />}
                    mapElement={<div style={{ height: `100%` }}/>} 
                    
                >
                    <Markers markersData={this.props.markersData} />
                </this.GoogleMapRendered>
            </div>
        );
    }
};
export default Map;