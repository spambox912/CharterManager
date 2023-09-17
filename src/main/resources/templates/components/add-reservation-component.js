import React, { Component } from "react";
import ReservationDataService from "../services/reservation.service";

export default class AddReservation extends Component {
  constructor(props) {
    super(props);
    this.saveReservation = this.saveReservation.bind(this);
    this.newReservation = this.newReservation.bind(this);

    this.state = {
      id: null,
      yacht: "",
      customer: "", 
      dateFrom: "",
      dateTo: "",

      submitted: false
    };
  }

  onChangeTitle(e) {
    this.setState({
      title: e.target.value
    });
  }

  onChangeDescription(e) {
    this.setState({
      description: e.target.value
    });
  }

  saveTutorial() {
    var data = {
      yacht: this.state.yacht,
      customer: this.state.customer, 
      dateFrom: this.state.dateFrom,
      dateTo: this.state.dateTo,
    };

    ReservationDataService.create(data)
      .then(response => {
        this.setState({
          id: response.data.id,
          yacht: response.data.yacht,
          customer: response.data.customer,
          dateFrom: response.data.dateFrom,
          dateTo: response.data.dateTo,

          submitted: true
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newTutorial() {
    this.setState({
      id: null,
      yacht: "",
      customer: "",
      dateFrom: "",
      dateTo: "",

      submitted: false
    });
  }

  render() {
    // ...
  }
}