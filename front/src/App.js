import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";


class App extends React.PureComponent {


  render() {

    const markersPositions = [
      { lat: 52.2297, lng: 21.0122 },
      { lat: 52, lng: 21 },
    ]


    return (
      <div>
        <Map markersPositions={markersPositions}/>
       <DeliveryForm />
      </div>
    )
  }
}


export default App;
