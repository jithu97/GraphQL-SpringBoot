package com.jithuLearnings.GraphQL.Demo.controller;

import com.jithuLearnings.GraphQL.Demo.model.Actor;
import com.jithuLearnings.GraphQL.Demo.model.Language;
import com.jithuLearnings.GraphQL.Demo.service.ActorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @QueryMapping
    public List<Actor> findAll(){
        return actorService.findAll();
    }

    @QueryMapping
    public Optional<Actor> findOne( @Argument Integer id){
        return actorService.findOne(id);
    }

    @MutationMapping
    public Actor create(@Argument String name, @Argument Language language){
        return actorService.create(name,language);
    }

    @MutationMapping
    public Actor update(@Argument String name, @Argument Language language, @Argument Integer id){
        return actorService.update(name,id, language);
    }

    @MutationMapping
    public  Actor delete(@Argument Integer id){
        return actorService.delete(id);
    }
}
