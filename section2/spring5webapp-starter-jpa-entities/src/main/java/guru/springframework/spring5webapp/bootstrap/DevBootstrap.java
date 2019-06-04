package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ApplicationContextEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationContextEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
		
		//Eric
		Publisher pb = new Publisher("Harper Colins", "York Street");
		publisherRepository.save(pb);
		
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", pb);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Publisher pb2 = new Publisher("Worx", "Moises Street");
		publisherRepository.save(pb2);
		
		Author rod = new Author("Rod", "Jhonson");
		Book noEJB = new Book("J2EE Development without EJB", "2344", pb2);
		rod.getBooks().add(noEJB);
		noEJB.setPublisher(pb2);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}


}
