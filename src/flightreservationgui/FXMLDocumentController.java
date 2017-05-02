/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationgui;

import flightreservationgui.border.Application;
import flightreservationgui.entity.CabinCrew;
import flightreservationgui.facade.TicketReservationSystem;
import flightreservationgui.entity.EmployeeInfomation;
import flightreservationgui.entity.Flight;
import flightreservationgui.entity.Passenger;
import flightreservationgui.entity.Person;
import flightreservationgui.entity.PersonRegister;
import flightreservationgui.entity.Pilot;
import flightreservationgui.entity.Seat;
import flightreservationgui.entity.Ticket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Håkon
 */
public class FXMLDocumentController implements Initializable
{

    private TicketReservationSystem ticketSystem
            = TicketReservationSystem.getInstance();
    //private HashSet<Person> crewList;

    //Main Menu
    @FXML
    private Button backButton, createButton, sellButton,
            registerButton, listButton;

    //Register Menu
    @FXML
    private Button doRegisterButton, pilotButton, crewButton, passengerButton;
    @FXML
    private TextField forenameInput, surnameInput,
            emailInput, certificateIDInput;

    //List Menu
    @FXML
    private Button listFlightsButton;
    @FXML
    private Button listTicketsButton;
    @FXML
    private Button listPassengersButton;
    //List Flights
    @FXML
    private Button getFlightsButton;
    @FXML
    private TableView<Flight> flightTable;
    @FXML
    private TableColumn<Flight, String> flightIdColumn;
    @FXML
    private TableColumn<Flight, String> departureAirportColumn;
    @FXML
    private TableColumn<Flight, String> destinationAirportColumn;
    //List Tickets
    @FXML
    private Button getTicketsButton;
    @FXML
    private TableView<Ticket> ticketTable;
    @FXML
    private TableColumn<Ticket, String> ticketIdColumn;
    @FXML
    private TableColumn<Ticket, String> passengerColumn;
    @FXML
    private TableColumn<Ticket, String> flightColumn;
    @FXML
    private TableColumn<Ticket, String> seatColumn;
    @FXML
    private TableColumn<Ticket, String> priceColumn;
    //List Passengers
    @FXML
    private Button getPassengersButton;
    @FXML
    private TextField flightIdInput;
    @FXML
    private TableView<Person> passengerTable;
    @FXML
    private TableColumn<Person, String> forenameColumn;
    @FXML
    private TableColumn<Person, String> lastnameColumn;
    @FXML
    private TableColumn<Person, String> emailColumn;

    //Create Menu
    @FXML
    private Button newFlightButton;
    @FXML
    private ComboBox pilotsComboBox;
    @FXML
    private ComboBox copilotComboBox;
    @FXML
    private ComboBox crew1ComboBox;
    @FXML
    private ComboBox crew2ComboBox;
    @FXML
    private TextField flightID;
    @FXML
    private TextField pilot;
    @FXML
    private TextField copilot;
    @FXML
    private TextField crew1;
    @FXML
    private TextField crew2;
    @FXML
    private TextField rows;
    @FXML
    private TextField columns;
    @FXML
    private TextField departure;
    @FXML
    private TextField departureHour;
    @FXML
    private TextField departureMin;
    @FXML
    private TextField departureDay;
    @FXML
    private TextField departureMonth;
    @FXML
    private TextField departureYear;
    @FXML
    private TextField destination;
    @FXML
    private TextField arrivalHour;
    @FXML
    private TextField arrivalMin;
    @FXML
    private TextField arrivalDay;
    @FXML
    private TextField arrivalMonth;
    @FXML
    private TextField arrivalYear;

