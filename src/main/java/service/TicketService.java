package service;

import model.TicketRequest;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketService {

    private Queue<TicketRequest> ticketRequests;

    TicketService() {
        ticketRequests = new LinkedBlockingQueue<TicketRequest>();
    }

    public void makeTicketRequests(TicketRequest ... requests) {
        for(TicketRequest request : requests) {
            ticketRequests.add(request);
        }
    }

    public Iterator<TicketRequest> getAllQueuedRequests() {
        return ticketRequests.iterator();
    }

    public TicketRequest checkNextRequest() {
        return ticketRequests.peek();
    }

    public TicketRequest removeNextRequest() {
        TicketRequest retVal;
        try {
             retVal = ticketRequests.remove();
        }
        catch (NoSuchElementException e) {
            System.out.println("There are no more ticket requests");
            return null;
        }
        return retVal;
    }
}
