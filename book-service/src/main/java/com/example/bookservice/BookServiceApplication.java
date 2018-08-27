package com.example.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/books")
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	private List<Book> bookList = Arrays.asList(
			new Book(1L, "Tim Schimandle", "Baeldung goes to the market"),
			new Book(2L, "Slavisa", "Baeldung goes to the park"));

	@GetMapping("")
	public List<Book> findAllBooks(){
		return bookList;
	}

	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable long bookId){
		return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
	}
}