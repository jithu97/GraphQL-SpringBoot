package com.jithuLearnings.GraphQL.Demo.service;

import com.jithuLearnings.GraphQL.Demo.model.Actor;
import com.jithuLearnings.GraphQL.Demo.model.Language;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ActorServiceImpl implements ActorService {

    private List<Actor> actors = new ArrayList<>();

    AtomicInteger id = new AtomicInteger();

    @Override
    public Optional<Actor> findOne( int id){
        return actors.stream().filter(x -> x.id() == id).findFirst();
    }
    @Override
    public List<Actor> findAll(){
        return actors;
    }

    @Override
    public Actor create(String name, Language language){
        Actor actor = new Actor(name,id.incrementAndGet(),language);
        actors.add(actor);
        return actor;
    }

    @Override
    public Actor delete(Integer id) {
        Actor actor = actors.stream().filter( x -> Objects.equals(x.id(), id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Not found"));
        actors.remove(actor);
        return actor;
    }

    @Override
    public Actor update(String name, Integer id, Language language) {
        Actor upadtedActor = new Actor(name,id,language);
        Optional<Actor> optional = actors.stream().filter(x -> Objects.equals(x.id(), id)).findFirst();

        if (optional.isPresent()){
            Actor actor = optional.get();
            int index = actors.indexOf(actor);
            actors.set(index,upadtedActor);
        } else {
            throw new IllegalArgumentException("Invalid Actor");
        }
        return null;
    }

    @PostConstruct
    public void init(){
        actors.add(new Actor("Chiranjeevi", id.incrementAndGet(),Language.Telugu));
        actors.add(new Actor("Rajinikanth", id.incrementAndGet(),Language.Tamil));
        actors.add(new Actor("MohanLal", id.incrementAndGet(),Language.Malayalam));
        actors.add(new Actor("Yash", id.incrementAndGet(),Language.Kannada));
    }
}
