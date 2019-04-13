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
    values: []
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

  handleAddressForm = function (formData) {

    // fetch(apiUrl)
    //   .then(response => response.json())
    //   .then(json => {
    //     this.setState(json)
    //     console.log(this.state)
    //   })


    const apiUrl = "http://www.mocky.io/v2/5cb15b093300004a1257204d";

    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData)
    }).then(response => response.json())
      .then(json => {
        this.setState(json)
        console.log(this.state)
      })

  }

  render() {

    return (
      <div className="content-wrapper">
        <Map markersData={this.state.values} />
        <DeliveryForm onSubmit={this.handleAddressForm} />

      </div>
    )
  }
}


export default App;
