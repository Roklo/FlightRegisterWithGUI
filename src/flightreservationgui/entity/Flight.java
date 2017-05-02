package flightreservationgui.entity;

import java.util.Iterator;
import java.util.List;

/**
 * The flight class represents a flight in a flight reservation system. It holds
 * the details about the flight such as flightID, destinationAirport,
 * departureAirport, departureTime, departureDate, arrivalTime and arrivalDate.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 2.0 (07.03.2017)
 */
public class Flight
{

    private final String flightID;
    private final String destinationAirport;
    private final String departureAirport;

    private int departureHour;
    private int departureMinute;
    private int arrivalMinute;
    private int arrivalHour;

    private int departureDay;
    private int departureMonth;
    private int departureYear;
    private int arrivalDay;
    private int arrivalMonth;
    private int arrivalYear;

    private int numberOfRows;
    private int numberOfLetters;

    private SeatRegister seats;
    private PassengerRegister passengers;
    private PersonRegister cabinCrew;
    private Person pilot;
    private Person copilot;

    /**
     * The constructor of the Flight class
     *
     * @param flightID The flight ID
     * @param pilot The pilot
     * @param copilot The copilot
     * @param destinationAirport The destination airport
     * @param cabinCrew The cabin crew list
     * @param departureAirport The departure airport
     * @param departureHour The departure hour
     * @param departureMinute The departure minute
     * @param arrivalHour The arrival hour
     * @param arrivalMinute The arrival minute
     * @param departureDay The departure day
     * @param departureMonth The departure month
     * @param departureYear The departure year
     * @param arrivalDay The arrival day
     * @param arrivalMonth The arrival month
     * @param arrivalYear The arrival year
     * @param numberOfRows The amount of rows
     * @param numberOfLetters The amount of seats within a row
     *
     *
     */
    public Flight(String flightID, Person pilot, Person copilot,
            List<CabinCrew> cabinCrew, String destinationAirport,
            String departureAirport, int departureHour, int departureMinute,
            int arrivalHour, int arrivalMinute, int departureDay,
            int departureMonth, int departureYear, int arrivalDay,
            int arrivalMonth, int arrivalYear, int numberOfRows,
            int numberOfLetters)

    {
        this.flightID = flightID;
        this.pilot = pilot;
        this.copilot = copilot;
        this.cabinCrew = new PersonRegister();
        addCabinCrew(cabinCrew);
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.departureDay = departureDay;
        this.departureMonth = departureMonth;
        this.departureYear = departureYear;
        this.arrivalDay = arrivalDay;
        this.arrivalMonth = arrivalMonth;
        this.arrivalYear = arrivalYear;
        this.numberOfRows = numberOfRows;
        this.numberOfLetters = numberOfLetters;
        this.seats = new SeatRegister();
        addSeats(numberOfRows, numberOfLetters);
        this.passengers = new PassengerRegister();

    }

    /**
     * Return the flightID of the flight
     *
     * @return Return the flightID of the flight
     */
    public String getFlightID()
    {
        return flightID;
    }

    public Person getPilot()
    {
        return this.pilot;
    }

    public Person getCopilot()
    {
        return this.copilot;
    }

    /**
     * Returns the IATA of the destination airport.
     *
     * @return Returns the IATA of the destination airport.
     */
    public String getDestinationAirport()
    {
        return destinationAirport;
    }

    /**
     * Returns the IATA of the departure airport
     *
     * @return Returns the IATA of the departure airport
     */
    public String getDepartureAirport()
    {
        return departureAirport;
    }

    /**
     * Returns the departure hour of the flight
     *
     * @return Returns the departure hour of the flight
     */
    public int getDepartureHour()
    {
        return departureHour;
    }

    /**
     * Sets the departure hour of the flight
     *
     * @param departureHour The departure hour of the flight
     */
    public void setDepartureHour(int departureHour)
    {
        this.departureHour = departureHour;
    }

    /**
     * Returns the departure minute of the flight
     *
     * @return Returns the departure minute of the flight
     */
    public int getDepartureMinute()
    {
        return departureMinute;
    }

    /**
     * Sets the departure minute of the flight
     *
     * @param departureMinute The departure minute of the flight
     */
    public void setDepartureMinute(int departureMinute)
    {
        this.departureMinute = departureMinute;
    }

    /**
     * Returns the arrival minute of the flight
     *
     * @return Returns the arrival minute of the flight
     */
    public int getArrivalMinute()
    {
        return arrivalMinute;
    }

    /**
     * Sets the arrival minute of the flight
     *
     * @param arrivalMinute The arrival minute of the flight
     */
    public void setArrivalMinute(int arrivalMinute)
    {
        this.arrivalMinute = arrivalMinute;
    }

    /**
     * Returns the arrival hour of the flight
     *
     * @return Returns the arrival hour of the flight
     */
    public int getArrivalHour()
    {
        return arrivalHour;
    }

    /**
     * Sets the arrival hour of the flight
     *
     * @param arrivalHour The arrival hour of the flight
     */
    public void setArrivalHour(int arrivalHour)
    {
        this.arrivalHour = arrivalHour;
    }

    /**
     * Returns the departure day of the flight
     *
     * @return Returns the departure day of the flight
     */
    public int getDepartureDay()
    {
        return departureDay;
    }

    /**
     * Sets the departure day of the flight
     *
     * @param departureDay The departure day of the flight
     */
    public void setDepartureDay(int departureDay)
    {
        this.departureDay = departureDay;
    }

    /**
     * Returns the departure month of the flight
     *
     * @return Returns the departure month of the flight
     */
    public int getDepartureMonth()
    {
        return departureMonth;
    }

