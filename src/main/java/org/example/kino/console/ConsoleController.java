package org.example.kino.console;


import org.example.kino.application.ReservationPositionService;
import org.example.kino.model.Movies;
import org.example.kino.model.Ticket;
import org.example.kino.model.Client;
import org.example.kino.model.MovieReservation;
import org.example.kino.iterator.Iterator;
import org.example.kino.iterator.Collection;
import org.example.kino.database.CSVReservationDatabase;
import org.example.kino.template.AddRes;
import org.example.kino.template.AddMovieRes;


import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleController {
    Scanner scanner = new Scanner(System.in);
    // renting position service jest fasadą
    ReservationPositionService service = new ReservationPositionService();


    public void Menu() {
        while (true) {
            System.out.println("Wybierz akcję \n");
            System.out.println("1. Dodaj klienta \n2. Dodaj bilet \n3. Dodaj film \n4. Dodaj rezerwację \n5. Wyświetl wszystkie rezerwację");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Wpisz imię \n");
                String name = scanner.next();
                System.out.println("Wpisz nazwisko \n");
                String surname = scanner.next();
                System.out.println("Wpisz adres email \n");
                String email = scanner.next();
                service.addClient(new Client(name, surname, email));
                System.out.println("Klient został dodany");
            }

            if (input == 2) {
                System.out.println("Wpisz nazwę rodzaju biletu \n");
                String type = scanner.next();
                System.out.println("Wpisz rodzaj napisów \n");
                String subYN = scanner.next();
                service.addTicket(new Ticket(type, subYN));
                System.out.println("Bilet został dodany");
            }

            if (input == 3) {
                System.out.println("Wpisz tytuł \n");
                String title = scanner.next();
                System.out.println("Wpisz rok produkcji \n");
                Integer yearOfPro = Integer.parseInt(scanner.next());
                System.out.println("Wpisz ograniczenie wiekowe \n");
                Integer ageOfRes = Integer.parseInt(scanner.next());
                System.out.println("Wpisz studio \n");
                String studio = scanner.next();
                service.addMovie(new Movies(title, yearOfPro, ageOfRes, studio));


            }

            if (input == 4) {
                addMovieRes = new AddMovieRes(CSVReservationDatabase.getInstance("reservationPosition.csv"));
                System.out.println("Wpisz id filmu \n");
                int movieId = Integer.parseInt(scanner.next());
                System.out.println("Wpisz datę rezerwacji \n");
                System.out.println("Wpisz rok \n");
                int rokStart = Integer.parseInt(scanner.next());
                System.out.println("Wpisz miesiac \n");
                int miesiacStart = Integer.parseInt(scanner.next());
                System.out.println("Wpisz dzien \n");
                int dzienStart = Integer.parseInt(scanner.next());
                LocalDateTime startScreening = LocalDateTime.of(rokStart, miesiacStart, dzienStart, 0, 0);
                System.out.println("Wpisz id klienta \n");
                int clientId = Integer.parseInt(scanner.next());
                System.out.println("Wpisz ilosc biletow \n");
                int ticketAmount = Integer.parseInt(scanner.next());
                addMovieRes.addRes(new MovieReservation(movieId, startScreening, clientId, ticketAmount));
                System.out.println("Pomyślnie dodano rezerwacje");
            }
            if (input == 5) {
                Collection<MovieReservation> collection = service.showAllReservationPositions();
                Iterator<MovieReservation> iterator = collection.createIterator();
                System.out.println(iterator.getCurrent());
                while (iterator.hasNext()) {
                    System.out.println(iterator.getNext());
                }


            }
        }
    }
}