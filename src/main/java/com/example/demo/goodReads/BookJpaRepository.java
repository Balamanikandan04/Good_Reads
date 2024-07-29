package com.example.demo.goodReads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookJpaRepository extends JpaRepository<Book,Integer> {

    
}
