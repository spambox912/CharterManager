import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AddReservation from "./components/add-reservation.component";
import Reservation from "./components/reservation.component";
import ReservationsList from "./components/reservation-list.component";
import AddReservation from "../add-reservation-component";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/reservations"} className="navbar-brand">
            bezKoder
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/reservations"} className="nav-link">
                Reservations
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/add"} className="nav-link">
                Add
              </Link>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<ReservationsList/>} />
            <Route path="/reservations" element={<ReservationsList/>} />
            <Route path="/add" element={<AddReservation/>} />
            <Route path="/reservations/:id" element={<Reservation/>} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;