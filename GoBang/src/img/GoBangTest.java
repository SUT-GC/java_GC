package img;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoBangTest {
	JFrame jf = new JFrame("GC");
	BufferedImage board;
	BufferedImage chess;
	BufferedImage select;
	Draw draw = new Draw();
	public void init(){
		try {
			board = ImageIO.read(new File("img/board.jpg"));
			chess = ImageIO.read(new File("img/black.gif"));
			select = ImageIO.read(new File("img/selected.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		draw.setPreferredSize(new Dimension(535,536));
		draw.repaint();
		jf.add(draw);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	class Draw extends JPanel{
		public void paint(Graphics g){
			g.drawImage(board, 0, 0, null);
			g.drawImage(chess, 5+5*35, 6+5*35,null);
			g.drawImage(select, 5+7*35, 6+7*35,null);
		}
	}
	
	public static void main(String[] args) {
		GoBangTest g2 = new GoBangTest();
		g2.init();
	}

}
