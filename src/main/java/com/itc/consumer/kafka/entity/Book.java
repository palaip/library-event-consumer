package com.itc.consumer.kafka.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Setter
@Getter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	private String bookName;

	private String bookAuthor;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "library_event_id")
	 */
	
	@OneToOne(mappedBy = "book", cascade = { CascadeType.ALL })
	@ToString.Exclude
	
	private LibraryEvent libraryEvent;

}
