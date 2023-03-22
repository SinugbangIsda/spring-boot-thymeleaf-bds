package com.sinugbangisda.bookhive.repository;

import com.sinugbangisda.bookhive.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
