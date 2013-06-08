package it;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hascode.tutorial.ejb.BookEJB;
import com.hascode.tutorial.entity.Book;

@RunWith(Arquillian.class)
public class BookEJBIT {
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(BookEJB.class, Book.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	BookEJB bookEJB;

	@Test
	public void shouldCreateASingleBook() throws Exception {
		Book book = new Book();
		book.setTitle("First book");
		bookEJB.save(book);
		assertThat(book.getId(), notNullValue());

		List<Book> books = bookEJB.findAll();
		assertThat(books.size(), equalTo(1));
		assertThat(books.get(0).getTitle(), equalTo("First book"));
	}

	@Test
	public void shouldReturnMultipleBooks() throws Exception {
		Book book1 = new Book();
		book1.setTitle("Some Book");

		Book book2 = new Book();
		book2.setTitle("Another book");

		bookEJB.save(book1);
		bookEJB.save(book2);

		List<Book> books = bookEJB.findAll();
		/**
		 * three because the test 'shouldCreateASingleBook' already created one
		 * book
		 */
		assertThat(books.size(), equalTo(3));
	}
}
