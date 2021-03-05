import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class UpdateCar extends React.Component {
  state = {};

  handleSubmit(event) {
    event.preventDefault();

    const owner = {
      firstName: this.firstName,
      lastName: this.lastName,
      telephoneNumber: this.telephoneNumber,
      email: this.email,
    };

    const data = {
      owner,
      registrationNumber: this.registrationNumber,
      color: this.color,
      hp: this.hp,
      brand: this.brand,
      model: this.model,
    };

    axios
      .put(
        "http://localhost:5000/api/cars/update/" +
          this.props.match.params.carId,
        data
      )
      .then((res) => {
        alert("Car is updated successfully\nGo Back to all cars");
      })
      .catch((res) => {
        alert(res.response.data.message);
      });
  }

  render() {
    return (
      <div>
        <h2>Update Car:</h2>
        <form>
          Owner: First Name:
          <input
            type="text"
            name="firstName"
            onChange={(event) => (this.firstName = event.target.value)}
          />
          Owner: Last Name:
          <input
            type="text"
            name="lastName"
            onChange={(event) => (this.lastName = event.target.value)}
          />
          Owner: Telephone Number:
          <input
            type="text"
            name="telephoneNumber"
            onChange={(event) => (this.telephoneNumber = event.target.value)}
          />
          Owner: email:
          <input
            type="text"
            name="email"
            onChange={(event) => (this.email = event.target.value)}
          />
          Car: Brand:
          <input
            type="text"
            name="brand"
            onChange={(event) => (this.brand = event.target.value)}
          />
          Car: Model:
          <input
            type="text"
            name="model"
            onChange={(event) => (this.model = event.target.value)}
          />
          Car: Registration number:
          <input
            type="text"
            name="registrationNumber"
            onChange={(event) => (this.registrationNumber = event.target.value)}
          />
          Car: Color:
          <input
            type="text"
            name="color"
            onChange={(event) => (this.color = event.target.value)}
          />
          Car: Horse Power:
          <input
            type="text"
            name="hp"
            onChange={(event) => (this.hp = event.target.value)}
          />
          <button onClick={this.handleSubmit.bind(this)}>Confirm</button>
        </form>
        <Link to={"/"}>Go Back</Link>
      </div>
    );
  }
}

export default UpdateCar;
