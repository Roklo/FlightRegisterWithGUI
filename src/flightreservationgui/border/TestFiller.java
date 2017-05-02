/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationgui.border;

import flightreservationgui.FXMLDocumentController;
import flightreservationgui.border.ApplicationUI;
import flightreservationgui.entity.CabinCrew;
import flightreservationgui.entity.Flight;
import flightreservationgui.entity.Passenger;

import flightreservationgui.entity.Person;
import flightreservationgui.entity.Person;
import flightreservationgui.entity.Pilot;
import flightreservationgui.entity.Seat;
import flightreservationgui.entity.Ticket;
import flightreservationgui.facade.TicketReservationSystem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class TestFiller
{

    //private final FXMLDocumentController app;
    private TicketReservationSystem app = null;
    private Person persons;

    public TestFiller()
    {
        this.app = TicketReservationSystem.getInstance();
        //app = new FXMLDocumentController();
    }

    public void startFillingRegister()
    {

        addSomePassengers();
        addSomeCrew();
        addSomePilot();
        addSomeFlights();
        sellSomeTickets();
    }

    public void addSomePassengers()
    {
        Person person1 = new Passenger("Robin", "Thorholm",
                "rocio@gmail.com");
        Person person2 = new Passenger("Haakon", "Haram",
                "haakon.h@gmail.com");
        Person person3 = new Passenger("Bjornar", "Tennfjord",
                "bjorn_puzzyDestroyer69@gmail.com");
        Person person4 = new Passenger("Erlend", "Knudsen",
                "erlend@gmail.com");
        Person person5 = new Passenger("Espen", "Vad",
                "espen_vad@hotmail.com");
        Person person6 = new Passenger("Espen1", "Vad",
                "vaden59@gmail.com");
        Person person7 = new Passenger("Espen", "Vad",
                "espenErBest@gmail.com");
        Person person8 = new Passenger("Espen1", "Vad",
                "ebbes@gmail.com");
        Person person9 = new Passenger("Espen2", "Vad",
                "espen@gmail.com");
        Person person10 = new Passenger("Espen3", "Vad",
                "vadPower@gmail.com");
        Person person11 = new Passenger("Espen", "Vad",
                "tinderEspen@gmail.com");
        Person person15 = new Passenger("Espen", "Vad",
                "tinderEspen2@gmail.com");
        Person person16 = new Passenger("Espen", "Vad",
                "tinderEspenxXX@gmail.com");
        Person person12 = new Passenger("Bjornar1", "Tennfjord",
                "bmtennfjord@gmail.com");
        Person person13 = new Passenger("Bjornar2", "Tennfjord",
                "tennfjord@gmail.com");
        Person person14 = new Passenger("Bjornar3", "Tennfjord",
                "ElPedro@gmail.com");

        app.addPerson(person1);
        app.addPerson(person2);
        app.addPerson(person3);
        app.addPerson(person4);
        app.addPerson(person5);
        app.addPerson(person6);
        app.addPerson(person7);
        app.addPerson(person8);
        app.addPerson(person9);
        app.addPerson(person10);
        app.addPerson(person11);
        app.addPerson(person12);
        app.addPerson(person13);
        app.addPerson(person14);
        app.addPerson(person15);
        app.addPerson(person16);

    }

    private void addSomeCrew()
    {
        Person crew1 = new CabinCrew("Chuck", "Finley",
                "chuck@yahoo.com", "09001");
        Person crew2 = new CabinCrew("Chuck", "Bartowski",
                "chuck@cia.gov.com", "09002");
        Person crew3 = new CabinCrew("Blue", "Jay",
                "Barnes@Pearson.uk", "09003");
        Person crew4 = new CabinCrew("Dell", "Computer",
                "computer@dell.no", "09004");
        Person crew5 = new CabinCrew("The", "Machine",
                "01100011@yahoo.com", "09005");
        app.addPerson(crew1);
        app.addPerson(crew2);
        app.addPerson(crew3);
        app.addPerson(crew4);
        app.addPerson(crew5);

    }

    private void addSomePilot()
    {
        Person pilot1 = new Pilot("Peter", "Jackson",
                "peter@movie.com", "0100001", "09006");
        Person pilot2 = new Pilot("Suez", "Canal",
                "pirate@somalia.com", "0100002", "09007");
        Person pilot3 = new Pilot("Jack", "Sparrow",
                "Jack@pirate.com", "0100003", "09008");

        app.addPerson(pilot1);
        app.addPerson(pilot2);
        app.addPerson(pilot3);
    }

    private void addSomeFlights()
    {
        String name = "";
        name = "Peter Jackson";
        Person pilot
                = app.getPersonByWholeName(name);
        name = "Jack Sparrow";
        Person copilot
                = app.getPersonByWholeName(name);

        name = "Chuck Finley";
        Person crew1
                = app.getPersonByWholeName(name);
        name = "Blue Jay";
        Person crew2
                = app.getPersonByWholeName(name);
        name = "The Machine";
        Person crew3
                = app.getPersonByWholeName(name);
        List<CabinCrew> cabinCrew = new ArrayList<>();
        cabinCrew.add((CabinCrew) crew1);
        cabinCrew.add((CabinCrew) crew2);
        cabinCrew.add((CabinCrew) crew3);

        Flight flight1 = new Flight("SK1234", pilot, copilot, cabinCrew,
                "OSL", "AES", 10, 15, 11, 35, 4, 6, 2017, 4, 6, 2017, 14, 6);
        Flight flight2 = new Flight("SK5548", pilot, copilot, cabinCrew,
                "OSL", "AES", 11, 35, 12, 20, 4, 6, 2017, 4, 6, 2017, 14, 6);
        Flight flight3 = new Flight("WR3321", pilot, copilot, cabinCrew,
                "BGO", "AES", 12, 15, 13, 20, 4, 6, 2017, 4, 6, 2017, 8, 4);
        Flight flight4 = new Flight("NO4141", pilot, copilot, cabinCrew,
                "BGO", "AES", 11, 20, 12, 05, 4, 6, 2017, 4, 6, 2017, 14, 6);

        app.addFlight(flight1);
        app.addFlight(flight2);
        app.addFlight(flight3);
        app.addFlight(flight4);
    }

    private void sellSomeTickets()
    {
        Person person1 = new Passenger("Robin", "Thorholm",
                "rocio@gmail.com");
        Person person2 = new Passenger("Haakon", "Haram",
                "haakon.h@gmail.com");
        Person person3 = new Passenger("Bjornar", "Tennfjord",
                "bjorn_puzzyDestroyer69@gmail.com");

        Flight flight = app.getFlightByID("SK1234");
        Seat seat1 = app.getSeatByID(flight, "1A");
        Seat seat2 = app.getSeatByID(flight, "2B");
        Seat seat3 = app.getSeatByID(flight, "3C");

        Ticket ticket1 = new Ticket((Passenger) person1, flight, seat1,
                "SK1234", 1001, 3499);
        Ticket ticket2 = new Ticket((Passenger) person2, flight, seat2,
                "SK1234", 1002, 3499);
        Ticket ticket3 = new Ticket((Passenger) person3, flight, seat3,
                "SK1234", 1003, 3499);

        app.addTicket(ticket1);
        app.addTicket(ticket2);
        app.addTicket(ticket3);
    }

}
