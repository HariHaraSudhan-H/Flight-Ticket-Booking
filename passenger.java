public class passenger {
    static int i =1;
    private int passengerID;
    private String PassengerName;
    private int seatCountBooked;
    private int ticketCost;
    
    public passenger(String passengerName, int seatCountBooked) {
        this.passengerID=i;
        i++;
        PassengerName = passengerName;
        this.seatCountBooked = seatCountBooked;
    }
    public String getPassengerName() {
        return PassengerName;
    }
    public int getSeatCountBooked() {
        return seatCountBooked;
    }
    public int getTicketCost() {
        return ticketCost;
    }
    public void setTicketCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }
    public int getPassengerID() {
        return passengerID;
    }
    
    
}
