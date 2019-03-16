package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ChessBoard;
import model.InvalidMoveException;

public class ChessFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JButton[][] board;

	public ChessFrame(ChessBoard chessBoard) {
		setTitle("Chess");
		setLocationRelativeTo(null);
		setSize(400, 400);
		
		this.board = new JButton[ChessBoard.SIZE][ChessBoard.SIZE];
		
		JPanel mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane,
				BoxLayout.Y_AXIS));
		add(mainPane);
		
		JButton reset = new JButton("Reset");
		mainPane.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeChessPiece(chessBoard.getX(),
						chessBoard.getY());
				chessBoard.reset();
				placeChessPiece(chessBoard.getX(),
						chessBoard.getY());
			}
		});
		
		JPanel boardPane = new JPanel();
		boardPane.setLayout(
				new GridLayout(ChessBoard.SIZE,
						ChessBoard.SIZE));
		mainPane.add(boardPane);	
		
		for (int i = 0; i < ChessBoard.SIZE; i++) {
			for (int j = 0; j < ChessBoard.SIZE; j++) {
				final int x = i;
				final int y = j;
				
				JButton field = new JButton("");
				Font f = new Font("Arial Unicode MS", Font.PLAIN, 14);
				field.setFont(f);
				
				field.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						removeChessPiece(chessBoard.getX(),
								chessBoard.getY());
						try {
							chessBoard.move(x, y);
						}
						catch (InvalidMoveException ex) {
							
						}
						placeChessPiece(chessBoard.getX(),
								chessBoard.getY());						
					}
				});
				
				board[i][j] = field;
				boardPane.add(field);
			}
		}
		placeChessPiece(chessBoard.getX(), chessBoard.getY());
	}
	
	protected void placeChessPiece(int x, int y) {
		board[x][y].setText("♘");
		//Arial Unicode MS
	}

	protected void removeChessPiece(int x, int y) {
		board[x][y].setText("");		
	}	
	
}
