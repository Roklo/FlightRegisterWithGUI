package flightreservationgui.border;

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

/**
 * This is just a DUMMY-class representing an Application. To be replaced with a
 * "proper" class.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Application
{

    private final TicketReservationSystem ticketSystem;
    private HashSet<Person> crewList;

    /**
     * Initializes the application. (does nothing)
     */
    public void init()
    {
        //System.out.println("Init was called");
    }

    /**
     * Constructor for application class
     */
    public Application()
    {
        this.ticketSystem = TicketReservationSystem.getInstance();
        this.crewList = new HashSet<>();
        EmployeeInfomation employeeInformation = new EmployeeInfomation();
    }

    /**
     * Creates a new flight. Prompts user for flight information.
     */
    void doCreateFlight()
    {
        System.out.println("---- Create a Flight ----");
        Scanner reader = new Scanner(System.in);
        String flightID = "";
        boolean done = false;
        while (!done)
        {
            System.out.println("Please enter a valid Flight ID (e.g. SK4145):");
            flightID = reader.nextLine();
            if (ticketSystem.getFlightByID(flightID) != null)
            {
                System.out.println(
                        "The entered Flight ID is already in use!\n");
            }
            else
            {
                done = true;
            }
        }

        //Add pilot
        System.out.println("\nPlease enter the name of the 1st Pilot:"
                + "\nEnter 'list' to list all pilots");
        String firstPilot = "";
        Person pilot = null;
        Person copilot = null;
        int pilotsAdded = 0;
        while (pilotsAdded < 2)
        {
            System.out.print("Add: ");
            String pilotToAdd = reader.nextLine();
            if (pilotToAdd.equals("list"))
            {
                System.out.println("\nList of all availible pilots:\n"
                        + ticketSystem.getAllAvailablePilots());
            }
            else if (!ticketSystem.getAllAvailablePilots().contains(pilotToAdd))
            {
                System.out.println("\nThe entered name is not a"
                        + " registered pilot!"
                        + "\nPlease choose a pilot from the list:\n"
                        + ticketSystem.getAllAvailablePilots());
            }
            else if (0 == pilotsAdded)
            {
                firstPilot = pilotToAdd;
                pilot = ticketSystem.getPersonByWholeName(pilotToAdd);
                System.out.println("1st Pilot added.\n"
                        + "\nPlease enter the name of the Copilot:" + "\n"
                        + "Enter 'list' to list all pilots");
                pilotsAdded += 1;
            }
            else if (firstPilot.equals(pilotToAdd))
            {
                System.out.println("\nThe Copilot cannot be the same as the"
                        + " 1st Pilot!" + "\nPlease choose a different"
                        + " Copilot from the list:\n"
                        + ticketSystem.getAllAvailablePilots());
            }
            else
            {
                copilot = ticketSystem.getPersonByWholeName(pilotToAdd);
                System.out.println("Copilot added.");
                pilotsAdded += 1;
            }
        }

        //Add crew
        List<CabinCrew> cabinCrew = new ArrayList<>();
        int maxCrewSize = 0;
        done = false;
        while (!done)
        {
            System.out.println("\nPlease enter the amount of cabin"
                    + " crew needed (2-4):");
            maxCrewSize = Integer.parseInt(reader.nextLine());
            if (maxCrewSize <= 4 && maxCrewSize >= 2)
            {
                done = true;
            }
            else
            {
                System.out.println("The entered number is not allowed!");
            }
        }
        System.out.println("\nPlease enter the name of a cabin crew employee:"
                + "\nEnter 'list' to list every available cabin crew.");

        String crewListString = "";
        int crewAdded = 0;
        while (crewAdded < maxCrewSize)
        {
            System.out.print("Add: ");
            String crew = reader.nextLine();
            if (crew.equals("list"))
            {
                System.out.println("\nList of all availible cabin crew:\n"
                        + ticketSystem.getAllAvailableCrew());
            }
            else if (crewListString.contains(crew))
            {
                System.out.println("\nThe selected employee is already added!"
                        + "\nPlease choose a different employee"
                        + " from the list:\n"
                        + ticketSystem.getAllAvailableCrew());
            }
            else if (!ticketSystem.getAllAvailableCrew().contains(crew))
            {
                System.out.println("\nThe entered name is not a"
                        + " registered employee!"
                        + "\nPlease choose a different employee"
                        + " from the list:\n"
                        + ticketSystem.getAllAvailableCrew());
            }
            else
            {
                cabinCrew.add((CabinCrew) ticketSystem.getPersonByWholeName(crew));
                crewAdded += 1;
                crewListString += crew;
                System.out.println(crewAdded + "/" + maxCrewSize
                        + " Cabin crew added.\n");
            }
        }

        String destinationAirport = promptForInput("Please enter the destination "
                + "airport (e.g. OSL)");

        String departureAirport = promptForInput(
                "please enter the departure airport (e.g. AES):");

        int departureHour
                = promptForInt(0, 23, "Please enter the departure hour");

        int departureMinute
                = promptForInt(0, 59, "Please enter the departure minute");

        int arrivalHour
                = promptForInt(0, 23, "Please enter the arrival hour");

        int arrivalMinute
                = promptForInt(0, 59, "Please enter the arrival minute");

        int departureDay
                = promptForInt(1, 31, "Please enter the departure day");

        int departureMonth
                = promptForInt(1, 12, "Please enter the departure month");

        int departureYear
                = promptForInt(0, 3000, "Please enter the departure year");

        int arrivalDay = promptForInt(1, 31, "Please enter the arrival day");

        int arrivalMonth
                = promptForInt(1, 12, "Please enter the arrival month");

        int arrivalYear
                = promptForInt(0, 3000, "Please enter the arrival year");

        int numberOfRows = promptForInt(1, 999, "Please enter the amount of rows of"
                + " seats in the plane");

        int numberOfLetters = promptForInt(1, 27, "Please enter the amount of "
                + "seats within a row");

        Flight newFlight = new Flight(flightID, pilot, copilot, cabinCrew,
                destinationAirport, departureAirport, departureHour,
                departureMinute, arrivalHour, arrivalMinute,
                departureDay, departureMonth, departureYear,
                arrivalDay, arrivalMonth, arrivalYear,
                numberOfRows, numberOfLetters);
        ticketSystem.addFlight(newFlight);

        System.out.println("\n\nThe following flight has been created:");
        System.out.println(newFlight.getFlightID() + ", "
                + newFlight.getDepartureAirport() + "->"
                + newFlight.getDestinationAirport() + ", "
                + (newFlight.getNumberOfRows() * newFlight.getNumberOfLetters())
                + " seats.");
        System.out.println("Departure: " + newFlight.getDepartureHour() + ":"
                + newFlight.getDepartureMinute() + ", "
                + newFlight.getDepartureDay() + "."
                + newFlight.getDepartureMonth() + "."
                + newFlight.getDepartureYear());
        System.out.println("Arrival: " + newFlight.getArrivalHour() + ":"
                + newFlight.getArrivalMinute() + ", "
                + newFlight.getArrivalDay() + "."
                + newFlight.getArrivalMonth() + "."
                + newFlight.getArrivalYear());
        System.out.println("Pilot: " + newFlight.getPilot().getFirstName()
                + " " + newFlight.getPilot().getLastName()
                + "\nCopilot: " + newFlight.getCopilot().getFirstName() + " "
                + newFlight.getCopilot().getLastName()
                + "\nCabin crew:\n" + newFlight.getAllCabinCrew());
    }

    /**
     * Registers a new pilot to the system. Prompts user for fields.
     */
    void doRegisterPilot()
    {
        System.out.println("\n---- Register a Pilot ----");
        System.out.println("Please enter the forename:");
        Scanner reader = new Scanner(System.in);
        String firstName = reader.nextLine();

        System.out.println("\nPlease enter the surname:");
        String lastName = reader.nextLine();

        String eMail = promptForEmail();

        System.out.println("\nPlease enter the certificate number (7 digits):");
        Boolean uniqueCertificateNumber = true;
        String certificateNumber = "";
        while (uniqueCertificateNumber)
        {
            certificateNumber = reader.nextLine();
            if (certificateNumber.length() != 7
                    || !certificateNumber.matches("[0-9]+"))
            {
                System.out.println("\nPlease enter an 7-digit number");
            }
            if (certificateNumber.length() == 7
                    && certificateNumber.matches("[0-9]+"))
            {
                uniqueCertificateNumber = ticketSystem.getEmployeeInformation()
                        .addSertificate(firstName, lastName, certificateNumber);

                if (uniqueCertificateNumber)
                {
                    System.out.println("\nThis sertificate number "
                            + "is already registered.");
                    System.out.println("Please enter the certificate number (7 digits):");
                }
            }
        }

        //Creates new emloyeeID
        String employeeID = ticketSystem.getEmployeeInformation()
                .getNewEmployeeNumber(firstName, lastName);

        //Creates the pilot 
        Person newPilot = new Pilot(firstName, lastName, eMail,
                certificateNumber, employeeID);

        ticketSystem.addPerson(newPilot);
        System.out.println("\n\nThe following pilot has been registered:");
        System.out.println(newPilot.getFirstName() + " "
                + newPilot.getLastName() + "\n"
                + newPilot.getEmail()
                + "\nEmployee ID: " + newPilot.getEmployeeID()
                + "\nCertificate Nr: " + newPilot.getCertificateNumber());
    }

    /**
     * Registers a new crewmember
     */
    void doRegisterCrew()
    {
        System.out.println("\n---- Register a Crew ----");
        System.out.println("Please enter the forename:");
        Scanner reader = new Scanner(System.in);
        String firstName = reader.nextLine();

        System.out.println("Please enter the surname:");
        String lastName = reader.nextLine();

        String eMail = promptForEmail();

        //Creates new emloyeeID
        String employeeID = ticketSystem.getEmployeeInformation()
                .getNewEmployeeNumber(firstName, lastName);

        //TODO: Implement when quit function is created
        /*
                if (employeeID == "ERROR")
        {
            System.out.println("ERROR, CONTACT SYSTEM ADMIN" + "\n"
                    + "ERRORCODE: OUT OF EMPLOYEE NUMBERS" + "\n" + "\n"
                    + "PRESS ANY KEY TO QUIT TO MAIN MENU");
            reader.nextLine();
        } */
        //Creates the cabin crew
        Person newCrew = new CabinCrew(firstName, lastName, eMail, employeeID);

        ticketSystem.addPerson(newCrew);
        System.out.println("\n\nThe following passenger has been registered:");
        System.out.println(newCrew.getFirstName() + " "
                + newCrew.getLastName() + ", "
                + newCrew.getEmail() + ", "
                + newCrew.getEmployeeID());
    }

    /**
     * Registers a new passenger. Prompts user for passenger information.
     */
    void doRegisterPassenger()
    {
        System.out.println("\n---- Register a Passenger ----");

        String firstName
                = promptForInput("Please enter the foreName of the passenger");

        String lastName
                = promptForInput("Please enter the surname of the passenger");

        String eMail = promptForEmail();

        Person newPassenger = new Passenger(firstName, lastName, eMail);
        ticketSystem.addPerson(newPassenger);
        System.out.println("\n\nThe following passenger has been registered:");
        System.out.println(newPassenger.getFirstName() + " "
                + newPassenger.getLastName()
                + "\n" + newPassenger.getEmail());
    }

    /**
     * Gets a passenger, prompts user for input
     *
     * @return a passenger
     */
    private Passenger getPassenger()
    {
        Scanner reader = new Scanner(System.in);
        Passenger passenger = null;
        boolean searching = true;
        String firstName = null;
        String lastName = null;

        while (searching)
        {
            if (lastName == null)
            {
                System.out.println("Please enter the last name of the passenger:");
                lastName = reader.nextLine();
                System.out.println(); //spacing
            }
            int passengerCount
                    = ticketSystem.getNumberOfPassengersWithName(firstName, lastName);
            int functionInt = Integer.min(6, passengerCount);

            switch (functionInt)
            {
                case 0:
                    System.out.println("No passengers with that name was found");
                    lastName = null;
                    firstName = null;
                    break;

                case 1:
                    passenger = ticketSystem.getPassengerByLastName(lastName);
                    searching = false;
                    break;

                case 2:
                case 3:
                case 4:
                case 5:
                    ArrayList<Passenger> listOfMatches = ticketSystem
                            .getArrayListOfPassengersWithName(firstName, lastName);
                    System.out.println(passengerCount + " matches "
                            + "\nPlease select a Passenger by index");
                    int size = listOfMatches.size();
                    for (int index = 0; index < size; index++)
                    {
                        System.out.println(index + ":  "
                                + listOfMatches.get(index).toString());
                    }
                    int selectedIndex = promptForInt(0, size,
                            "Please select a Passenger by index");
                    passenger = listOfMatches.get(selectedIndex);
                    searching = false;
                    break;

                case 6:

                    if (firstName == null)
                    {
                        System.out.println(passengerCount + " passenger with that "
                                + "lastname was found.");
                        System.out.println("Please enter the firstname of the "
                                + "passenger");
                        firstName = reader.nextLine();
                    }
                    else
                    {
                        System.out.println("Theres too many people with that first and lastname :(");
                        firstName = null;
                        lastName = null;
                    }
            }
        }

        System.out.println(
                "Selected person: \n" + passenger.toString());
        return passenger;
    }

    /**
     * Sells a ticket to a passenger. Prompts user for passenger and flight
     * info.
     */
    void doSellTicket()
    {
        System.out.println("\n-- Sell Ticket to Passenger --");
        Scanner reader = new Scanner(System.in);

        Passenger passenger = getPassenger();

        //TODO: Insert 'Please choose the airport you are travelling from:'
        boolean searching = true;
        String destination = "";
        while (searching)
        {
            System.out.println(
                    "Please choose a destination (e.g. OSL):");
            destination = reader.nextLine();
            if (ticketSystem.getAllFlightsByDestination(destination).equals(""))
            {
                System.out.println("\nNo flights found by that destination.");
            }
            else
            {
                searching = false;
            }
        }

        Flight flight = null;
        String flightID = null;
        searching = true;
        while (searching)
        {
            System.out.println(
                    "\nPlease choose a flight:");
            System.out.println(
                    ticketSystem.getAllFlightsByDestination(destination));
            flightID = reader.nextLine();
            flight = ticketSystem.getFlightByID(flightID);
            if (flight != null)
            {
                searching = false;
            }
            else
            {
                System.out.println("Invalid flight ID!");
            }
        }
        String seat = "";
        Seat selectedSeat = null;
        searching = true;
        while (searching)
        {
            System.out.println(
                    "\nPlease choose a seat:");
            System.out.println(ticketSystem.getAvailableSeatsInFlight(flight));
            seat = reader.nextLine();
            selectedSeat = ticketSystem.getSeatByID(flight, seat);
            if (selectedSeat != null)
            {
                searching = false;
                ticketSystem.setSeatToUnavailable(selectedSeat);
            }
            else
            {
                System.out.println("Invalid seat ID!");
            }
        }

        System.out.println(
                "\nPlease enter a valid ticket ID (e.g. 1001):");
        int ticketID = reader.nextInt();

        System.out.println(
                "\nPlease enter the ticket price in NOK:");
        int price = reader.nextInt();

        Ticket newTicket = new Ticket(passenger, flight,
                selectedSeat, flightID, ticketID, price);

        ticketSystem.addTicket(newTicket);

        flight.addPassenger(passenger);

        System.out.println(
                "\n\nThe following ticket has been sold:");
        System.out.println(newTicket.getPassenger().getFirstName() + " "
                + newTicket.getPassenger().getLastName()
                + ", TicketNr: " + newTicket.getTicketID());
        System.out.println(
                "Flight: " + newTicket.getFlightID() + " "
                + newTicket.getFlight().getDepartureAirport()
                + "->" + newTicket.getFlight().getDestinationAirport()
                + ", Seat " + newTicket.getSeat().getSeatId());
        System.out.println(
                "Departure: " + flight.getDepartureHour() + ":"
                + flight.getDepartureMinute() + ", "
                + flight.getDepartureDay() + "."
                + flight.getDepartureMonth() + "."
                + flight.getDepartureYear());
        System.out.println(
                "Arrival: " + flight.getArrivalHour() + ":"
                + flight.getArrivalMinute() + ", "
                + flight.getArrivalDay() + "."
                + flight.getArrivalMonth() + "."
                + flight.getArrivalYear());
        System.out.println(
                "Price: " + newTicket.getPrice() + "\n");
    }

    /**
     * Lists all the seats in a given flight. Prompts user for flight id using
     * reader.
     */
    void doListSeatsInFlight()
    {
        System.out.println("\n--- List Seats in a Flight ---");
        String seatsInFlight
                = ticketSystem.getSeats(chooseAFlight());
        if (seatsInFlight.isEmpty())
        {
            System.out.println("\nThere are no registered"
                    + " seats in this flight!");
        }
        else
        {
            System.out.println("\n" + seatsInFlight);
        }
    }

    /**
     * Lists all the available seats in a given flight. Prompts user for flight
     * id using reader.
     */
    void doListAvailableSeatsInFlight()
    {
        System.out.println("\n--- List Available Seats in a Flight ---");
        String seatsInFlight
                = ticketSystem.getAvailableSeatsInFlight(chooseAFlight());
        if (seatsInFlight.isEmpty())
        {
            System.out.println("\nThere are no registered"
                    + " seats in this flight!");
        }
        else
        {
            System.out.println("\n" + seatsInFlight);
        }
    }

    /**
     * Lists passengers in a flight. Prompts user for flight id using reader.
     */
    void doListPassengersInFlight()
    {
        System.out.println("\n--- List Passengers in a Flight ---");
        String passengersInFlight
                = ticketSystem.getPassengersInFlight(chooseAFlight());
        if (passengersInFlight.isEmpty())
        {
            System.out.println("\nThere are no registered"
                    + " passengers in this flight!");
        }
        else
        {
            System.out.println("\n" + passengersInFlight);
        }
    }

    /**
     * Gets a flight. Prompts user for flight id using reader.
     *
     * @return
     */
    private Flight chooseAFlight()
    {
        Flight flightToReturn = null;
        if (0 == ticketSystem.getNumberOfFlights())
        {
            System.out.println("There are no flights registered!");
        }
        else
        {
            boolean done = false;
            while (!done)
            {
                System.out.println("\nPlease choose a flight ID:");
                System.out.println(ticketSystem.getAllFlights());
                Scanner reader = new Scanner(System.in);
                Flight flight = ticketSystem.getFlightByID(reader.nextLine());
                if (flight == null)
                {
                    System.out.println("There are no flights by that ID.");
                }
                else
                {
                    done = true;
                    flightToReturn = flight;
                }
            }
        }
        return flightToReturn;
    }

    /**
     * Prompts user for a int input between two values, will not return value
     * before requirements are met.
     *
     * @param minValue The minimum input value.
     * @param maxValue The maxiumum input value.
     * @param displayText The message to display to user.
     * @return The integer from reader.
     */
    private int promptForInt(int minValue, int maxValue, String displayText)
    {
        Scanner reader = new Scanner(System.in);
        int returnInt = maxValue + 1;
        System.out.println("\n" + displayText + " ("
                + minValue + "-" + maxValue + ")");
        while ((returnInt > maxValue) || (returnInt < minValue))
        {
            returnInt = reader.nextInt();
            if ((returnInt > maxValue) || (returnInt < minValue))
            {
                System.out.println("Error: please enter a number between "
                        + minValue + " and " + maxValue);
            }
        }
        return returnInt;
    }

    private String promptForInput(String displayText)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println(displayText);
        boolean validInput = false;
        String returnString = null;
        while (!validInput)
        {
            returnString = reader.next().trim();
            if (returnString.equals(""))
            {
                System.out.println("Field is blank!");
                System.out.println(displayText);
            }
            else
            {
                validInput = true;
            }
        }
        return returnString;
    }

    public TicketReservationSystem getTicketSystem()
    {
        return this.ticketSystem;
    }

    private String promptForEmail()
    {
        Scanner reader = new Scanner(System.in);
        boolean done = false;
        String eMail = "";
        while (!done)
        {
            System.out.println("\nPlease enter an email address:");
            Boolean validEmail = false;
            while (!validEmail)
            {
                eMail = reader.nextLine();
                eMail = eMail.toLowerCase();
                String EMAIL_REGEX
                        = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                validEmail = eMail.matches(EMAIL_REGEX);
                if (validEmail == false)
                {
                    System.out.println("\nEmail: " + eMail
                            + " is not valid a valid email address."
                            + "\nPlease enter a valid email address:");
                }
            }
            if (ticketSystem.getPersonByEmail(eMail) != null)
            {
                System.out.println("This email address is already registered!");
            }
            else
            {
                done = true;
            }
        }
        return eMail;
    }

    public Application getApp()
    {
        return this;
    }
}
