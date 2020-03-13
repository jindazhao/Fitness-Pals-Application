package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorgiTest {

    Corgi corgi;

    @BeforeEach
    void runBefore() {
        corgi = new Corgi();

    }

    @Test
    void testConstructor() {
        assertEquals(5, corgi.getHappiness());
        assertEquals(true, corgi.getHappy());
        assertEquals(false, corgi.getDead());
        assertEquals(false, corgi.getSad());


    }

    @Test
    void testOtherMethods() {
        corgi.setHappiness(0);
        assertEquals(0, corgi.getHappiness());
        assertEquals(false, corgi.getHappy());
        assertEquals(true, corgi.getDead());
        assertEquals(false, corgi.getSad());
        corgi.setHappiness(4);
        assertEquals(4, corgi.getHappiness());
        assertEquals(false, corgi.getHappy());
        assertEquals(false, corgi.getDead());
        assertEquals(true, corgi.getSad());
        corgi.setHappiness(10);
        assertEquals(10, corgi.getHappiness());
        assertEquals(true, corgi.getHappy());
        assertEquals(false, corgi.getDead());
        assertEquals(false, corgi.getSad());
    }
}
