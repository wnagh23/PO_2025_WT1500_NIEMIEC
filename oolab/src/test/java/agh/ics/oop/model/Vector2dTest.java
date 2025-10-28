package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void vectorsEquals() {
        Vector2d v1 = new Vector2d(7, 6);
        Vector2d v2 = new Vector2d(7, 6);

        assertEquals(v1, v2);
    }

    @Test
    void toStringEquals() {
        Vector2d v1 = new Vector2d(21, 37);

        assertEquals("(21,37)", v1.toString());
    }

    @Test
    void precedesEquals() {
        Vector2d v1 = new Vector2d(20, 36);
        Vector2d v2 = new Vector2d(21, 37);

        assertTrue(v1.precedes(v2));
    }

    @Test
    void followsEquals() {
        Vector2d v1 = new Vector2d(20, 36);
        Vector2d v2 = new Vector2d(21, 37);

        assertTrue(v2.follows(v1));
    }

    @Test
    void upperRightEquals() {
        Vector2d v1 = new Vector2d(20, 37);
        Vector2d v2 = new Vector2d(21, 36);

        assertEquals(new Vector2d(21, 37), v1.upperRight(v2));
    }

    @Test
    void lowerLeftEquals() {
        Vector2d v1 = new Vector2d(20, 37);
        Vector2d v2 = new Vector2d(21, 36);

        assertEquals(new Vector2d(20, 36), v1.lowerLeft(v2));
    }

    @Test
    void addEquals(){
        Vector2d v1 = new Vector2d(20, 36);
        Vector2d v2 = new Vector2d(21, 37);

        assertEquals(new Vector2d(41, 73), v1.add(v2));
    }

    @Test
    void subEquals(){
        Vector2d v1 = new Vector2d(20, 36);
        Vector2d v2 = new Vector2d(21, 37);

        assertEquals(new Vector2d(-1, -1), v1.sub(v2));
    }

    @Test
    void oppositeEquals(){
        Vector2d v1 = new Vector2d(21, 37);

        assertEquals(new Vector2d(-21, -37), v1.opposite());
    }

}