package model;

public class ParkedCar {
    private int ticketNumber;
    private String licencePlate;

    public ParkedCar(int ticketNumber, String licencePlate) {
        this.ticketNumber = ticketNumber;
        this.licencePlate = licencePlate;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        else if (o == null || getClass() != o.getClass()){
            return false;
        }
        else{
        ParkedCar parkedCar = (ParkedCar) o;
        return ticketNumber == parkedCar.ticketNumber && licencePlate.equals(parkedCar.licencePlate);
        }
    }
}
