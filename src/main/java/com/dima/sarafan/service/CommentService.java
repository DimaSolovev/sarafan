package com.dima.sarafan.service;

import com.dima.sarafan.domain.Comment;
import com.dima.sarafan.domain.User;
import com.dima.sarafan.domain.Views;
import com.dima.sarafan.dto.EventType;
import com.dima.sarafan.dto.ObjectType;
import com.dima.sarafan.repo.CommentRepo;
import com.dima.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}