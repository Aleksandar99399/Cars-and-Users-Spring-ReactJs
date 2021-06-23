import React from "react";
import { Link } from "react-router-dom";
class Home extends React.Component {
  render() {
    return (
      <div className="div-in-home">
        <h1>Welcome to my car house</h1>

        <p>To see all cars, please click on</p>
        <div className="div-home">
          <Link className="link-home" to={"/cars/all"}>
            See All
          </Link>
        </div>
      </div>
    );
  }
}

export default Home;
