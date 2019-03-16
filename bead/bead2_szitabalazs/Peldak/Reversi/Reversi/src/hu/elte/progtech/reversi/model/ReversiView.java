package hu.elte.progtech.reversi.model;

public interface ReversiView {

	void update(int row, int column);
	
	void nextTurn(ReversiColor who);
	
	void samePlayerNextTurn(ReversiColor who);

	void cantPutHere();

	void endGame(ReversiColor winner);

	void updateTime(int time);

	void updateTimeToPut(int time);

}
