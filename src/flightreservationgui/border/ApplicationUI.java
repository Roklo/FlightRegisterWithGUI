package flightreservationgui.border;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class ApplicationUI
{

    private Application application = null;

    String[] menuItems =
    {
        "1. Create flight",
        "2. Sell ticket to passenger",
        "3. Register ...",
        "4. List ..."
    };

    String[] regMenuItems =
    {
        "1. Register pilot",
        "2. Register crew",
        "3. Register passenger",
        "4. Back"
    };

    String[] listMenuItems =
    {
        "1. List seats in flight",
        "2. List available seats in flight",
        "3. List passengers in flight",
        "4. Back"
    };

    /**
     * Creates an instance of the POSApplicationUI User interface. An instance
     * of the POSApplication is created, and initialized.
     */
    public ApplicationUI()
    {
        //TODO: Replace "new Application" with your application class.
        this.application = new Application();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.application.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case 1:
                        this.application.doCreateFlight();
                        break;

                    case 2:
                        this.application.doSellTicket();
                        break;

                    case 3:
                        boolean back = false;
                        while (!back)
                        {
                            try
                            {
                                int regMenuSelection = this.showRegMenu();
                                switch (regMenuSelection)
                                {
                                    case 1:
                                        this.application.doRegisterPilot();
                                        break;
                                    case 2:
                                        this.application.doRegisterCrew();
                                        break;
                                    case 3:
                                        this.application.doRegisterPassenger();
                                        break;
                                    case 4:
                                        back = true;
                                        break;
                                    case 5:
                                        System.out.println("\nThank you for using"
                                                + " Application v0.1. Bye!\n");
                                        back = true;
                                        quit = true;
                                        break;
                                    default:
                                }
                            }
                            catch (InputMismatchException ime)
                            {
                                System.out.println("\nERROR: Please provide a number between"
                                        + " 1 and " + (this.regMenuItems.length + 1) + "..\n");
                            }
                        }
                        break;
                    case 4:
                        back = false;
                        while (!back)
                        {
                            try
                            {
                                int listMenuSelection = this.showListMenu();
                                switch (listMenuSelection)
                                {
                                    case 1:
                                        this.application.doListSeatsInFlight();
                                        break;

                                    case 2:
                                        this.application.doListAvailableSeatsInFlight();
                                        break;

                                    case 3:
                                        this.application.doListPassengersInFlight();
                                        break;
                                    case 4:
                                        back = true;
                                        break;
                                    case 5:
                                        System.out.println("\nThank you for using"
                                                + " Application v0.1. Bye!\n");
                                        back = true;
                                        quit = true;
                                        break;
                                    default:
                                }
                            }
                            catch (InputMismatchException ime)
                            {
                                System.out.println("\nERROR: Please provide a number between"
                                        + " 1 and " + (this.listMenuItems.length + 1) + "..\n");
                            }
                        }
                        break;

                    case 5:

                        this.application.doSellTicket();
                        break;

                    case 6:
                        this.application.doListSeatsInFlight();
                        break;

                    case 7:
                        this.application.doListAvailableSeatsInFlight();
                        break;

                    case 8:
                        this.application.doListPassengersInFlight();
                        break;

                    case 9:

                        System.out.println("\nThank you for using"
                                + " Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between"
                        + " 1 and " + (this.menuItems.length + 1) + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException
    {
        System.out.println("\n**** Application v0.1 ****\n");
        for (String menuItem : menuItems)
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-"
                + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    public Application getApp()
    {
        return this.application;
    }

    private int showRegMenu() throws InputMismatchException
    {
        System.out.println("\n**** Application v0.1 ****\n");
        for (String regMenuItem : regMenuItems)
        {
            System.out.println(regMenuItem);
        }
        int maxMenuItemNumber = regMenuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-"
                + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        int regMenuSelection = reader.nextInt();
        if ((regMenuSelection < 1) || (regMenuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return regMenuSelection;
    }

    private int showListMenu() throws InputMismatchException
    {
        System.out.println("\n**** Application v0.1 ****\n");
        for (String listMenuItem : listMenuItems)
        {
            System.out.println(listMenuItem);
        }
        int maxMenuItemNumber = listMenuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-"
                + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        int listMenuSelection = reader.nextInt();
        if ((listMenuSelection < 1) || (listMenuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return listMenuSelection;
    }

}
