package be.intecbrussel.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class BookApp {
    public static void main(String[] args) {

        LocalDate dateOfB1 = LocalDate.of(1994, 7, 28);
        LocalDate dateOfR1 = LocalDate.of(2016, 2, 8);

        LocalDate dateOfB2 = LocalDate.of(1993, 5, 21);
        LocalDate dateOfR2 = LocalDate.of(2008, 10, 10);

        LocalDate dateOfB3 = LocalDate.of(1992, 9, 12);
        LocalDate dateOfR3 = LocalDate.of(2010, 4, 10);

        LocalDate dateOfB4 = LocalDate.of(1986, 7, 30);
        LocalDate dateOfR4 = LocalDate.of(2008, 7, 29);

        LocalDate dateOfB5 = LocalDate.of(1989, 6, 30);
        LocalDate dateOfR5 = LocalDate.of(2016, 2, 10);

        Person person1 = new Person("Rhiannon", "Frater", dateOfB1);
        Person person2 = new Person("Mira", "Grant", dateOfB2);
        Person person3 = new Person("Yann", "Martel", dateOfB3);
        Person person4 = new Person("Mary Ann", "Shaffer", dateOfB4);
        Person person5 = new Person("Kathryn", "Stockett", dateOfB5);

        Book[] books = {
                new Book("The First Days", person1, dateOfR1, "Horror"),
                new Book("Feed", person2, dateOfR2, "Post Apocalyptic"),
                new Book("Life of Pi", person3, dateOfR3, "Novels"),
                new Book("The Guernsey Literary and Potato Peel Pie Society", person4, dateOfR4, "Historical Fiction"),
                new Book("The Help", person5, dateOfR5, "Classics")};

        //Deze geeft het nieuwste boek terug uit een array van boeken.
        System.out.println("***Deze geeft het nieuwste boek terug uit een array van boeken.***\n");

        Book.getNewestBook(books);
        System.out.println("\n\n");


        //deze method print de jongste schrijver af.
        System.out.println("***Deze method print de jongste schrijver af.***\n");

        Book.printyoungestWriter(books);
        System.out.println("\n\n");

        //deze methode print het aantal boeken af per auteur.
        System.out.println("***Deze methode print het aantal boeken af per auteur.***\n");

        Book.countBooksPerAuthor(books);
        System.out.println("\n\n");

        //De boeken af die gereleaset zijn in 2016.
        System.out.println("***De boeken af die gereleaset zijn in 2016.***\n");

        Book.printBooks2016(books);
        System.out.println("\n\n");

        //Sorted By Title
        System.out.println("***Sorted By Title***\n");

        Book.printSortedByTitle(books);
        System.out.println("\n\n");




    }
}








