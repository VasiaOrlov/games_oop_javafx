package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        Cell start = Cell.findBy(0, 0);
        BishopBlack first = new BishopBlack(start);
        Cell expect = first.position();
        assertThat(expect, is(start));
    }

    @Test
    public void testCopy() {
        Cell start = Cell.findBy(0, 0);
        Cell finish = Cell.findBy(2, 2);
        BishopBlack first = new BishopBlack(start);
        Figure second = first.copy(finish);
        Cell expect = second.position();
        assertThat(expect, is(finish));
    }

    @Test
    public void testWay() {
        Cell start = Cell.findBy(2, 0);
        Cell finish = Cell.findBy(6, 4);
        BishopBlack test = new BishopBlack(start);
        Cell[] result = test.way(finish);
        Cell[] expect = {Cell.findBy(3, 1), Cell.findBy(4, 2), Cell.findBy(5, 3), Cell.findBy(6, 4)};
        assertThat(expect, is(result));
    }

    @Test
    public void testWay1() {
        Cell start = Cell.findBy(3, 3);
        Cell finish = Cell.findBy(5, 1);
        BishopBlack test = new BishopBlack(start);
        Cell[] result = test.way(finish);
        Cell[] expect = {Cell.findBy(4, 2), Cell.findBy(5, 1)};
        assertThat(expect, is(result));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testWayException() {
        Cell start = Cell.findBy(2, 0);
        Cell finish = Cell.findBy(6, 5);
        BishopBlack test = new BishopBlack(start);
        Cell[] result = test.way(finish);
    }
}