package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher1 = new Publisher("Test", "ul. Legnicka 48H");

        publisherRepository.save(publisher1);

        Author author1 = new Author("Fiodor", "Dostojewski");
        Book book1 = new Book("Zbronia i kara", "123456", publisher1);
        author1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Publisher publisher2 = new Publisher("Test", "ul. Legnicka 48A");

        publisherRepository.save(publisher2);

        Author author2 = new Author("Charles", "Duhigg");
        Book book2 = new Book("Siła nawyku", "654321", publisher2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
