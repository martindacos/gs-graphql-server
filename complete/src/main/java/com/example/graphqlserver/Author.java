package com.example.graphqlserver;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public record Author (String id, String firstName, String lastName, LocalDate birthDate) {

    private static final List<Author> authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch", LocalDate.of(1948, 12, 20)),
            new Author("author-2", "Douglas", "Adams", LocalDate.of(1953, 12, 2)),
            new Author("author-3", "Bill", "Bryson", LocalDate.of(1956, 12, 12))
    );

    public static Author getById(String id) {
        return authors.stream()
				.filter(author -> author.id().equals(id))
				.findFirst()
				.orElse(null);
    }
}