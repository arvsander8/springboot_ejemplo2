package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.book.Book;
import com.example.demo.book.BookRepository;

@RunWith(SpringRunner.class)
public class BooksTest {

	Logger logger = LoggerFactory.getLogger("Nuevo");
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
	
	public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }
	
	
	@Test(timeout = 60000)
	public void testCacheBook() {
		logger.info(".... Iniciando books");
		getByIsbn("12-001");
		logger.info(".... caching 1");
		getByIsbn("12-001");
		logger.info(".... caching 2");
		getByIsbn("12-001");
		logger.info(".... caching 3");
		getByIsbn("12-001");
		logger.info(".... Finalizando books");
		
	}

}
