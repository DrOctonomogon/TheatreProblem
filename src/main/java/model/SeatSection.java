package model;

public class SeatSection {

    private Integer capacity;
    private Integer availableSeats;

    SeatSection(Integer capacity) {
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public void reserveSeats(Integer numberOfSeats) {
        if(availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
        }
        else {
//            TODO: Refactor this into a try/catch with error handling
        }
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return availableSeats.toString();
    }
}
