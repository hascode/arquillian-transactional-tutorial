package com.hascode.tutorial.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hascode.tutorial.entity.Book;

@Stateless
public class BookEJB {
	@PersistenceContext
	private EntityManager em;

	public void save(final Book book) {
		em.persist(book);
	}

	public List<Book> findAll() {
		return em.createQuery("SELECT b FROM Book b ORDER BY b.title",
				Book.class).getResultList();
	}
}
