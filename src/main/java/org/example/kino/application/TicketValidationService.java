package org.example.kino.application;

import org.example.kino.model.Ticket;

public class TicketValidationService {

    public boolean validateTicketData(Ticket ticket) {
        if (ticket.getType().isEmpty()) {
            return false;
        }
        if (ticket.getSubYN().isEmpty()) {
            return false;
        }
        if (ticket.getPrice() == 0) {
            return false;
        }
        return true;
    }
}
