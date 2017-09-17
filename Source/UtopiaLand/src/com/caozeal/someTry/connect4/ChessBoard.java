package com.caozeal.someTry.connect4;

import java.util.Arrays;

/**.
 * <p>创建时间：2017年9月17日下午9:27:19
 * <p>com.caozeal.someTry.connect4
 * @author  caozeal
 * @version 1.0
 */
public class ChessBoard {
	
	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	public static final Integer RED = 1;
	public static final Integer GREEN = -1;
	private Integer nextPlayer;
	private int pieces = 0;
	private Integer board[][] = new Integer[COLUMNS][ROWS];
	
	public ChessBoard() {
		for(Integer[] column : board){
			Arrays.fill(column, 0);
		}
		nextPlayer = RED;
		printBoard();
	}

	public int getColumn() {
		return board.length;
	}

	public int getRows() {
		return board[0].length;
	}

	public int getPieces() {
		return pieces;
	}

	public void putPiece(int column) {
		checkRow(column);
		pieces++;
		board[column-1][getColumnPieces(column)] = nextPlayer;
		changePlayer();
		printBoard();
	}

	private void printBoard() {
		System.out.println();
		String playerName;
		playerName = getPlayerName(nextPlayer);
		System.out.println("********第" + getPieces() + "步，轮到" + playerName + "方执子*****************");
		for(int j=ROWS-1; j>=0; j--){
			for(int i=0; i<COLUMNS; i++){
				System.out.print(getPlayerName(board[i][j]));
			}
			System.out.println();
		}
		System.out.println("************************************");
	}

	private String getPlayerName(Integer player) {
		if(player == RED){
			return "红";
		}
		if(player == GREEN){
			return "绿";
		}
		return "口";
	}

	private void changePlayer() {
		nextPlayer = Math.negateExact(nextPlayer);
	}

	private void checkRow(int column) {
		if(getColumnPieces(column) > 6){
			throw new RuntimeException("棋子超出最大高度！");
		}
		
	}

	public int getColumnPieces(int column) {
		int pieces = 0;
		checkColumn(column);
		for(int i=0; i<ROWS; i++){
			if(board[column-1][i] != 0){
				pieces++;
			}
		}
		return pieces;
	}

	private void checkColumn(int column) {
		if(column < 1 || column > 7){
			throw new RuntimeException("放置的棋子超出边界！");
		}
		
	}

	public Object getNextPlayer() {
		return nextPlayer;
	}
}
