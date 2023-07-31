package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BishopBlackTest {

    @Test
    void whenPositionC1() {
        Cell expected = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Cell actual = bishopBlack.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void wayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void wayC3G5ThrowsImpossibleMoveException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        assertThatExceptionOfType(ImpossibleMoveException.class)
                .isThrownBy(() -> bishopBlack.way(Cell.G5));
    }

    @Test
    void copyC1G5() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C1);
        Cell second = Cell.G5;
        BishopBlack bishopBlack2 = (BishopBlack) bishopBlack1.copy(second);
        assertThat(bishopBlack2.position()).isEqualTo(second);
    }

    @Test
    void isDiagonalC1G5True() {
        Cell first = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(first);
        Cell second = Cell.G5;
        assertThat(bishopBlack.isDiagonal(first, second)).isTrue();
    }

    @Test
    void isDiagonalC1G6False() {
        Cell first = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(first);
        Cell second = Cell.G6;
        assertThat(bishopBlack.isDiagonal(first, second)).isFalse();
    }
}