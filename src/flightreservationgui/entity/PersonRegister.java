package flightreservationgui.entity;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The PersonRegister class represents a person register in a flight reservation
 * system where you can add and remove persons.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class PersonRegister
{

    private HashSet<Person> persons;

    /**
     * Constructor for objects of class PersonRegister.
     */
    public PersonRegister()
    {
        this.persons = new HashSet<>();
    }

    /**
     * Adds a passenger by the given passenger object to the passenger register.
     *
     * @param person The passenger to be added.
     */
    public void addPerson(Person person)
    {
        this.persons.add(person);
    }

    /**
     * Removes the given passenger object from the passenger register.
     *
     * @param person The passenger to be removed.
     */
    public void removePerson(Person person)
    {
        this.persons.remove(person);
    }

    /**
     * Returns the iterator of the Passenger Register class.
     *
     * @return The iterator of the Passenger Register class.
     */
    public Iterator<Person> getPersonRegIterator()
    {
        return this.persons.iterator();
    }

}
