import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import './App.css'
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";
import Markers from "./components/Markers.js"


class App extends React.PureComponent {


  render() {

    const markersData = [
      { lat: 52.2297, lng: 21.0122, label: "WAW1337", info: "Paczkomat 1"},
      { lat: 52.2297, lng: 21.0222, label: "WAW420", info: "Paczkomat 2"}
    ]

    return (
      <div className="content-wrapper">
        <DeliveryForm />
        <Map markersData={markersData}/>
      </div>
    )
  }
}


export default App;
