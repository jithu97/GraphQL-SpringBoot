package com.jithuLearnings.GraphQL.Demo.service;

import com.jithuLearnings.GraphQL.Demo.model.Actor;
import com.jithuLearnings.GraphQL.Demo.model.Language;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    Optional<Actor> findOne(int id);

    List<Actor> findAll();

   Actor create(String name, Language language);

   Actor delete(Integer id);

   Actor update(String name, Integer id, Language language);
}
