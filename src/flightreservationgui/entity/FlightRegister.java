package flightreservationgui.entity;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The FlightRegister class represents a flight register in a flight reservation
 * system where you can add and remove flights.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class FlightRegister
{

    private HashSet<Flight> flights;

    /**
     * Constructor for objects of class FlightRegister.
     */
    public FlightRegister()
    {
        this.flights = new HashSet<>();
    }

    /**
     * Adds a flight by the given flight object to the flight register.
     *
     * @param flight The flight to be added.
     */
    public void addFlight(Flight flight)
    {
        this.flights.add(flight);
    }

    /**
     * Removes the given flight object from the flight register.
     *
     * @param flight The flight to be removed.
     */
    public void removeFlight(Flight flight)
    {
        this.flights.remove(flight);
    }

    public int getNumberOfFlights()
    {
        return this.flights.size();
    }

    /**
     * Returns the iterator of the Flight Register class.
     *
     * @return The iterator of the Flight Register class.
     */
    public Iterator<Flight> getFlightRegIterator()
    {
        return flights.iterator();
    }
}
