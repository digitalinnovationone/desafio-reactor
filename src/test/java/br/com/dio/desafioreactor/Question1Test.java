package br.com.dio.desafioreactor;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question1Test {

    private Question1 question1;
    private final Faker faker = new Faker(new Locale("pt", "BR"));

    @BeforeEach
    void setup(){
        question1 = new Question1();
    }

    @Test
    void incTest(){
        var numbers = Stream.generate(() -> faker.number().randomNumber())
                .limit(faker.number().randomDigitNotZero())
                .toList();
        StepVerifier.create(question1.inc(numbers))
                .recordWith(ArrayList::new)
                .thenConsumeWhile(actual -> true)
                .consumeRecordedWith(actual ->{
                    var actualList = new ArrayList<>(actual);
                    IntStream.range(0, actual.size())
                            .forEach(i -> assertEquals(actualList.get(i), numbers.get(i) + 1L));
                })
                .verifyComplete();
    }

    @AfterEach
    void tearDown(){
        question1 = null;
    }

}
