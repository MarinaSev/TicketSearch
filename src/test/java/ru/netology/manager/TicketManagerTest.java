package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketManager manager = new TicketManager(new TicketRepository());

    private Ticket first = new Ticket(12, 56_000, "SVO", "HND", 570);
    private Ticket second = new Ticket(16, 56_000, "SVO", "HND", 580);
    private Ticket third = new Ticket(28, 56_000, "SVO", "HND", 550);
    private Ticket forth = new Ticket(333, 6_000, "VKO", "AER", 150);
    private Ticket fifth = new Ticket(366, 10_000, "SVO", "AER", 150);
    private Ticket sixth = new Ticket(666, 3_500, "SVO", "LED", 90);
    private Ticket seventh = new Ticket(696, 8_600, "DME", "LED", 85);
    private Ticket eighth = new Ticket(363, 6000, "VKO", "AER", 140);
    private Ticket ninth = new Ticket(348, 8000, "VKO", "AER", 130);

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    public void shouldFindTicketsIfFew() {

        Ticket[] expected = {third, first, second};
        Ticket[] actual = manager.getAll("SVO", "HND", Comparator.comparing(Ticket::getPrice)
                                                                    .thenComparing(Ticket::getDuration));

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsIfFewByPrice() {

        Ticket[] expected = {forth, eighth, ninth};
        Ticket[] actual = manager.getAll("VKO", "AER", Comparator.comparing(Ticket::getPrice));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsIfFewVKO() {

        Ticket[] expected = {eighth, forth, ninth};
        Ticket[] actual = manager.getAll("VKO", "AER", Comparator.comparing(Ticket::getPrice)
                                                                    .thenComparing(Ticket::getDuration));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsIfFewByDuration() {

        Ticket[] expected = {ninth, eighth, forth};
        Ticket[] actual = manager.getAll("VKO", "AER", Comparator.comparing(Ticket::getDuration)
                .thenComparing(Ticket::getDuration));

        assertArrayEquals(expected, actual);
    }

    @Disabled
    @Test
    public void shouldFindTicketIfOne(){

        Ticket[] expected = {};
        Ticket[] actual = (Ticket[]) manager.getAll("DME", "HND", Comparator.comparing(Ticket::getPrice)
                .thenComparing(Ticket::getDuration));

        assertArrayEquals(expected, actual);

    }

    @Disabled
    @Test
    public void shouldFindTicketIfNoone(){

        Ticket[] expected = {seventh};
        Ticket[] actual = (Ticket[]) manager.getAll("DME", "LED",Comparator.comparing(Ticket::getPrice)
                .thenComparing(Ticket::getDuration));

        assertArrayEquals(expected, actual);

    }

}