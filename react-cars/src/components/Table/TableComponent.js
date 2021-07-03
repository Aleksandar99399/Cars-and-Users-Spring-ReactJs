import React from "react";
import { Link } from "react-router-dom";

const TableComponent = (props) => {
  console.log("IN TABLE");
  console.log(props);
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
            {props.cars.map((car) => (
              <RowCreatorCar key={car.id} item={car} />
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
          <Link to={"/"}>Sort By Brand</Link>
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
            {props.cars.map((car) => (
              <RowCreatorOwner key={car.id} item={car} />
            ))}
          </tbody>
        </table>
        <br />
      </div>
    </div>
  );
};

// class TableComponent extends React.Component {
//   constructor(props) {
//     super(props);
//     console.log("In TableComponent");
//     console.log(props);
//   }

//   render() {
//     return (
//       <div>
//         <div>
//           <h2>Cars:</h2>
//           <table align="center">
//             <thead>
//               <tr>
//                 <th>CarId</th>
//                 <th>OwnerId</th>
//                 <th>Brand</th>
//                 <th>Model</th>
//                 <th>Registration number</th>
//                 <th>Horse power</th>
//                 <th>Color</th>
//               </tr>
//             </thead>
//             <tbody>
//               {this.props.carData.map((car) => (
//                 <RowCreatorCar key={car.id} item={car} />
//               ))}
//             </tbody>
//           </table>
//           <br />
//           <div>
//             <Link to={"/cars/create"}>
//               <font size="5">Create Car</font>
//             </Link>
//           </div>
//           <div>
//             <Link to={"/"}>Sort By Brand</Link>
//           </div>
//         </div>
//         <div>
//           <h2>Owner:</h2>
//           <table align="center">
//             <thead>
//               <tr>
//                 <th>Owner: Id</th>
//                 <th>First name</th>
//                 <th>Last name</th>
//                 <th>Telephone number</th>
//                 <th>Email</th>
//               </tr>
//             </thead>
//             <tbody>
//               {this.props.carData.map((car) => (
//                 <RowCreatorOwner key={car.id} item={car} />
//               ))}
//             </tbody>
//           </table>
//           <br />
//         </div>
//       </div>
//     );
//   }
// }

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
      </tr>
    );
  }
}

export default TableComponent;
