import React from "react"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import './App.css'
import Map from './components/Map.js'
import DeliveryForm from "./components/Form.js";


class App extends React.PureComponent {
  constructor(props){
    super(props)
    this.handleAddressForm=this.handleAddressForm.bind(this);
  }

  state = {
    values: [],
    //{name: "POP-KRA22", latitude: 50.04901, longitude: 19.94334, address: {…}, opening_hours: "PN-PT 10-18 SB 10-14"}
    deliveryPoints : [
      // {name: 'WAW21', hoursFrom: '08:00', hoursTo: '16:00', address: 'Jana Pawła II 10/413 Warszawa'},
      // {name: 'WAW22', hoursFrom: '08:00', hoursTo: '16:00', address: 'Jana Pawła II 22/413 Warszawa'},
      // {name: 'WAW23', hoursFrom: '08:00', hoursTo: '16:00', address: 'XXXXXXXXXXXXXXXXXXXXX'},
      // {name: 'WAW24', hoursFrom: '08:00', hoursTo: '16:00', address: 'YYYYYYYYYYYYYYYYYYYYYY'},
      // {name: 'WAW25', hoursFrom: '21:00', hoursTo: '23:00', address: 'ZZZZZZZZZZZZZZZZ'}
    ]
  };


  
  componentDidMount() {
    // const apiUrl = "http://localhost:8080/delivery"
    // fetch(apiUrl, {
    //   method: "POST",
    //   headers: {
    //     "Content-Type": "application/json",
    //   },
    //   body: JSON.stringify(formData)
    // }).then(response => response.json())
    //   .then(json => {
    //     this.setState(json)
    //     console.log(this.state)
    //   })

  }

  handleAddressForm = function (formData) {

    // fetch(apiUrl)
    //   .then(response => response.json())
    //   .then(json => {
    //     this.setState(json)
    //     console.log(this.state)
    //   })


    //const apiUrl = "http://www.mocky.io/v2/5cb15b093300004a1257204d";

    console.log(JSON.stringify(formData))
    const apiUrl = "http://localhost:8080/delivery"
    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData)
    }).then(response => response.json())
      .then(json => {
        this.setState({values:json.values, deliveryPoints:json.values}); 
      })

      
      //alert(this.DeliveryFormElement.current.state.deliveryPoints[0]);
  }

  render() {

    return (
      <div className="content-wrapper">
        <Map markersData={this.state.values} />
        <DeliveryForm onSubmit={this.handleAddressForm} pointsData={this.state.deliveryPoints} />
      </div>
    )
  }
}


export default App;
