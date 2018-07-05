package com.caozeal.sometry.connect4;
/**.
 * <p>创建时间：2017年9月17日下午9:14:21
 * <p>com.caozeal.sometry.connect4
 * @author  caozeal
 * @version 1.0
 */
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ChessBoardTest {
	
	private ChessBoard chessBoard;
	
	@Before
	public final void before(){
		chessBoard = new ChessBoard();
	}
	
	@Test
	public void whenInitializeThen7Columns(){
		Assert.assertEquals(chessBoard.getColumn(), 7);
	}
	
	@Test
	public void whenInitializeThen6Rows(){
		Assert.assertEquals(chessBoard.getRows(), 6);
	}
	
	@Test
	public void whenInitializeThenEmpty(){
		Assert.assertEquals(chessBoard.getPieces(), 0);
	}
	
	@Test
	public void givenPiecesInto0CloumnWhenColumnEmptyThenReachBottom(){
		chessBoard.putPiece(1);
		Assert.assertEquals(1, chessBoard.getColumnPieces(1));
	}
	
	@Test
	public void whenInitializeThenRedPlay(){
		Assert.assertEquals(ChessBoard.RED, chessBoard.getNextPlayer());
	}
	
	@Test
	public void whenRedPlayThenNextGreenPlay(){
		chessBoard.putPiece(1);
		Assert.assertEquals(ChessBoard.GREEN, chessBoard.getNextPlayer());
	}

	@Ignore
	@Test
    public void whenFullThenDraw(){
	    String result = StringUtils.EMPTY;
	    for(int i=0; i<chessBoard.getColumn(); i++){
	        for(int j=0; j<chessBoard.getRows(); j++){
	            result = chessBoard.putPiece(i+1);
            }
        }
        Assert.assertEquals("It's a draw", result);
    }

    @Test
    public void whenVerticalLineThenWin(){
        chessBoard.putPiece(1);
        chessBoard.putPiece(2);
        chessBoard.putPiece(1);
        chessBoard.putPiece(2);
        String result = chessBoard.putPiece(1);
        Assert.assertEquals("红方获胜", result);
    }

    @Test
    public void whenHorizontalLineThenWin(){
        chessBoard.putPiece(1);
        chessBoard.putPiece(1);
        chessBoard.putPiece(2);
        chessBoard.putPiece(2);
        String result = chessBoard.putPiece(3);
        Assert.assertEquals("红方获胜", result);
    }

    @Test
    public void whenObliqueLineThenWin(){
        chessBoard.putPiece(1);
        chessBoard.putPiece(2);
        chessBoard.putPiece(2);
        chessBoard.putPiece(3);
        chessBoard.putPiece(1);
        chessBoard.putPiece(3);
        String result = chessBoard.putPiece(3);
        Assert.assertEquals("红方获胜", result);
    }
}
