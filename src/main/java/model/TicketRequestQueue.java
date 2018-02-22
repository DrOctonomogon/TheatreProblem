package model;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketRequestQueue {

    private Queue<TicketRequest> ticketRequests;

    public TicketRequestQueue() {
        ticketRequests = new LinkedBlockingQueue<TicketRequest>();
    }

    public void addRequest(TicketRequest ticketRequest) {
        ticketRequests.add(ticketRequest);
    }

    public TicketRequest removeNextRequest() {
        return ticketRequests.remove();
    }

    public TicketRequest viewNextRequest() {
        return ticketRequests.peek();
    }

    public Integer countRemainingRequests() {
        return ticketRequests.size();
    }

    public Iterator<TicketRequest> getRequestIterator() {
        return ticketRequests.iterator();
    }
}
