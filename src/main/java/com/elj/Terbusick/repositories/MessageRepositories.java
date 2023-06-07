package com.elj.Terbusick.repositories;

import com.elj.Terbusick.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepositories extends CrudRepository<Message, Long> {
    List<Message>findByTag(String tag);
}
