package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    private int id;
    private int price;
    private String from;
    private String to;
    private int duration;

    public class TicketPriceComparator implements Comparator<Ticket> {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getPrice() - o2.getPrice();
        }
    }

    public class TicketDurationComparator implements Comparator<Ticket> {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getDuration() - o2.getDuration();
        }
    }
}

