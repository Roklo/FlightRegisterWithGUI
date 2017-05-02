package flightreservationgui.entity;

import java.util.HashMap;

/**
 * The EmloyeeInformation class is in charge for managing each of the crews
 * employee ID and the pilots sertificate numbers.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (31.03.2017)
 */
public class EmployeeInfomation
{

    HashMap<Integer, String> listOfEmployeeNumbers = new HashMap<>();
    HashMap<Integer, String> listOfSertificateNumbers = new HashMap<>();

    int lastEmployeeNumber = 0;

    String lastEmployeeNumberString = "000000";
    String currentEmployeeNumberString = "";

    /**
     * Creates a new employee number and adds this number to hasmap along with
     * the employees full name.
     *
     * @param foreName First name
     * @param lastName Last name
     * @return Return the newly created employee number for the given person.
     */
    public String getNewEmployeeNumber(String foreName, String lastName)
    {
        lastEmployeeNumber++;
        String fullName = foreName + " " + lastName;

        //TODO: Implement when quit function is created
        /*
        if (lastEmployeeNumber > 100000)
        {
            currentEmployeeNumberString = "ERROR";
        }
         */
        if (lastEmployeeNumber < 100000)
        {
            currentEmployeeNumberString = ""
                    + lastEmployeeNumber;

            if (lastEmployeeNumber < 10000)
            {
                currentEmployeeNumberString = "0"
                        + lastEmployeeNumber;

                if (lastEmployeeNumber < 1000)
                {
                    currentEmployeeNumberString = "00"
                            + lastEmployeeNumber;

                    if (lastEmployeeNumber < 100)
                    {
                        currentEmployeeNumberString = "000"
                                + lastEmployeeNumber;

                        if (lastEmployeeNumber < 10)
                        {
                            currentEmployeeNumberString = "0000"
                                    + lastEmployeeNumber;
                        }
                    }
                }
            }
        }

        Integer currentEmployeeNumberInt = Integer
                .valueOf(currentEmployeeNumberString);

        listOfEmployeeNumbers.put(currentEmployeeNumberInt, fullName);

        return currentEmployeeNumberString;
    }

    /**
     * Checks if the given certificate number already exist on an already
     * registered pilot. If the certificate does not exist, the sertificate will
     * be added to the hashmap listOfSertificateNumbers
     *
     * @param foreName First name
     * @param lastName Last name
     * @param sertificateId Unique sertificate id
     * @return Returns true if an sertificate already exist in the system
     *
     */
    public boolean addSertificate(String foreName, String lastName,
            String sertificateId)
    {

        String fullName = foreName + " " + lastName;

        Integer sertificateIdInt = Integer.valueOf(sertificateId);

        boolean dublicateExist = true;

        if (!listOfSertificateNumbers.containsKey(sertificateIdInt))
        {
            dublicateExist = false;

            listOfSertificateNumbers.put(sertificateIdInt, fullName);
        }

        return dublicateExist;
    }

    //TODO: (ROBIN) Add getter to get lists.
    //Spør:
    //1. Exit metode i hvorhen man er
    //2. sertifikat nummer, starte på 1 eller inntastet vedi?
    //3. Tips på EMAIL:REGEX
}
