package service;

import model.TicketRequest;
import model.TicketRequestQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketService {

    private static TicketService instance;
    private static TicketRequestQueue requestQueue;

    private TicketService() {}

    public TicketService getInstance() {
        if(instance == null) {
            instance = new TicketService();
        }
        return instance;
    }

    public void makeTicketRequests(TicketRequest ... requests) {
        for(TicketRequest request : requests) {
            requestQueue.addRequest(request);
        }
    }

    public Iterator<TicketRequest> getAllQueuedRequests() {
        return requestQueue.getRequestIterator();
    }

    public TicketRequest removeNextRequest() {
        TicketRequest retVal;
        try {
             retVal = requestQueue.removeNextRequest();
        }
        catch (NoSuchElementException e) {
            System.out.println("There are no more ticket requests");
            e.printStackTrace();
            return null;
        }
        return retVal;
    }
}
