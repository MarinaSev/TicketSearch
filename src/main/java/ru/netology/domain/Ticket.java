package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int duration;

    @Override
    public int compareTo(Ticket o) {
        Ticket ticket = (Ticket) o;
        int tmp = this.price - ticket.price;
        if (tmp == 0) {
            return 0;
        } else if (tmp < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
