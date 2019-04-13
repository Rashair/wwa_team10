import React from "react"
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
  };
  handleAddressForm = function (formData) {

    //console.log(JSON.stringify(formData))
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
      })
  }

  render() {

    return (
      <div className="content-wrapper">
        <Map markersData={this.state.values} />
        <DeliveryForm onSubmit={this.handleAddressForm} pointsData={this.state.values} />
      </div>
    )
  }
}


export default App;
