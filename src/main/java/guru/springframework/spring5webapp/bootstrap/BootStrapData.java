package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        System.out.println("Starting in a BootStrap");
        System.out.println("Number of books: "+bookRepository.count());




    }
}
