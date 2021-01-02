package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting in a BootStrap");

        Author author1 = new Author("Eric","Evans");
        Book book1 = new Book("Domain Driven Design", "12245241");
        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "52421241");
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);

        Publisher publisher1 = new Publisher("USA Publisher1", "Wall street", "NYC", "US", "12544");
        Publisher publisher2 = new Publisher("WallStreet Journal", "Wall street", "NYC", "US", "221");
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());




    }
}
