package com.caozeal.sometry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,1);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException(){
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO(){
        ticTacToe.lastPlayer = 'X';
        Assert.assertEquals('O',ticTacToe.nextPlayer());
    }

    @Test
    public void whenXPlayThenLastTurnWasX(){
        ticTacToe.play(1,1);
        Assert.assertEquals('X', ticTacToe.lastPlayer);
    }

    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(1,1);
        Assert.assertEquals("No winner", actual);
    }

    @Test
    public void whenXPlayWholeHorizonLineThenXWin(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        String actual = ticTacToe.play(3,1);
        Assert.assertEquals("Winner is X", actual);
    }

    @Test
    public void whenXPlayWholeVerticalLineThenXWin(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        String actual = ticTacToe.play(1,3);
        Assert.assertEquals("Winner is X", actual);
    }

    @Test
    public void whenXPlayDiagonalLineThenWinner(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        ticTacToe.play(1,3);
        String actual = ticTacToe.play(3,3);
        Assert.assertEquals("Winner is X", actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(3,1);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        ticTacToe.play(1,2);
        ticTacToe.play(3,2);
        ticTacToe.play(3,3);
       String actual = ticTacToe.play(1,3);
        Assert.assertEquals("The result is draw", actual);
    }
}
