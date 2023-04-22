package com.application.libraryManagement;

import com.application.libraryManagement.entity.Author;
import com.application.libraryManagement.entity.Book;
import com.application.libraryManagement.entity.Category;
import com.application.libraryManagement.entity.Publisher;
import com.application.libraryManagement.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return(args) -> {
			Book book1 = new Book("ABC", "Random Book", "My first book");
			Author author1 = new Author("Test name", "Test description");
			Category category1 = new Category("Business");
			Publisher publisher1 = new Publisher("Test Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

		};
	}

}
