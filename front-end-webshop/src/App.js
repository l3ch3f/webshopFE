import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import axios from "axios";

function App() {
  axios.defaults.baseURL = "http://localhost:8081/api";
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
