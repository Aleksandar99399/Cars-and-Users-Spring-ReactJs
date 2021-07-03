import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import * as fetchApi from "../services/fetchApi";
import TableComponent from "./Table/TableComponent";
import Fake from "./Fake";
// import queryString from "querystring";

/////////////////////////////////////////////////////////////////
// I must to continue
/////////////////////////////////////////////////////////////////
const AllCars = () => {
  const [cars, setCars] = useState();

  // fetchApi.getCars().then((carData) => {
  //   console.log(carData);
  //   return setCars(carData);
  // });

  useEffect(() => {
    console.log("In use effect");

    return fetchApi.getCars().then((carData) => {
      console.log("In fetch");
      return setCars(carData);
    });
  }, []);

  console.log(cars);
  return <Fake cars={cars}></Fake>;
};

// class AllCars extends React.Component {
//   constructor(props) {
//     super(props);

//     this.state = { carData: [] };
//   }

//   componentDidMount() {
//     console.log("In DID MOUNT");
//     fetchApi.getCars().then((carData) => {
//       return this.setState({ carData });
//     });

//     // axios
//     //   .get(`http://localhost:5000/api/cars/all`)
//     //   .then((res) => {
//     //     const carData = res.data;
//     //     console.log(carData);
//     //     this.setState({ carData });
//     //   })
//     //   .catch((res) => {
//     //     alert(res.response.data.message);
//     //   });
//   }

//   render() {
//     // return <h1>In the params</h1>;

//     return <TableComponent carData={this.state.carData}></TableComponent>;
//   }
// }

export default AllCars;
