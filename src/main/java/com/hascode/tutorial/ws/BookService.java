package com.hascode.tutorial.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hascode.tutorial.ejb.BookEJB;
import com.hascode.tutorial.entity.Book;

@Path("/book")
@Stateless
public class BookService {
	@EJB
	private BookEJB bookEJB;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBook(final Book book) {
		bookEJB.save(book);
		return Response.ok().build();
	}

	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllBooks() {
		GenericEntity<List<Book>> books = new GenericEntity<List<Book>>(
				bookEJB.findAll()) {
		};
		return Response.ok(books).build();
	}
}
