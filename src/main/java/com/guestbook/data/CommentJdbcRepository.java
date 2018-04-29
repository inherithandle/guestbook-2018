package com.guestbook.data;

import com.guestbook.model.Comment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by hello on 27/04/2018.
 */
@Repository
public class CommentJdbcRepository implements CommentRepository {

    private final String INSERT_COMMENT = "INSERT INTO comment (username, text, insert_date) values (?, ?, ?)";
    private final String SELECT_COMMENT_BY_ID = "SELECT username, text, insert_date FROM comment where comment_id = ?";
    private final String SELECT_COMMENT = "SELECT username, text, insert_date FROM comment LIMIT ?";
    private final RowMapper<Comment> commentRowMapper = (rs, rowNum) -> {
        Comment c = new Comment();
        c.setText(rs.getString("text"));
        c.setInsertDate(rs.getDate("insert_date").toLocalDate());
        c.setUsername(rs.getString("username"));
        return c;
    };

    private JdbcOperations jdbcOperations;

    @Inject
    public CommentJdbcRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Comment findOne(int commentId) {
        Comment comment = jdbcOperations.queryForObject(SELECT_COMMENT_BY_ID, commentRowMapper, commentId);
        return comment;
    }

    @Override
    public List<Comment> findComments(long max, int count) {
        List<Comment> comments = jdbcOperations.query(SELECT_COMMENT, commentRowMapper, max);
        return comments;
    }

    @Override
    public int insertComment(Comment comment) {
        return jdbcOperations.update(INSERT_COMMENT,
                                comment.getUsername(),
                                comment.getText(),
                                comment.getInsertDate());

    }
}
