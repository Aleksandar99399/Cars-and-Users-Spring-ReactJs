import React from "react";
import axios from "axios";
import { Link } from "react-router-dom";
// import { useParams } from "react-router-dom";

class DeleteCar extends React.Component {
  componentWillMount() {
    axios
      .delete(
        "http://localhost:5000/api/cars/delete/" + this.props.match.params.carId
      )
      .then((res) => {
        alert("Car is deleted successfull\nGo Back to see all cars");
      })
      .catch((res) => {
        alert(res.response.data.message);
      });
  }

  render() {
    return <Link to={"/"}> Go Back</Link>;
  }
}

export default DeleteCar;
