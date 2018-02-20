package model;

import java.util.ArrayList;
import java.util.List;

public class TheatreLayout {

    List<SeatRow> seatingLayout;

    TheatreLayout() {
        seatingLayout = new ArrayList<SeatRow>();
    }

    public void addRows(SeatRow ... rows) {
        for(SeatRow row : rows) {
            seatingLayout.add(row);
        }
    }

    public List<SeatRow> getSeatingLayout() {
        return seatingLayout;
    }


}
