package com.hascode.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(final String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
}
