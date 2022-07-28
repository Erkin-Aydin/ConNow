import './App.css';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import NavBar from "./components/NavBar/NavBar";
import Home from "./components/Home/Home";
import User from "./components/User/User";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar></NavBar>
        <Routes>
          <Route path="/" component={Home}><Home />></Route>
          <Route path="/users/:userId" component={User}><User /></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
