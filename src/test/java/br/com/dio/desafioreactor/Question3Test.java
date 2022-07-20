package br.com.dio.desafioreactor;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Locale;

public class Question3Test {

    private Question3 question3;
    private final Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeEach
    void setup(){
        question3 = new Question3();
    }

    @Test
    void invalidUser(){
        StepVerifier.create(question3.userIsValid(new User(1L, faker.name().name(), faker.internet().emailAddress(),
                        faker.lorem().characters(0, 8), faker.bool().bool())))
                .verifyError();
    }

    @Test
    void validUser(){
        StepVerifier.create(question3.userIsValid(new User(1L, faker.name().name(), faker.internet().emailAddress(),
                        faker.lorem().characters(8, 255), faker.bool().bool())))
                .verifyComplete();
    }

    @AfterEach
    void teardown(){
        question3 = null;
    }

}
