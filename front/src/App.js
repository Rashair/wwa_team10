import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";


class App extends React.PureComponent {

  render() {
    return (
      <div>
       <Map/>

       <DeliveryForm />
      </div>
    )
  }
}


export default App;
