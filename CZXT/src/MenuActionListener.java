import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuActionListener  implements  ActionListener, MouseListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
//		System.out.println(e.getX()+"     "+e.getY());
//		g.setColor(Color.BLACK);
//		g.drawRect(e.getX(),e.getY(),100,100);
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}

}
