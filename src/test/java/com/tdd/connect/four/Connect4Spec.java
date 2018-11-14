package com.tdd.connect.four;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Connect4Spec {
	
	@Test
	public void whenTheGameStartsTheBoardIsEmpty() {
		Connect4 connect4 = new Connect4();
		assertThat(connect4.getNumberOfDiscs(), is(0));
	}
	
	@Test(expected = RuntimeException.class)
	public void whenADiscIsInsertedOutsideBoundsThenExceptionIsThrown() {
		Connect4 connect4 = new Connect4();
		connect4.addDiscInColumn(10);
	}
	
	@Test
	public void whenFirstDiscIsInsertedIntoEmptyColumnThenPositionZeroIsTaken() {
		Connect4 connect4 = new Connect4();
		connect4.addDiscInColumn(1);
		assertThat(connect4.lastPositionTakenInColumn(1), is(5));
	}
	
	@Test
	public void whenSecondDiscIsInsertedThenPositionOneIsTaken() {
		Connect4 connect4 = new Connect4();
		connect4.addDiscInColumn(1);
		connect4.addDiscInColumn(1);
		assertThat(connect4.lastPositionTakenInColumn(1), is (4));
	}
}
