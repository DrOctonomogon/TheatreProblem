package model;

import java.util.ArrayList;
import java.util.List;

public class SeatRow {

    private List<SeatSection> sections;

    SeatRow() {
        this.sections = new ArrayList<SeatSection>();
    }

    public List<SeatSection> getSections() {
        return sections;
    }

    public void addSections(SeatSection ... input) {
        for (SeatSection section : input) {
            sections.add(section);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (SeatSection section : sections) {
            output.append(section.toString() + " ");
        }
        return output.toString().trim();
    }
}
