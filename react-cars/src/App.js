import "./App.css";
import { Route, Switch } from "react-router-dom";
import Home from "./components/Home";
import CreateCar from "./components/CreateCar";
import DeleteCar from "./components/DeleteCar";
import UpdateCar from "./components/UpdateCar";
import AllParams from "./components/AllParams";

function App() {
  return (
    <div className="App">
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/cars/create" component={CreateCar} />
        <Route exact path="/cars/delete/:carId" component={DeleteCar} />
        <Route exact path="/cars/update/:carId" component={UpdateCar} />
        <Route exact path="/cars/params" component={AllParams} />
      </Switch>
    </div>
  );
}

export default App;
