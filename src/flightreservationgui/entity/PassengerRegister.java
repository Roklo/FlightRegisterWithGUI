package flightreservationgui.entity;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The PassengerRegister class represents a passenger register in a flight
 * reservation system where you can add and remove passengers.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class PassengerRegister
{

    private HashSet<Passenger> passengers;

    /**
     * Constructor for objects of class PassengerRegister.
     */
    public PassengerRegister()
    {
        this.passengers = new HashSet<>();
    }

    /**
     * Adds a passenger by the given passenger object to the passenger register.
     *
     * @param pas The passenger to be added.
     */
    public void addPassenger(Passenger pas)
    {
        this.passengers.add(pas);
    }

    /**
     * Removes the given passenger object from the passenger register.
     *
     * @param pas The passenger to be removed.
     */
    public void removePassenger(Passenger pas)
    {
        this.passengers.remove(pas);
    }

    /**
     * Returns the iterator of the Passenger Register class.
     *
     * @return The iterator of the Passenger Register class.
     */
    public Iterator<Passenger> getPassengerRegIterator()
    {
        return this.passengers.iterator();
    }

}
