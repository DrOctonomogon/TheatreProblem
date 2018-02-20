package model;

public class TicketRequest {

    private String name;
    private Integer partySize;

    TicketRequest(String name, Integer partySize) {
        this.name = name;
        this.partySize = partySize;
    }

    public String checkPartyName() {
        return name;
    }

    public Integer checkPartySize() {
        return partySize;
    }

    @Override
    public String toString() {
        return name + " " + partySize;
    }
}
