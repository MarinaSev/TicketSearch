package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

}
