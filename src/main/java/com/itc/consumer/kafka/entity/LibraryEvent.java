package com.itc.consumer.kafka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryEvent {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "library_event_id")
	private Integer libraryEventId;

	@Enumerated(EnumType.STRING)
	private LibraryEventType libraryEventType;

	/*
	 * @OneToOne(mappedBy = "libraryEvent", cascade = { CascadeType.ALL })
	 * 
	 * @ToString.Exclude
	 */
	
	
	@OneToOne
	@JoinColumn(name = "book_id")
	@ToString.Exclude
	private Book book;

}
