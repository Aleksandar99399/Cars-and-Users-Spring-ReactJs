import React from "react";
import axios from "axios";
import { Redirect } from "react-router-dom";
// import { useParams } from "react-router-dom";

class DeleteCar extends React.Component {
  componentWillMount() {
    axios
      .delete(
        "http://localhost:5000/api/cars/delete/" + this.props.match.params.carId
      )
      .then((res) => {
        alert("Car is deleted successfull");
      })
      .catch(alert("This car is not exist"));
  }

  render() {
    return <Redirect to={"/"} />;
  }
}

export default DeleteCar;
