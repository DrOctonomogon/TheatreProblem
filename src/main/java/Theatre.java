import java.util.LinkedHashMap;
import java.util.Map;

public class Theatre {

    Integer availableSeatsRemaining;
    Integer[][] theatreLayout;
    Map<String, Integer> ticketRequests;

    Theatre() {
        availableSeatsRemaining = 0;
    }

    public Map<String, Integer> getTicketRequests() {
        return this.ticketRequests;
    }

    // Parse input
    public static String[] splitInputIntoRows(String input) {
        return input.split("\n");
    }

    // Generate theatre layout
    public void generateTheatreLayout(String[] input) {

        Integer rowCount = input.length;
        Integer[][] seats = new Integer[rowCount][];

        for(int i = 0; i < rowCount; i++) {
            String[] splitRowSections = input[i].split(" ");
            seats[i] = new Integer[splitRowSections.length];
            for(int j = 0; j <= splitRowSections.length - 1; j++) {
                Integer seatsInSection = Integer.parseInt(splitRowSections[j]);
                seats[i][j] = seatsInSection;
                availableSeatsRemaining += seatsInSection;
            }
        }

        this.theatreLayout = seats;
    }

    // Get number of rows in theatre
    public static Integer getNumberOfRowsInTheatre(String[] input) {

        Integer rowCount = 0;

        while(!input[rowCount].equals("")) {
            rowCount ++;
        }
        return rowCount;
    }

    // Get remaining seats
    public Integer getAvailableSeatsRemaining() {
        return this.availableSeatsRemaining;
    }

    // Generate ticket request list
    public void generateTicketRequestList(String[] input) {

        this.ticketRequests = new LinkedHashMap<String, Integer>();

        Integer ticketRequestStartIndex = input.length - getNumberOfTicketRequests(input);

        for(int i = ticketRequestStartIndex; i < input.length; i++) {
            String[] rowList = input[i].split(" ");
            ticketRequests.put(rowList[0], Integer.parseInt(rowList[1]));
        }
    }

    public static Integer getNumberOfTicketRequests(String[] input) {

        Integer requestCount = input.length - 1;

        while(!input[requestCount].equals("")) {
            requestCount--;
        }
        return input.length - ++requestCount;
    }

    public Integer[][] getTheatreLayout() {
        return this.theatreLayout;
    }

    public void assignSeats() {
        if(ticketRequests != null && theatreLayout != null) {
            for (Integer value : ticketRequests.values()) {
                if(value < availableSeatsRemaining) {
                    System.out.println("Sorry, we can't handle your party.");
                }
                for(int i = 0; i < theatreLayout.length; i++) {
                    for(int j = 0; j < theatreLayout[i].length; j++) {
                        if(value == j) {
                            System.out.println();
                            theatreLayout[i][j] = 0;
                            availableSeatsRemaining -= value;
                        }
                    }
                }
            }
        }
    }

}
