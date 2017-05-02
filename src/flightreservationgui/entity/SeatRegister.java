package flightreservationgui.entity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The SeatRegister class represents a seat register in a flight reservation
 * system. It creates a seat register, where you can add a number of seats by
 * the given amount of rows and letters (columns), and holds a list of all the
 * seats where you have the possibility to add, remove and search for seats, as
 * well as getting the number of seats in the collection.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class SeatRegister
{

    private final ArrayList<Seat> seats;

    /**
     * Constructor for objects of class SeatRegister.
     */
    public SeatRegister()
    {
        this.seats = new ArrayList<>();
    }

    /**
     * Adds a given amount of seats to the seat register.
     *
     * @param numberOfRows The number of rows to be added.
     * @param numberOfLetters The numer of seats within a row to be added.
     */
    public void addSeats(int numberOfRows, int numberOfLetters)
    {
        this.fillSeats(numberOfRows, numberOfLetters);
    }

    /**
     * Adds a seat to the collection, given by the seat row and column (letter).
     *
     * @param row The row of where the seat should be added.
     * @param seatLetter The column of where the seat should be added.
     */
    private void addSeat(int row, String seatLetter)
    {
        this.seats.add(new Seat(row, seatLetter));
    }

    /**
     * Removes the given seat from the seat register.
     *
     * @param seat The seat to be removed.
     */
    public void removeSeat(String seat)
    {
        Iterator<Seat> it = this.seats.iterator();
        boolean found = false;
        Seat s = null;
        while (it.hasNext() && !found)
        {
            s = it.next();
            if (s.getSeatId().equals(seat.toUpperCase()))
            {
                found = true;
                it.remove();
            }
        }
    }

    /**
     * Returns the seat object given by the seat ID input.
     *
     * @param seatId The seat ID of the seat object to be returned.
     * @return The seat object given by the seat ID input.
     */
    public Seat getSeatById(String seatId)
    {
        Iterator<Seat> it = this.seats.iterator();
        Seat foundSeat = null;
        boolean found = false;
        while (it.hasNext() && !found)
        {
            Seat currentSeat = it.next();
            if (currentSeat.getSeatId().equals(seatId.toUpperCase()))
            {
                foundSeat = currentSeat;
                found = true;
            }
        }
        return foundSeat;
    }

    /**
     * Sets the given seat to be unavailable.
     *
     * @param seatId The seat to be set as unavailable.
     */
    public void setSeatToUnavailable(String seatId)
    {
        this.getSeatById(seatId).setUnavailable();
    }

    /**
     * Returns the total number of seats in the register.
     *
     * @return The total number of seats.
     */
    public int getNumberOfSeats()
    {
        return this.seats.size();
    }

    /**
     * Returns the total number of available seats.
     *
     * @return The total number of available seats.
     */
    public int getNumberOfAvailableSeats()
    {
        int numberOfAvailableSeats = 0;
        for (Seat seat : seats)
        {
            if (seat.isAvailable())
            {
                numberOfAvailableSeats++;
            }
        }
        return numberOfAvailableSeats;
    }

    /**
     * Fills the flight with the right amount of seats by the number of rows and
     * letters from the given inputs.
     *
     * @param numberOfRows How many rows of seats to be created.
     * @param numberOfLetters How many letters (columns) of seats to be created.
     */
    private void fillSeats(int numberOfRows, int numberOfLetters)
    {
        for (int index = 1; index <= numberOfRows; index++)
        {
            for (int letter = 0; letter < numberOfLetters; letter++)
            {
                this.addSeat(index, getCharForNumber(letter));
            }
        }
    }

    /**
     * Returns the iterator of the Seat Register class.
     *
     * @return The iterator of the Seat Register class.
     */
    public Iterator<Seat> getSeatRegIterator()
    {
        return this.seats.iterator();
    }

    /**
     * Returns the letter of the given input number.
     *
     * @return The letter of the input number.
     */
    private String getCharForNumber(int index)
    {
        CharSequence css = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (index > 25)
        {
            return null;
        }
        return css.charAt(index) + "";
    }

}
