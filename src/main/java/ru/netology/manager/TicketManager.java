package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public TicketManager() {
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] getAll(String from, String to) {
        Ticket[] tickets = repo.findAll();

        Ticket[] tmp = new Ticket[tickets.length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                tmp[index] = ticket;
                index++;
            }
        }

        Ticket[] result = new Ticket[index];
        System.arraycopy(tmp, 0, result, 0, index);
        Arrays.sort(result);
        return result;
    }

}
