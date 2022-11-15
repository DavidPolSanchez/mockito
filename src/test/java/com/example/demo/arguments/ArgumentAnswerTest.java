package com.example.demo.arguments;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentAnswerTest {

    @Mock
    PersonRepository repository;

    // sut
    @InjectMocks
    PersonServiceImpl service;

    @Test
    void test1() {

        /*
            thenReturn siempre devolverá el mismo objeto person en este caso sin tener en cuenta la entrada
         */

        Person person = new Person(null, "person1", LocalDate.now());

        when(repository.save(any(Person.class))).thenReturn(person);


        Person personDB = service.save(person);

        assertNotNull(personDB);
        assertEquals("person1", personDB.getName());

    }

    @Test
    void test2() {

        /*
            thenAnswer devolverá un objeto Person customizado en base a la entrada
            Nos permite simular el comportamiento real que tendría una base de datos
            por ejemplo al devolver un Person que tiene asignada una clave primaria autogenerada
         */


        when(repository.save(any(Person.class))).thenAnswer(invocation -> { // any: permite distintas entradas

            // extracción de argumentos a partir de la entrada: hay 1 solo argumento, objeto Person
            Object[] args = invocation.getArguments();
            Person person = (Person) args[0];

            // cargar datos deseados en el objeto Person dinámicamente
            LocalDate defaultBirth = LocalDate.of(1970, 1,1);
            String name = StringUtils.isNotBlank(person.getName()) ? person.getName() : "default";
            LocalDate birth = person.getBirthday() != null ? person.getBirthday() : defaultBirth;

            return new Person(UUID.randomUUID(), name, birth);
        });

        Person person1 = new Person(null, null, null);
        Person personDB = service.save(person1); // ENTRADA PERSON1
        assertNotNull(personDB);
        assertEquals("default", personDB.getName());

        Person person2 = new Person(null, "chanclete", null);
        Person personDB2 = service.save(person2); // ENTRADA PERSON2
        assertNotNull(personDB2);
        assertEquals("chanclete", personDB2.getName());

    }
}
