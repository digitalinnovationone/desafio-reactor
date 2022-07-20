package br.com.dio.desafioreactor;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question2Test {

    private Question2 question2;
    private final Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeEach
    void setup(){
        question2 = new Question2();
    }

    private List<User> generateUsers(final Long limit, final Boolean isAdmin){
        var idGen = new AtomicLong(1L);
        return Stream.generate(() ->
                new User(idGen.getAndIncrement(), faker.name().name(), faker.internet().emailAddress(),
                        faker.lorem().word(), isAdmin))
                .limit(limit)
                .toList();
    }

    @Test
    void hasNoAdmin(){
        StepVerifier.create(question2.countAdmins(generateUsers((long) faker.number().randomDigitNotZero(), false)))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(actual -> true)
                .consumeRecordedWith(actual -> assertEquals(actual.size(), 0));
    }

    @Test
    void hasXAdmins(){
        var noAdminUsers = generateUsers((long) faker.number().randomDigitNotZero(), false);
        var adminUsers = generateUsers((long) faker.number().randomDigitNotZero(), true);

        StepVerifier.create(question2.countAdmins(Stream.concat(noAdminUsers.stream(), adminUsers.stream()).toList()))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(actual -> true)
                .consumeRecordedWith(actual -> assertEquals(actual.size(), adminUsers.size()));
    }

    @AfterEach
    void teardown(){
        question2 = null;
    }

}
