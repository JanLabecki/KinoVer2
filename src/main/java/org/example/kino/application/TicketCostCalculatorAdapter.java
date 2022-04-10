package org.example.kino.application;

public class TicketCostCalculatorAdapter implements TicketCostCalculator {

    TicketCostCalculatorUSD ticketCostCalculatorUSD= new TicketCostCalculatorUSD();

    public double calculateTicketCost(int amount) {
        return ticketCostCalculatorUSD.calculateCostUSD(amount) * 4.22;
    }
}
