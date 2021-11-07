package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketManager manager = new TicketManager(new TicketRepository());

    private Ticket first = new Ticket(12, 80_000, "SVO", "HND", 570);
    private Ticket second = new Ticket(16, 56_000, "SVO", "HND", 570);
    private Ticket third = new Ticket(28, 300_000, "SVO", "HND", 570);
    private Ticket forth = new Ticket(333, 6_000, "SVO", "AER", 150);
    private Ticket fifth = new Ticket(366, 10_000, "VKO", "AER", 150);
    private Ticket sixth = new Ticket(666, 3_500, "SVO", "LED", 90);
    private Ticket seventh = new Ticket(696, 8_600, "DME", "LED", 90);

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    public void shouldFindTicketsIfFew() {

        Ticket[] expected = {second, first, third};
        Ticket[] actual = (Ticket[]) manager.getAll("SVO", "HND");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketIfOne(){

        Ticket[] expected = {};
        Ticket[] actual = (Ticket[]) manager.getAll("DME", "HND");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketIfNoone(){

        Ticket[] expected = {seventh};
        Ticket[] actual = (Ticket[]) manager.getAll("DME", "LED");

        assertArrayEquals(expected, actual);

    }

}