import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import './App.css'
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";


class App extends React.PureComponent {
  

  render() {

    // const apiUrl = "http://www.mocky.io/v2/5cb124c73300000e0e571ff9";

    const markersData = [
      { lat: 52.2297, lng: 21.0122, label: "WAW1337", info: "Paczkomat 1" },
      { lat: 52.2297, lng: 21.0222, label: "WAW420", info: "Paczkomat 2" }
    ]

    return (
      <div className="content-wrapper">
       <Map markersData={markersData}/>
        <DeliveryForm />
       
      </div>
    )
  }
}


export default App;
