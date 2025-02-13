package com.example.demo.goodReads;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BookRowMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      
        return new Book(
            rs.getInt("BookId"),
            rs.getString("BookName"),
            rs.getString("Bookimgurl")
        );
    }
}
