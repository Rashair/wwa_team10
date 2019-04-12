import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import Map from './components/Map.js'


class App extends React.PureComponent {

  render() {
    return (
      <div>
       <Map/>
      </div>
      
      
    )
  }
}


export default App;
