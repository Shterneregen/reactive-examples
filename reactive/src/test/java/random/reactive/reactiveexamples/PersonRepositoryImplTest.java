package random.reactive.reactiveexamples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import random.reactive.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonRepositoryImplTest {

    private PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void getByIdBlock() {
        int personId = 1;
        Mono<Person> personMono = personRepository.getById(personId);

        Person person = personMono.block();

        System.out.println(person);
        assertEquals(personId, person.getId());
    }

    @Test
    void getByIdSubscribe() {
        int personId = 2;
        Mono<Person> personMono = personRepository.getById(personId);

        StepVerifier.create(personMono).expectNextCount(1).verifyComplete();

        personMono.subscribe(person -> {
            System.out.println(person);
            assertEquals(personId, person.getId());
        });
        // personMono.subscribe(System.out::println);
    }

    @Test
    void getByIdNotFound() {
        int personId = 8;
        Mono<Person> personMono = personRepository.getById(personId);

        StepVerifier.create(personMono).verifyComplete();
        // StepVerifier.create(personMono).expectNextCount(0).verifyComplete(); // The same

        personMono.subscribe(person -> {
            System.out.println(person);
            assertEquals(personId, person.getId());
        });
        // personMono.subscribe(System.out::println);
    }

    @Test
    void getByIdMapFunction() {
        int personId = 3;
        Mono<Person> personMono = personRepository.getById(personId);

        personMono.map(person -> {
            assertEquals(personId, person.getId());
            return person.getFirstName();
        }).subscribe(firstName -> {
            System.out.println(firstName);
        });
        // personMono.map(Person::getFirstName).subscribe(System.out::println);
    }

    @Test
    void testFluxBlockFirst() {
        Flux<Person> personFlux = personRepository.findAll();

        Person person = personFlux.blockFirst();

        System.out.println(person);
    }

    @Test
    void testFluxSubscribe() {
        Flux<Person> personFlux = personRepository.findAll();

        StepVerifier.create(personFlux).expectNextCount(4).verifyComplete();

        personFlux.subscribe(person -> {
            System.out.println(person);
        });
        // personRepository.findAll().subscribe(System.out::println);
    }

    @Test
    void testFluxToListMono() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<List<Person>> personListMono = personFlux.collectList();

        personListMono.subscribe(list -> {
            list.forEach(person -> {
                System.out.println(person);
            });
        });
        // personRepository.findAll().collectList().subscribe(list -> list.forEach(System.out::println));
    }

    @Test
    void testFindPersonById() {
        Flux<Person> personFlux = personRepository.findAll();

        final Integer id = 3;
        Mono<Person> personMono = personFlux.filter(person -> person.getId() == id).next();
        personMono.subscribe(System.out::println);
    }

    @Test
    void testFindPersonByIdNotFound() {
        Flux<Person> personFlux = personRepository.findAll();

        final Integer id = 8;
        Mono<Person> personMono = personFlux.filter(person -> person.getId() == id).next();
        personMono.subscribe(System.out::println);
    }

    @Test()
    void testFindPersonByIdWithException() {
        Flux<Person> personFlux = personRepository.findAll();

        final Integer id = 8;
        Mono<Person> personMono = personFlux.filter(person -> person.getId() == id).single();
        personMono
                .doOnError(throwable -> System.out.println("I went boom"))
                .onErrorReturn(Person.builder().build())
                .subscribe(System.out::println);
    }
}
