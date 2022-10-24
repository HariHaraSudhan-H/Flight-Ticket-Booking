import java.util.ArrayList;
import java.util.Scanner;

public class operation {
    public static ArrayList<flight> flights = new ArrayList<flight>();
    static Scanner scan = new Scanner(System.in);

    public static void flightOperations() {
        addFlights();
        while (true) {
            System.out.println("1. Book  2. Cancel  3. Print");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    printDetails();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void addFlights() {
        flights.add(new flight());
        flights.add(new flight());
    }

    public static void bookTicket() {
        printStatus();
        System.out.println("Enter flight ID....");
        int flightID = scan.nextInt();
        if (flightID > (flights.size())) {
            System.out.println("Sorry Invalid Choice");
            return;
        }
        if (flights.get(flightID - 1).getSeatCount() == 0) {
            System.out.println("No vacant seat available");
            return;
        }
        scan.nextLine();
        System.out.println("Enter Passenger Name...");
        String Name = scan.nextLine();
        System.out.println("Enter count of tickets");
        int count = scan.nextInt();
        if (flights.get(flightID - 1).getSeatCount() - count < 0) {
            System.out.println(
                    "Sorry There are only " + flights.get(flightID - 1).getSeatCount() + " Kindly book accordingly");
            return;
        }
        flights.get(flightID - 1).addPassengers(new passenger(Name, count));
        printStatus();
    }

    public static void cancelTicket() {
        printStatus();
        System.out.println("Enter flight ID....");
        int flightID = scan.nextInt();
        if (flightID > (flights.size())) {
            System.out.println("Sorry Invalid Choice");
            return;
        }
        System.out.println("Enter your Passenger ID");
        int passengerId = scan.nextInt();
        int index = flights.get(flightID - 1).findPassenger(passengerId);
        if (index == -1) {
            System.out.println("ID not found");
            printStatus();
            return;
        }
        flights.get(flightID - 1).deletePassenger(index);
        printStatus();
    }

    private static void printDetails() {
        for (flight i : flights) {
            System.out.println("Flight ID : " + i.getFlightID());
            i.printList();
            System.out.println();
        }
    }

    private static void printStatus() {
        for (flight i : flights) {
            System.out.println("Flight ID : " + i.getFlightID() + " Remaining Tickets " + i.getSeatCount()
                    + " Ticket cost" + i.getTicketPrice());
        }
    }
}
