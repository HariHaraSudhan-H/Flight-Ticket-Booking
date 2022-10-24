import java.util.ArrayList;

public class flight {
    static int i = 1;
    private int flightID;
    private int seatCount;
    private int ticketPrice;
    private ArrayList<passenger> list;

    public flight() {
        this.flightID = i;
        i++;
        this.seatCount = 50;
        this.ticketPrice = 5000;
        list = new ArrayList<passenger>();
    }

    public void addPassengers(passenger Passenger) {
        Passenger.setTicketCost(ticketPrice * Passenger.getSeatCountBooked());
        list.add(Passenger);
        ticketPrice = ticketPrice + (200 * Passenger.getSeatCountBooked());
        seatCount = seatCount - Passenger.getSeatCountBooked();
        System.out.println("Booked Successfully for "+Passenger.getPassengerName()+" Passenger ID - "+Passenger.getPassengerID());
    }

    public void deletePassenger(int index) {
        passenger Passenger = list.get(index);
        ticketPrice = ticketPrice - (200 * Passenger.getSeatCountBooked());
        seatCount = seatCount + Passenger.getSeatCountBooked();
        System.out.println("Ticket cancelled for "+Passenger.getPassengerName()+" Passenger ID - "+Passenger.getPassengerID());
        list.remove(index);
    }

    public void printList() {
        for (passenger i : list) {

            System.out.println("\n Passenger ID : "+i.getPassengerID()+" Name : " + i.getPassengerName() + " Tickets Booked : "
                    + i.getSeatCountBooked() + " Cost of Ticket : " + i.getTicketCost());
        }

    }

    public int findPassenger(int passengerID) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getPassengerID()) == passengerID)
                return i;
        }
        return -1;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public ArrayList<passenger> getList() {
        return list;
    }
}
