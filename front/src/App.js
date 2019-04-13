import React from "react"
import './App.css'
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";


class App extends React.PureComponent {
  constructor(props){
    super(props)
    this.handleAddressForm=this.handleAddressForm.bind(this);
    this.map = React.createRef();
  }

  state = {
    values: [],
    mapZoom: 5,
    source_latitude: 52.2297,
    source_longitude: 21.0122
  };

  handleAddressForm = function (formData) {
    console.log(formData);
    const apiUrl = "http://localhost:8080/delivery"
    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData)
    }).then(response => response.json())
      .then(json => {
        this.setState(json); //console.log(json);
        console.log("json:");
        console.log(json);
        let myLat = json.values.length > 0 ? json.values[0].latitude  : json.source_latitude;
        let myLng = json.values.length > 0 ? json.values[0].longitude  : json.source_longitude;

          console.log("abracacadbara");
          console.log(myLat + " " + myLng); 
          this.map.current.pan({ lat: myLat, lng: myLng })
        
      })
  }

  changeCenterMap = (location) => {
    this.map.current.pan({lat:location.lat, lng:location.lng});
  }

  render() {

    return (
      <div className="content-wrapper">
        <Map ref={this.map} markersData={this.state.values} centerLng={this.state.source_longitude} centerLtd={this.state.source_latitude}/>
        <DeliveryForm onSubmit={this.handleAddressForm} pointsData={this.state.values} changeCenter={this.changeCenterMap} />
      </div>
    )
  }
}


export default App;
