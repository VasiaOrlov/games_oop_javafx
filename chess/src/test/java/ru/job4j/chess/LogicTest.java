package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void findByTest() throws FigureNotFoundException{
        Logic logic = new Logic();
        Cell start = Cell.findBy(0, 0);
        BishopBlack first = new BishopBlack(start);
        logic.add(first);
        int result = logic.findBy(start);
        assertThat(0, is(result));
    }

    @Test (expected = FigureNotFoundException.class)
    public void findByTest2() throws FigureNotFoundException{
        Logic logic = new Logic();
        Cell start = Cell.findBy(0, 0);
        Cell found = Cell.findBy(1, 0);
        BishopBlack first = new BishopBlack(start);
        logic.add(first);
        int result = logic.findBy(found);
    }

    @Test
    public void freeTest() throws OccupiedCellException{
        Logic logic = new Logic();
        Cell[] steps = {Cell.findBy(1, 1), Cell.findBy(2, 2)};
        boolean result = logic.free(steps);
        assertThat(true, is(result));
    }
    @Test (expected = OccupiedCellException.class)
    public void freeTest2() throws OccupiedCellException{
        Logic logic = new Logic();
        Cell[] steps = {Cell.findBy(1, 1), Cell.findBy(2, 2)};
        BishopBlack first = new BishopBlack(Cell.findBy(1, 1));
        logic.add(first);
        boolean result = logic.free(steps);
    }

}