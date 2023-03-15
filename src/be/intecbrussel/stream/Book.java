package be.intecbrussel.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Book {

    String title;
    Person author;

    LocalDate releaseDate;

    String genre;

    Long count;

    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static Book getNewestBook(Book [] books) {

        books = Stream.of(books)
                .sorted(Comparator.comparing(Book::getReleaseDate)).toArray(Book[]::new);

        System.out.println(books[books.length - 1]);

        //OF Book recBook = Stream.of(books)
                //.max(Comparator.comparing(book -> book.getReleaseDate())).get();
        //return recBook;

        //OF Book [] sortedBooks = Stream.of (books)
        // .sorted(Comparator.comparing(Book::getReleaseDate).reversed ())
        //  .toArray(Book [] :: new);
        // return sortedBooks [0];


        return null;
    }

    public static void printyoungestWriter(Book[] books) {

        books = Stream.of(books)
                .sorted(Comparator.comparing(x -> x.getAuthor().getDateOfBirth()))
                .map(Book::getAuthor)
                .toArray(Book[]::new);

        System.out.println(books[books.length - 1]);

        // OF System.out.println(Stream.of(books).max(Comparator.comparing(book -> book.getAuthor().getDateOfBirth())).get().getAuthor());
       // OF System.out.println(Stream.of(books)
            //    .map(Book::getAuthor)
             //   .max(Comparator.comparing(Person::getDateOfBirth)).get());
    }

    public static void printSortedByTitle (Book [] books){
        Stream.of(books)
                .sorted(Comparator.comparing(x -> x.getTitle().toLowerCase()))
                .forEach(System.out::println);

    }

    public static void printBooks2016 (Book [] books) {
        //Stream.of(books)
               // .filter(book -> book.getReleaseDate().getYear() == 2016)
               // .forEach(System.out::println);
        //OF .forEach(x -> System.out.print(x.getReleaseDate().getYear() == 2016 ? x + "\n" : ""));

        if (Stream.of(books)
                .filter(book -> book.getReleaseDate().getYear() == 2016)
                .peek(System.out::println)
                .count() == 0
        ) {
            System.out.println("No book released");
        }

    }

    public static void countBooksPerAuthor (Book [] books) {

        Map<Person, Long> aantBooks =
                Arrays.stream(books)
                        .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
        aantBooks.forEach((author, count) -> System.out.println(author.getFirstName() +" "+ author.getLastName() + ": " + count));

        };



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                '}';
    }
}
