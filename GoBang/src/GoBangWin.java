import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GoBangWin {
	private GoBangAI gbai = new GoBangAI();
	private BufferedImage table;
	private BufferedImage whitechess;
	private BufferedImage blackchess;
	private BufferedImage selectframe;
	private final int BOARD_SIZE = 15;
	private final int TABLE_WIDTH = 535;
	private final int TABLE_HEIGHT = 536;
	private final int RATE = TABLE_WIDTH / BOARD_SIZE;
	private int X_MOUSE = -1;
	private int Y_MOUSE = -1;
	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	JFrame jf = new JFrame("GC五子棋----1.0版本(随机数AI)");
	DrawChessBoard drawchessboard = new DrawChessBoard();
	private int X_OFFSET = 5;
	private int Y_OFFSET = 6;

	private void memset() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = 0;
			}
		}
	}

	public void init() {
		try {
			table = ImageIO.read(new File("img/board.jpg"));
			whitechess = ImageIO.read(new File("img/white.gif"));
			blackchess = ImageIO.read(new File("img/black.gif"));
			selectframe = ImageIO.read(new File("img/selected.gif"));
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(jf, "对不起,没有找到图片");
		}
		memset();
		drawchessboard
				.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		drawchessboard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int xPos = (e.getX() - X_OFFSET) / RATE;
				int yPos = (e.getY() - Y_OFFSET) / RATE;
				if (board[xPos][yPos] == 0) {
					board[xPos][yPos] = -1;
					gbai.setBLACK_X(xPos);
					gbai.setBLACK_Y(yPos);
					gbai.AI(board, BOARD_SIZE);
					gbai.blackWinOrNotWin(board);
					gbai.WhiteWinOrNotWin(board);
					drawchessboard.repaint();
				} else {
					JOptionPane.showMessageDialog(jf, "该点已有棋子,请重新选择下棋点");
				}
				if (gbai.isBLACK_WIN()) {
					if (JOptionPane.YES_OPTION== JOptionPane
							.showConfirmDialog(jf, "恭喜您, 您赢得了本局比赛 !!! ",
									"是否继续游戏", JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null)) {
						gbai.setBLACK_WIN(false);
						gbai.setWHITE_WIN(false);
						memset();
					} else {
						System.exit(0);
					}
				}
				if (gbai.isWHITE_WIN()) {
					if (JOptionPane.YES_OPTION == JOptionPane
							.showConfirmDialog(jf, "白棋获胜,相信您下次一定会赢的 !!! ",
									"是否继续游戏", JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null)) {
						gbai.setBLACK_WIN(false);
						gbai.setWHITE_WIN(false);
						memset();
					} else {
						System.exit(0);
					}
				}

			}

			public void mouseExited(MouseEvent e) {
				X_MOUSE = -1;
				Y_MOUSE = -1;
				drawchessboard.repaint();
			}
		});
		drawchessboard.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				X_MOUSE = e.getX();
				Y_MOUSE = e.getY();
				drawchessboard.repaint();
			}
		});
		jf.add(drawchessboard);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}

	private class DrawChessBoard extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(table, 0, 0, null);
			if (X_MOUSE >= 0 && Y_MOUSE >= 0) {
				g.drawImage(selectframe, ((X_MOUSE - X_OFFSET) / RATE) * RATE
						+ X_OFFSET, ((Y_MOUSE - Y_OFFSET) / RATE) * RATE
						+ Y_OFFSET, null);
			}
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					if (board[i][j] == -1) {
						g.drawImage(blackchess, i * RATE + X_OFFSET, j * RATE
								+ Y_OFFSET, null);
					}
					if (board[i][j] == 1) {
						g.drawImage(whitechess, i * RATE + X_OFFSET, j * RATE
								+ Y_OFFSET, null);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		GoBangWin g1 = new GoBangWin();
		g1.init();
	}
}
