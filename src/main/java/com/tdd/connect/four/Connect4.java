package com.tdd.connect.four;

import java.util.stream.IntStream;

public class Connect4 {

	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	private String[][] board = new String[ROWS][COLUMNS];

	public int getNumberOfDiscs() {
		return 0;
	}

	public void addDiscInColumn(int column) {
		checkIfColumnIsWithinBounds(column);
		int row = getNumberOfDiscsInAColumn(column);
		checkIfRowIsWithinBounds(row);
		setTheValueIn(column, row);
	}

	private void setTheValueIn(int column, int row) {
		board[row - 1][column] = "X";
	}

	private void checkIfRowIsWithinBounds(int row) {
		if(row > ROWS) {
			throw new RuntimeException("Disc cannot be inserted - outside bounds");
		}
	}

	private void checkIfColumnIsWithinBounds(int column) {
		if (column < 0 || column > 6) {
			throw new RuntimeException("Disc cannot be inserted - outside bounds");
		}
	}

	private int getNumberOfDiscsInAColumn(int column) {
		return (int) IntStream.range(0, ROWS).filter(row -> board[row][column] == null).count();
	}

	public int lastPositionTakenInColumn(int column) {
		return getNumberOfDiscsInAColumn(column);
	}

}
