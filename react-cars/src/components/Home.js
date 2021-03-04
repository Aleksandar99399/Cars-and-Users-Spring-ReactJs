import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Home extends React.Component {
  state = {
    carData: [],
  };

  componentWillMount() {
    axios.get("http://localhost:5000/api/cars/").then((res) => {
      const carData = res.data;
      this.setState({ carData });
    });
  }

  render() {
    return (
      <div>
        <h2>Cars:</h2>
        <table align="center">
          <thead>
            <tr>
              <th>Id</th>
              <th>Owner Id</th>
              <th>Brand</th>
              <th>Model</th>
            </tr>
          </thead>
          <tbody>
            {this.state.carData.map((car) => (
              <RowCreator item={car} />
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
    );
  }
}

class RowCreator extends React.Component {
  render() {
    var car = this.props.item;
    return (
      <tr>
        <td>{car.id}</td>
        <td>{car.owner.id}</td>
        <td>{car.brand}</td>
        <td>{car.model}</td>
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

export default Home;
