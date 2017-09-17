package com.caozeal.someTry.connect4;
/**.
 * <p>创建时间：2017年9月17日下午9:14:21
 * <p>com.caozeal.someTry.connect4
 * @author  caozeal
 * @version 1.0
 */

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

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
	public void play(){
		chessBoard.putPiece(1);
		chessBoard.putPiece(2);
		chessBoard.putPiece(1);
		chessBoard.putPiece(1);
		chessBoard.putPiece(2);
		chessBoard.putPiece(3);
		
	}
}
