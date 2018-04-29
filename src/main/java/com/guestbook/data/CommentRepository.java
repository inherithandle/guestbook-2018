package com.guestbook.data;

import com.guestbook.model.Comment;

import java.util.List;

/**
 * Created by hello on 22/04/2018.
 */
public interface CommentRepository {

    Comment findOne(int commentId);

    List<Comment> findComments(long max, int count);

    int insertComment(Comment comment);
}
