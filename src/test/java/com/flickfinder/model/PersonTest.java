package com.flickfinder.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for the Person Model.
 * 
 */
public class PersonTest {

    private Person person;
    @BeforeEach
    public void setUp() {
        person = new Person(1, "Tom Smith", 1985);
    }

    @Test
    public void testPersonCreated() {
        assertEquals(1, person.getId());
        assertEquals("Tom Smith", person.getName());
        assertEquals(1985, person.getBirth());
    }

    @Test
    public void testPersonSetters() {
        person.setId(2);
        person.setName("Jane Smith");
        person.setBirth(1990);
        assertEquals(2, person.getId());
        assertEquals("Jane Smith", person.getName());
        assertEquals(1990, person.getBirth());
    }
}
