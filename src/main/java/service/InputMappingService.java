package service;

import model.SeatRow;
import model.SeatSection;
import model.TheatreLayout;

public class InputMappingService {



    // Parse input
    public static String[] splitInputIntoRows(String input) {
        return input.split("\n");
    }

    /*********************************
     *  Methods for mapping layout   *
     *********************************/

    // Get number of rows in theatre
    private static Integer getNumberOfRowsInTheatre(String[] input) {

        Integer rowCount = 0;

        while(!input[rowCount].equals("")) {
            rowCount ++;
        }
        return rowCount;
    }

    public static TheatreLayout generateTheatreLayout(String[] input) {

        TheatreLayout theatreLayout = new TheatreLayout();
        Integer rowCount = input.length;

        for(int i = 0; i < rowCount; i++) {
            String[] splitRowSections = input[i].split(" ");
            SeatRow newRow = new SeatRow();
            for(int j = 0; j <= splitRowSections.length - 1; j++) {
                SeatSection newSection = new SeatSection(Integer.parseInt(splitRowSections[j]));
                newRow.addSections(newSection);
            }
            theatreLayout.addRows(newRow);
        }
        return theatreLayout;
    }

    /**************************************
     * Methods for mapping TicketRequests *
     **************************************/



}