    /**
     * Sets the departure month of the flight
     *
     * @param departureMonth The departure month of the flight
     */
    public void setDepartureMonth(int departureMonth)
    {
        this.departureMonth = departureMonth;
    }

    /**
     * Returns the departure year of the flight
     *
     * @return Returns the departure year of the flight
     */
    public int getDepartureYear()
    {
        return departureYear;
    }

    /**
     * Sets the arrival year of the flight
     *
     * @param departureYear The arrival year of the flight
     */
    public void setDepartureYear(int departureYear)
    {
        this.departureYear = departureYear;
    }

    /**
     * Returns the arrival day of the flight
     *
     * @return Returns the arrival day of the flight
     */
    public int getArrivalDay()
    {
        return arrivalDay;
    }

    /**
     * Sets the arrival day of the flight
     *
     * @param arrivalDay The arrival day of the flight
     */
    public void setArrivalDay(int arrivalDay)
    {
        this.arrivalDay = arrivalDay;
    }

    /**
     * Returns the arrival month of the flight
     *
     * @return Returns the arrival month of the flight
     */
    public int getArrivalMonth()
    {
        return arrivalMonth;
    }

    /**
     * Sets the arrival month of the flight
     *
     * @param arrivalMonth The arrival month of the flight
     */
    public void setArrivalMonth(int arrivalMonth)
    {
        this.arrivalMonth = arrivalMonth;
    }

    /**
     * Returns the arrival year of the flight
     *
     * @return Returns the arrival year of the flight
     */
    public int getArrivalYear()
    {
        return arrivalYear;
    }

    /**
     * Sets the arrival year of the flight
     *
     * @param arrivalYear The arrival year of the flight
     */
    public void setArrivalYear(int arrivalYear)
    {
        this.arrivalYear = arrivalYear;
    }

    /**
     * Returns the number of rows in the flight.
     *
     * @return The number of rows in the flight.
     */
    public int getNumberOfRows()
    {
        return this.numberOfRows;
    }

    /**
     * Returns the number of seats within a row.
     *
     * @return The number of seats within a row.
     */
    public int getNumberOfLetters()
    {
        return this.numberOfLetters;
    }

    /**
     * A method for returning number of flight days Not nessesarry for Fase 2
     *
     * /*
     * public void getFlightDays() { int deltaDay = 0; int deltaMonth = 0; int
     * deltaYear = 0; deltaDay = getDepartureDay() - getArrivalDay(); deltaMonth
     * = getDepartureMonth() - getArrivalMonth(); deltaYear = getDepartureYear()
     * - getArrivalYear();
     *
     * if (deltaDay < 0) { deltaDayString = Integer.toString(deltaDay) }
     * System.out.println("Days: " + deltaDay + ); }
     */
    /**
     * Returns the calculates total flight time.
     *
     * @return Returns the total flight time.
     */
    public String getFlightTime()
    {
        //TODO: Add a return Calculates the total flight time of the flight
        //statement so it will return the time as string.

        String deltaMinuteString = null;
        String deltaHourString = null;

        int deltaMinute = getArrivalMinute() - getDepartureMinute();
        //System.out.println(deltaMinute);
        int deltaHour = getArrivalHour() - getDepartureHour();
        //System.out.println(deltaHour);

        //  If minutes result in a number lower than 0. Take one hour from
        // deltaHour to compensate and add 60 minutes to the negative number.
        if (deltaMinute < 0)
        {
            deltaHour = deltaHour - 1;
            deltaMinute = 60 + deltaMinute;
        }
        if (deltaHour < 0)
        {
            deltaHour = 24 + deltaHour;
        }

        // Create a 0 infront of any number lower than 10 to get a digital 
        // clock form of the number
        if (deltaMinute < 10)
        {
            deltaMinuteString = "0" + deltaMinute;
        }
        else
        {
            deltaMinuteString = Integer.toString(deltaMinute);
        }
        if (deltaHour < 10)
        {
            deltaHourString = "0" + deltaHour;
        }
        else
        {
            deltaHourString = Integer.toString(deltaHour);
        }
        return (deltaHourString + ":" + deltaMinuteString);

        /*
        System.out.println("Flight time: "
                + deltaHourString + ":" + deltaMinuteString + " Hours");
         */
    }

    /**
     * Adds seats to the flight with the given amount of rows and columns.
     *
     * @param rows The amount of rows
     * @param letters The amount of columns
     */
    public void addSeats(int rows, int letters)
    {
        seats.addSeats(rows, letters);
    }

    /**
     * Returns all seats for the flight
     *
     * @return Returns all seats on the flight
     */
    public SeatRegister getSeats()
    {
        return seats;
    }

    /**
     * Adds a given passenger to the passenger register.
     *
     * @param pas The given passenger.
     */
    public void addPassenger(Passenger pas)
    {
        passengers.addPassenger(pas);
    }

    private void addCabinCrew(List<CabinCrew> cabinCrewList)
    {
        for (CabinCrew crew : cabinCrewList)
        {
            this.cabinCrew.addPerson(crew);
        }
    }

    public String getAllCabinCrew()
    {
        String stringToReturn = "";
        Iterator<Person> it = this.cabinCrew.getPersonRegIterator();
        while (it.hasNext())
        {
            Person currentCrew = it.next();
            stringToReturn += currentCrew.getFirstName()
                    + " " + currentCrew.getLastName() + "\n";
        }
        return stringToReturn;
    }

    /**
     * Returns the iterator for the Passenger Register class.
     *
     * @return The iterator for the Passenger Register class.
     */
    public Iterator<Passenger> getPassRegIterator()
    {
        return passengers.getPassengerRegIterator();
    }

}
