package com.example.geektestfinal.repositories;
import java.util.List;
import com.example.geektestfinal.models.Author;
import com.example.geektestfinal.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


//    Find Books By Author





}
