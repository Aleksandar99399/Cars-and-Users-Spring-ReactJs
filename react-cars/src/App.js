import "./App.css";
import { Route, Switch } from "react-router-dom";
import Home from "./components/Home";
import CreateCar from "./components/CreateCar";
import DeleteCar from "./components/DeleteCar";
import UpdateCar from "./components/UpdateCar";
import AllCars from "./components/AllCars";

// Can use HOC to move all fetch requests

function App() {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/cars/all" component={AllCars} />
        <Route exact path="/cars/create" component={CreateCar} />
        <Route exact path="/cars/delete/:carId" component={DeleteCar} />
        <Route exact path="/cars/update/:carId" component={UpdateCar} />
      </Switch>
    </div>
  );
}

export default App;
