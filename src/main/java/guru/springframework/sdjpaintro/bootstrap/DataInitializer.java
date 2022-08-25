package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book bookDDD = new Book("Domain Driven Design", "123", "Random");

        System.out.println("Id:" + bookDDD.getId());

        Book savedBookDDD = bookRepository.save(bookDDD);

        System.out.println("Id:" + savedBookDDD.getId());

        Book bookSIA = new Book("Spring in Action", "1234566", "Orealy");
        Book savedBookSIA = bookRepository.save(bookSIA);


        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id:" + book.getId());
            System.out.println("Book Title:" + book.getTitle());
        });

    }
}
