package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest){
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = 0;
        if ((dest.getX() - position.getX()) < 0) {
            deltaX = -1;
        } else if ((dest.getX() - position.getX()) > 0) {
            deltaX = 1;
        }
        int deltaY = 0;
        if ((dest.getY() - position.getY()) < 0) {
            deltaY = -1;
        } else if ((dest.getY() - position.getY()) > 0) {
            deltaY = 1;
        }
        for (int index = 0; index < size; index++) {
            int x = position.getX() + deltaX * (index + Math.abs(deltaX));
            int y = position.getY() + deltaY * (index + Math.abs(deltaY));
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}