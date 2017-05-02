package flightreservationgui.facade;

import flightreservationgui.border.TestFiller;
import flightreservationgui.entity.Flight;
import flightreservationgui.entity.FlightRegister;
import flightreservationgui.entity.EmployeeInfomation;
import flightreservationgui.entity.Passenger;
import flightreservationgui.entity.Person;
import flightreservationgui.entity.PersonRegister;
import flightreservationgui.entity.Seat;
import flightreservationgui.entity.SeatRegister;
import flightreservationgui.entity.Ticket;
import flightreservationgui.entity.TicketRegister;
import flightreservationgui.entity.Pilot;
import flightreservationgui.entity.CabinCrew;
import java.util.ArrayList;

import java.util.Iterator;

/**
 * The TicketReservationSystem class represents the connection between the UI
 * (User Interface) and the entity classes. It handles most of the tasks needed
 * for the system to work, and deligates the tasks to the right places.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class TicketReservationSystem
{

    public static TicketReservationSystem instance;

    private PersonRegister persons;
    private FlightRegister flights;
    private TicketRegister tickets;
    private EmployeeInfomation employeeInformation;

    private TestFiller testFiller;

    /**
     * Constructor for objects of class TicketReservationSystem. Creates a
     * register for persons and flights.
     *
     */
    private TicketReservationSystem()
    {
        instance = null;
        this.persons = new PersonRegister();
        this.flights = new FlightRegister();
        this.tickets = new TicketRegister();
        this.employeeInformation = new EmployeeInfomation();

        //testFiller = new TestFiller();
        //testFiller.startFillingRegister();
    }

    public static TicketReservationSystem getInstance()
    {
        if (instance == null)
        {
            instance = new TicketReservationSystem();
        }
        return instance;
    }

    /**
     * Adds the given person to the person register.
     *
     * @param person The person to be added.
     */
    public void addPerson(Person person)
    {
        this.persons.addPerson(person);
    }

    /**
     * Adds the given flight to the flight register.
     *
     * @param flight The flight to be added.
     */
    public void addFlight(Flight flight)
    {
        this.flights.addFlight(flight);
    }

    /**
     * Adds the given ticket to the ticket register.
     *
     * @param ticket The ticket to be added.
     */
    public void addTicket(Ticket ticket)
    {
        this.tickets.addTicket(ticket);
    }

    /**
     * Gets a passenger by the given surname.
     *
     * @param lastName The surname of the passenger to be searched for.
     * @return The found passenger.
     */
    public Passenger getPassengerByLastName(String lastName)
    {
        ArrayList<Passenger> passengerList
                = getArrayListOfPassengersByLastName(lastName);
        return passengerList.get(0);
    }

    /**
     * Gets an array list of passengers by a given surname
     *
     * @param lastName is the surname to search for
     * @return an array list of passengers with the given name
     */
    public ArrayList<Passenger> getArrayListOfPassengersByLastName(String lastName)
    {
        boolean searching = true;
        ArrayList<Passenger> returnArray = new ArrayList<>();
        Person iteratorPerson;
        Iterator<Person> it = persons.getPersonRegIterator();
        while (it.hasNext() && searching)
        {
            iteratorPerson = it.next();
            if (iteratorPerson instanceof Passenger
                    && iteratorPerson.getLastName().equals(lastName))
            {
                returnArray.add((Passenger) iteratorPerson);
            }
        }
        return returnArray;
    }

    /**
     * Gets an array list of passengers by given Firstname and Surname. If
     * firstname String is null, the method will check for matches with lastname
     * only.
     *
     * @param firstName is the firstname of the person to search for
     * @param lastName is the lastname of the person to search for
     * @return an array list of passengers with the given name
     */
    public ArrayList<Passenger> getArrayListOfPassengersWithName(String firstName,
            String lastName)
    {
        boolean searching = true;
        ArrayList<Passenger> searchArray = getArrayListOfPassengersByLastName(lastName);
        ArrayList<Passenger> returnArray = new ArrayList<>();
        if (firstName != null)
        {
            for (Passenger pas : searchArray)
            {
                if (pas.getFirstName().equals(firstName))
                {
                    returnArray.add(pas);
                }
            }
        }
        else
        {
            returnArray = searchArray;
        }
        return returnArray;
    }

    /**
     * Returns a passenger by the given fore, and surname.
     *
     * @param firstName is the forename of the passenger to be searched for.
     * @param lastName The surname of the passenger to be searched for.
     * @return The found passenger.
     */
    public Passenger getPassengerByFullName(String firstName, String lastName)
    {

        ArrayList<Passenger> passengerList
                = getArrayListOfPassengersWithName(firstName, lastName);
        return passengerList.get(0);
    }

    /**
     * Gets the number of passengers with a given surname If firstname String is
     * null, the method will check for matches with lastname only.
     *
     * @param firstName is the firstname to search for
     * @param lastName is the surname to search for
     * @return the number of passengers with the given name
     */
    public int getNumberOfPassengersWithName(String firstName, String lastName)
    {
        ArrayList<Passenger> passengerList;
        if (firstName == null)
        {
            passengerList = getArrayListOfPassengersByLastName(lastName);
        }
        else
        {
            passengerList = getArrayListOfPassengersWithName(firstName, lastName);
        }
        int personCount = passengerList.size();
        return personCount;
    }

    /**
     * Gets a String list of people with a given surname
     *
     * @param lastName The given surname
     * @return a list of passengers lastname, firstname and email multiple
     * people are seperated by line
     *
     */
    public String getStringListOfPassengersByLastName(String lastName)
    {
        ArrayList<Passenger> passengerList
                = getArrayListOfPassengersByLastName(lastName);

        Iterator<Passenger> it = passengerList.iterator();
        Person iteratorPerson;
        String returnString = "";
        while (it.hasNext())
        {
            iteratorPerson = it.next();
            returnString += (iteratorPerson.toString() + "\n");
        }
        return returnString;
    }

    //test
    /**
     * Gets a person with the given surname
     *
     * @param lastName is the surname to look for
     * @return a person with the given surname;
     */
    public Person getPersonByLastName(String lastName)
    {
        Person person;
        Person personToReturn = null;
        Iterator<Person> it = persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            if (person.getLastName().equals(lastName))
            {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    /**
     * Returns a person with the given forename
     *
     * @param firstName the forename to look for
     * @return a person with the given forename;
     */
    public Person getPersonByFirstName(String firstName)
    {
        Person person;
        Person personToReturn = null;
        Iterator<Person> it = persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            if (person.getFirstName().equals(firstName))
            {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    /**
     * Returns a person with the given forename and surname
     *
     * @param name the name to look for
     * @return a person with the given forename and surname;
     */
    public Person getPersonByWholeName(String name)
    {
        Person person;
        Person personToReturn = null;
        Iterator<Person> it = persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            String tempName = person.getFirstName() + " "
                    + person.getLastName();
            if (tempName.equals(name))
            {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    /**
     * Returns a person with the given email address
     *
     * @param email the email to look for
     * @return a person with the given email address;
     */
    public Person getPersonByEmail(String email)
    {
        Person person;
        Person personToReturn = null;
        Iterator<Person> it = persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            if (person.getEmail().equals(email))
            {
                personToReturn = person;
            }
        }
        return personToReturn;
    }

    /**
     * Returns a flight by the given flight ID.
     *
     * @param flightID The flight ID of the flight to be searched for.
     * @return The found flight.
     */
    public Flight getFlightByID(String flightID)
    {
        boolean searching = true;
        Flight flight = null;
        Flight flightToReturn = null;
        Iterator<Flight> it = this.flights.getFlightRegIterator();
        while (it.hasNext() && searching)
        {
            flight = it.next();
            if (flight.getFlightID().equals(flightID))
            {
                searching = false;
                flightToReturn = flight;
            }
        }
        return flightToReturn;
    }

    /**
     * Returns a string of all the flights in the flight register.
     *
     * @return All the flights in the flight register.
     */
    public String getAllFlights()
    {
        String flightsToReturn = "";
        Flight flight = null;
        Iterator<Flight> it = this.flights.getFlightRegIterator();
        while (it.hasNext())
        {
            flight = it.next();
            if (flight != null)
            {
                flightsToReturn += flight.getFlightID() + " ";
            }
        }
        return flightsToReturn;
    }

    public int getNumberOfFlights()
    {
        return this.flights.getNumberOfFlights();
    }

    /**
     * Returns a string of all the flights by a given destination.
     *
     * @param destination The given destination to be searched for.
     * @return All the flights by the given destination.
     */
    public String getAllFlightsByDestination(String destination)
    {
        String flightsToReturn = "";
        Flight flight = null;
        Iterator<Flight> it = this.flights.getFlightRegIterator();
        while (it.hasNext())
        {
            flight = it.next();
            if (flight.getDestinationAirport().equals(destination))
            {
                flightsToReturn += flight.getFlightID() + " ";
            }
        }
        return flightsToReturn;
    }

    public String getAllAvailablePilots()
    {
        String pilotsToReturn = "";
        Person person = null;
        Iterator<Person> it = this.persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            if (person instanceof Pilot)
            {
                pilotsToReturn += person.getFirstName() + " "
                        + person.getLastName() + "\n";
            }
        }
        return pilotsToReturn;
    }

    public String getAllAvailableCrew()
    {
        String crewToReturn = "";
        Person person = null;
        Iterator<Person> it = this.persons.getPersonRegIterator();
        while (it.hasNext())
        {
            person = it.next();
            if (person instanceof CabinCrew)
            {
                crewToReturn += person.getFirstName() + " "
                        + person.getLastName() + "\n";
            }
        }
        return crewToReturn;
    }

    /**
     * Returns a seat from the given flight and seat ID.
     *
     * @param flight The flight where the seat is located.
     * @param seatID The seat to be returned.
     * @return The given seat of the flight.
     */
    public Seat getSeatByID(Flight flight, String seatID)
    {
        boolean searching = true;
        Seat seat = null;
        Seat seatToReturn = null;
        Iterator<Seat> it = flight.getSeats().getSeatRegIterator();
        while (it.hasNext() && searching)
        {
            seat = it.next();
            if (seat.getSeatId().equals(seatID))
            {
                seatToReturn = seat;
                searching = false;
            }
        }
        return seatToReturn;
    }

    /**
     * Returns a string of all the seats in a given flight.
     *
     * @param flight The flight where the seats are located.
     * @return All the seats within the flight.
     */
    public String getSeats(Flight flight)
    {
        int counter = 0;
        String seatsToReturn = "";
        Seat seat = null;
        Iterator<Seat> it = flight.getSeats().getSeatRegIterator();
        while (it.hasNext())
        {
            counter++;
            seat = it.next();
            if (seat != null)
            {
                if (counter == flight.getNumberOfLetters())
                {
                    seatsToReturn += seat.getSeatId() + "\n";
                    counter = 0;
                }
                else
                {
                    seatsToReturn += seat.getSeatId() + " ";
                }
            }
        }
        return seatsToReturn;
    }

    /**
     * Returns a string of all the seats in a given flight.
     *
     * @param flight The flight where the seats are located.
     * @return All the seats within the flight.
     */
    public String getAvailableSeatsInFlight(Flight flight)
    {
        int counter = 0;
        String seatsToReturn = "";
        Seat seat = null;
        Iterator<Seat> it = flight.getSeats().getSeatRegIterator();
        while (it.hasNext())
        {
            counter++;
            seat = it.next();
            if (seat != null && seat.isAvailable())
            {
                if (counter == flight.getNumberOfLetters())
                {
                    seatsToReturn += seat.getSeatId() + "\n";
                    counter = 0;
                }
                else
                {
                    seatsToReturn += seat.getSeatId() + " ";
                }
            }
            else if (seat != null && !seat.isAvailable())
            {
                for (int i = 0; i < seat.getSeatId().length(); i++)
                {
                    seatsToReturn += "-";
                }
                seatsToReturn += " ";
            }
        }
        return seatsToReturn;
    }

    /**
     * Sets the given seat to be unavailable.
     *
     * @param seat The given seat.
     */
    public void setSeatToUnavailable(Seat seat)
    {
        seat.setUnavailable();
    }

    /**
     * Returns a string of all the passengers within the given flight.
     *
     * @param flight The given flight.
     * @return All the passengers within the flight.
     */
    public String getPassengersInFlight(Flight flight)
    {
        String passengersToReturn = "";
        Passenger pas = null;
        Iterator<Passenger> it = flight.getPassRegIterator();
        while (it.hasNext())
        {
            pas = it.next();
            if (pas != null)
            {
                passengersToReturn += pas.getFirstName() + " "
                        + pas.getLastName()
                        + " - Seat " + getSeatByPassenger(pas) + "\n";
            }
        }
        return passengersToReturn;
    }

    public String getSeatByPassenger(Passenger pas)
    {
        String seatToReturn = "";
        Ticket ticket = null;
        boolean searching = true;
        Iterator<Ticket> it = tickets.getTicketRegIterator();
        while (it.hasNext() && searching)
        {
            ticket = it.next();
            if (ticket != null
                    && ticket.getPassenger().toString().equals(pas.toString()))
            {
                seatToReturn = ticket.getSeat().getSeatId();
                searching = false;
            }
            else
            {
                seatToReturn = "No seat was found by that passenger.";
            }
        }
        return seatToReturn;
    }

    public EmployeeInfomation getEmployeeInformation()
    {
        return this.employeeInformation;
    }

    /**
     * Returns the iterator of the Person Register.
     *
     * @return The iterator of the Person Register.
     */
    public Iterator<Person> getPersonRegIterator()
    {
        return this.persons.getPersonRegIterator();
    }

    public Iterator<Flight> getFlightRegIterator()
    {
        return this.flights.getFlightRegIterator();
    }

    public Iterator<Ticket> getTicketRegIterator()
    {
        return this.tickets.getTicketRegIterator();
    }

}