    //Sell Menu
    @FXML
    private Button sellTicketButton;
    @FXML
    private TextField passengerInput;
    @FXML
    private TextField destinationInput;
    @FXML
    private TextField selectedFlightInput;
    @FXML
    private TextField selectedSeatInput;
    @FXML
    private TextField ticketIdInput;
    @FXML
    private TextField priceInput;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void listFlightsButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == listFlightsButton)
        {
            stage = (Stage) listFlightsButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_ListFlight.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void getFlightsAction(ActionEvent event) throws IOException
    {
        flightIdColumn.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("FlightID"));
        departureAirportColumn.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("DepartureAirport"));
        destinationAirportColumn.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("DestinationAirport"));
        flightTable.setItems(getFlights());
    }

    private ObservableList<Flight> getFlights()
    {
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Iterator<Flight> it = ticketSystem.getFlightRegIterator();
        while (it.hasNext())
        {
            flights.add(it.next());
        }
        return flights;
    }

    @FXML
    private void listTicketsButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == listTicketsButton)
        {
            stage = (Stage) listTicketsButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_ListTicket.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void getTicketsAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == getTicketsButton)
        {
            ticketIdColumn.setCellValueFactory(
                    new PropertyValueFactory<Ticket, String>("TicketID"));
            passengerColumn.setCellValueFactory(
                    new PropertyValueFactory<Ticket, String>("Passenger"));
            flightColumn.setCellValueFactory(
                    new PropertyValueFactory<Ticket, String>("FlightID"));
            seatColumn.setCellValueFactory(
                    new PropertyValueFactory<Ticket, String>("Seat"));
            priceColumn.setCellValueFactory(
                    new PropertyValueFactory<Ticket, String>("Price"));
            ticketTable.setItems(getTickets());
        }
    }

    private ObservableList<Ticket> getTickets()
    {
        ObservableList<Ticket> tickets = FXCollections.observableArrayList();
        Iterator<Ticket> it = ticketSystem.getTicketRegIterator();
        while (it.hasNext())
        {
            tickets.add(it.next());
        }
        return tickets;
    }

    @FXML
    private void listPassengersButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == listPassengersButton)
        {
            stage = (Stage) listPassengersButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_ListPassengers.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sellTicketButtonAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == sellTicketButton)
        {
            Passenger pas = (Passenger) ticketSystem.
                    getPersonByWholeName(passengerInput.getText());
            Flight flight
                    = ticketSystem.getFlightByID(selectedFlightInput.getText());

            Ticket ticket = new Ticket(
                    pas,
                    flight,
                    ticketSystem.getSeatByID(ticketSystem.getFlightByID(
                            selectedFlightInput.getText()),
                            selectedSeatInput.getText()),
                    selectedFlightInput.getText(),
                    Integer.parseInt(ticketIdInput.getText()),
                    Integer.parseInt(priceInput.getText()));
            ticketSystem.getFlightByID(
                    selectedFlightInput.getText()).addPassenger(pas);

            ticketSystem.addTicket(ticket);
            passengerInput.clear();
            destinationInput.clear();
            selectedFlightInput.clear();
            selectedSeatInput.clear();
            ticketIdInput.clear();
            priceInput.clear();

            System.out.println(ticket.toString());
        }
    }

    @FXML
    private void newFlightAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == newFlightButton)
        {
            Flight flight = new Flight(
                    flightID.getText(),
                    (Pilot) pilotsComboBox.getValue(),
                    (Pilot) copilotComboBox.getValue(),
                    getCrewList(),
                    destination.getText(),
                    departure.getText(),
                    Integer.parseInt(departureHour.getText()),
                    Integer.parseInt(departureMin.getText()),
                    Integer.parseInt(arrivalHour.getText()),
                    Integer.parseInt(arrivalMin.getText()),
                    Integer.parseInt(departureDay.getText()),
                    Integer.parseInt(departureMonth.getText()),
                    Integer.parseInt(departureYear.getText()),
                    Integer.parseInt(arrivalDay.getText()),
                    Integer.parseInt(arrivalMonth.getText()),
                    Integer.parseInt(arrivalYear.getText()),
                    Integer.parseInt(rows.getText()),
                    Integer.parseInt(columns.getText()));

            ticketSystem.addFlight(flight);

            flightID.clear();
            rows.clear();
            columns.clear();
            departure.clear();
            departureHour.clear();
            departureMin.clear();
            departureDay.clear();
            departureMonth.clear();
            departureYear.clear();
            destination.clear();
            arrivalHour.clear();
            arrivalMin.clear();
            arrivalDay.clear();
            arrivalMonth.clear();
            arrivalYear.clear();

            // System.out.println(
            //         ticketSystem.getFlightByID(flightID.getText()).toString());
        }
    }

    @FXML
    private void fillComboBoxes()
    {
        pilotsComboBox.setItems(getPilots());
        copilotComboBox.setItems(getPilots());
        crew1ComboBox.setItems(getCrew());
        crew2ComboBox.setItems(getCrew());
    }

    private ObservableList<String> getList()
    {
        ObservableList<String> list = FXCollections.observableArrayList(
                "Pilot 1", "Pilot 2");
        return list;
    }

    private List<CabinCrew> getCrewList()
    {
        List<CabinCrew> list = new ArrayList<>();
        list.add((CabinCrew) crew1ComboBox.getValue());
        list.add((CabinCrew) crew2ComboBox.getValue());
        return list;
    }

    @FXML
    private void getPassengerAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == getPassengersButton)
        {
            forenameColumn.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("FirstName"));
            lastnameColumn.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("LastName"));
            emailColumn.setCellValueFactory(
                    new PropertyValueFactory<Person, String>("Email"));
            passengerTable.setItems(getPassengers(flightIdInput.getText()));
        }
    }

    private ObservableList<Person> getPassengers(String flightID)
    {
        ObservableList<Person> passengers = FXCollections.observableArrayList();
        Iterator<Passenger> it
                = ticketSystem.getFlightByID(flightID).getPassRegIterator();
        // = ticketSystem.getPersonRegIterator();
        while (it.hasNext())
        {
            passengers.add(it.next());
        }
        return passengers;
    }

    private ObservableList<Person> getPilots()
    {
        ObservableList<Person> pilots = FXCollections.observableArrayList();
        Iterator<Person> it = ticketSystem.getPersonRegIterator();
        while (it.hasNext())
        {
            Person currentPilot = it.next();
            if (currentPilot instanceof Pilot)
            {
                pilots.add(currentPilot);
            }
        }
        return pilots;
    }

    private ObservableList<Person> getCrew()
    {
        ObservableList<Person> crew = FXCollections.observableArrayList();
        Iterator<Person> it = ticketSystem.getPersonRegIterator();
        while (it.hasNext())
        {
            Person currentCrew = it.next();
            if (currentCrew instanceof CabinCrew)
            {
                crew.add(currentCrew);
            }
        }
        return crew;
    }

    @FXML
    private void doRegisterPilotAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == doRegisterButton)
        {
            String employeeID = ticketSystem.getEmployeeInformation()
                    .getNewEmployeeNumber(forenameInput.getText(),
                            surnameInput.getText());

            Person newPilot = new Pilot(forenameInput.getText(),
                    surnameInput.getText(), emailInput.getText(),
                    certificateIDInput.getText(), employeeID);
            this.ticketSystem.addPerson(newPilot);

            System.out.println(newPilot.getFirstName() + " "
                    + newPilot.getLastName() + " "
                    + newPilot.getEmail() + " "
                    + newPilot.getCertificateNumber() + " "
                    + newPilot.getEmployeeID());

            forenameInput.clear();
            surnameInput.clear();
            emailInput.clear();
            certificateIDInput.clear();
        }
    }

    @FXML
    private void doRegisterCrewAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == doRegisterButton)
        {
            String employeeID = ticketSystem.getEmployeeInformation()
                    .getNewEmployeeNumber(forenameInput.getText(),
                            surnameInput.getText());

            Person newCrew = new CabinCrew(forenameInput.getText(),
                    surnameInput.getText(), emailInput.getText(), employeeID);
            this.ticketSystem.addPerson(newCrew);
            System.out.println(newCrew.getFirstName() + " "
                    + newCrew.getLastName() + " "
                    + newCrew.getEmail() + " "
                    + newCrew.getEmployeeID());
            forenameInput.clear();
            surnameInput.clear();
            emailInput.clear();
        }
    }

    @FXML
    private void doRegisterPassengerAction(ActionEvent event) throws IOException
    {
        if (event.getSource() == doRegisterButton)
        {
            Person newPassenger = new Passenger(forenameInput.getText(),
                    surnameInput.getText(), emailInput.getText());
            this.ticketSystem.addPerson(newPassenger);
            System.out.println(newPassenger.getFirstName() + " "
                    + newPassenger.getLastName() + " "
                    + newPassenger.getEmail());
            forenameInput.clear();
            surnameInput.clear();
            emailInput.clear();
        }
    }

    // Main Menu Button Actions
    @FXML
    private void createButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == createButton)
        {
            stage = (Stage) createButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_CreateFlight.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        fillComboBoxes();
    }

    @FXML
    private void sellButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == sellButton)
        {
            stage = (Stage) sellButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_SellMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void registerButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == registerButton)
        {
            stage = (Stage) registerButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_RegisterMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void listButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == listButton)
        {
            stage = (Stage) listButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_ListMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == backButton)
        {
            stage = (Stage) backButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_MainMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Register Menu Button Actions
    @FXML
    private void pilotButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == pilotButton)
        {
            stage = (Stage) pilotButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_RegisterPilot.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void crewButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == crewButton)
        {
            stage = (Stage) crewButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_RegisterCrew.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void passengerButtonAction(ActionEvent event) throws IOException
    {
        Stage stage = null;
        Parent root = null;
        if (event.getSource() == passengerButton)
        {
            stage = (Stage) passengerButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXML_RegisterPassenger.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public FXMLDocumentController getApp()
    {
        return this;
    }

    public TicketReservationSystem getTicketSystem()
    {
        return this.ticketSystem;
    }
}
