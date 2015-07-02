package windows;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class openFrameAction extends AbstractAction {
	private String frameName = null;
	public void actionPerformed(ActionEvent e) {
//		JInternalFrame jif = new JInternalFrame(frameName);
//		jif.setSize(600, 600);
//		jif.show();
//		jif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JOptionPane.showConfirmDialog(null, "hello");
	}
	public openFrameAction(String cName, String fName, Icon icon){
		this.frameName = fName;
		putValue(Action.NAME, cName);
		putValue(Action.SHORT_DESCRIPTION, cName);
		putValue(Action.SMALL_ICON, icon);
	}
}
