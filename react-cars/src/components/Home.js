import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Home extends React.Component {
  state = {
    carData: [],
  };

  componentWillMount() {
    axios
      .get("http://localhost:5000/api/cars/")
      .then((res) => {
        const carData = res.data;
        this.setState({ carData });
      })
      .catch((res) => {
        alert(res.response.data.message);
      });
  }

  render() {
    return (
      <div>
        <div>
          <h2>Cars:</h2>
          <table align="center">
            <thead>
              <tr>
                <th>CarId</th>
                <th>OwnerId</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Registration number</th>
                <th>Horse power</th>
                <th>Color</th>
              </tr>
            </thead>
            <tbody>
              {this.state.carData.map((car) => (
                <RowCreatorCar item={car} />
              ))}
            </tbody>
          </table>
          <br />
          <div>
            <Link to={"/cars/create"}>
              <font size="5">Create Car</font>
            </Link>
          </div>
          <div>
            <Link to={"/cars/params"}>
              <font size="5">Sort By Model</font>
            </Link>
          </div>
        </div>
        <div>
          <h2>Owner:</h2>
          <table align="center">
            <thead>
              <tr>
                <th>Owner: Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Telephone number</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              {this.state.carData.map((car) => (
                <RowCreatorOwner item={car} />
              ))}
            </tbody>
          </table>
          <br />
        </div>
      </div>
    );
  }
}

class RowCreatorCar extends React.Component {
  render() {
    var car = this.props.item;
    return (
      <tr>
        <td>{car.id}</td>
        <td>{car.owner.id}</td>
        <td>{car.brand}</td>
        <td>{car.model}</td>
        <td>{car.registrationNumber}</td>
        <td>{car.hp}</td>
        <td>{car.color}</td>
        <td>
          <Link to={"/cars/update/" + car.id}>Update Car</Link>
        </td>
        <td>
          <Link to={"/cars/delete/" + car.id}>Delete Car</Link>
        </td>
      </tr>
    );
  }
}
class RowCreatorOwner extends React.Component {
  render() {
    var car = this.props.item;
    return (
      <tr>
        <td>{car.id}</td>
        <td>{car.owner.firstName}</td>
        <td>{car.owner.lastName}</td>
        <td>{car.owner.telephoneNumber}</td>
        <td>{car.owner.email}</td>
      </tr>
    );
  }
}

export default Home;
