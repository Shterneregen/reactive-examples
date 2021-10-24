package random.reactive.reactiveexamples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import random.reactive.reactiveexamples.domain.Person;
import reactor.core.publisher.Mono;

class PersonRepositoryImplTest {

    private PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void getByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);

        Person person = personMono.block();

        System.out.println(person);
    }

    @Test
    void getByIdSubscribe() {
        Mono<Person> personMono = personRepository.getById(1);

        personMono.subscribe(person -> {
            System.out.println(person);
        });
        // personMono.subscribe(System.out::println);
    }

    @Test
    void getByIdMapFunction() {
        Mono<Person> personMono = personRepository.getById(1);

        personMono.map(person -> {
            return person.getFirstName();
        }).subscribe(firstName -> {
            System.out.println(firstName);
        });
        // The same
        personMono.map(Person::getFirstName).subscribe(System.out::println);
    }
}
