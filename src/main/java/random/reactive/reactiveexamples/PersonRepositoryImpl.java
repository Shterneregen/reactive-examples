package random.reactive.reactiveexamples;

import random.reactive.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    private Person michael = new Person(1, "Michael", "Weston");
    private Person fiona = new Person(2, "Fiona", "Glenanne");
    private Person sam = new Person(3, "Sam", "Axe");
    private Person jesse = new Person(4, "Jesse", "Porter");

    @Override
    public Mono<Person> getById(Integer id) {
        return findAll().filter(person -> person.getId() == id).next();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, sam, jesse);
    }
}
