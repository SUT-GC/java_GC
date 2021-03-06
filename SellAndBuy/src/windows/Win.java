package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

public class Win {
	public static  Admin admin = new Admin();
	private JFrame frame;
	private JDesktopPane desktoppane;
	private JLabel backLabel;
	private Preferences preference;
	private Map<String, JInternalFrame> ifs = new HashMap<>();

	public Win() {
		frame = new JFrame("进销货管理系统");
		frame.addComponentListener(new FrameListenner());
		frame.setLayout(new BorderLayout());
		frame.setBounds(100, 10, 1100, 700);
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			updateBackImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		desktoppane = new JDesktopPane();
		desktoppane.add(backLabel, 0);
		frame.add(desktoppane);
		JTabbedPane navigationPanel = creadeNavigationPanel();
		frame.add(navigationPanel, BorderLayout.NORTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private JTabbedPane creadeNavigationPanel() {
		JTabbedPane tabbedpanel = new JTabbedPane();
		tabbedpanel.setFocusable(true);
		tabbedpanel.setBackground(new Color(91, 238, 139));
		tabbedpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		// 欢迎界面
		JPanel HYPanel = new JPanel();
		JLabel welcomeLabel = new JLabel(
				"Welcome to the Warehouse Management System !!!!");
		welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
		HYPanel.add(welcomeLabel);
		// 商品销售界面
		JPanel SPXSPanel = new JPanel();
		SPXSPanel.setLayout(new BoxLayout(SPXSPanel, BoxLayout.X_AXIS));
		SPXSPanel.add(createFrameButton("销售商品", "xiaoshoushangpin"));
		SPXSPanel.add(createFrameButton("销售清单", "xiaoshouqingdan"));
		// 商品购进界面
		JPanel SPGJPanel = new JPanel();
		SPGJPanel.setLayout(new BoxLayout(SPGJPanel, BoxLayout.X_AXIS));
		SPGJPanel.add(createFrameButton("进购商品", "jingoushangpin"));
		SPGJPanel.add(createFrameButton("进购清单", "jingouqingdan"));
		// 商品库存管理
		JPanel SPKCPanel = new JPanel();
		SPKCPanel.setLayout(new BoxLayout(SPKCPanel, BoxLayout.X_AXIS));
		SPKCPanel.add(createFrameButton("新商品入库", "xinshangpinruku"));
		SPKCPanel.add(createFrameButton("查询商品库存", "chaxunshangpinkucun"));
		// 向jtabbedpanel中添加panel
		tabbedpanel.addTab("Welcome 欢迎界面", HYPanel);
		tabbedpanel.addTab("商品销售信息", SPXSPanel);
		tabbedpanel.addTab("商品购进信息", SPGJPanel);
		tabbedpanel.addTab("商品库存管理", SPKCPanel);
		return tabbedpanel;
	}

	private JButton createFrameButton(String fName, String cName) {
		String imgUrl = "src//img//" + cName + "2.jpg";
		System.out.println(imgUrl);
		String imgUrl_down = "src//img//" + cName + "1.jpg";
		Icon icon = new ImageIcon(imgUrl);
		Icon icon_down = new ImageIcon(imgUrl_down);
		Action action = new openFrameAction(fName, cName, icon);
		JButton button = new JButton(action);
		button.setMargin(new Insets(0, 0, 0, 0));// 设置按钮四周边界的大小
		button.setHideActionText(true);// 设置按钮隐藏Action中的文本信息
		button.setFocusable(false);// 设置按钮获取焦点时候是否绘制焦点样式
		button.setBorderPainted(false);// 是否绘制按钮边框样式
		button.setContentAreaFilled(false);// 是否绘制图形按钮
		button.setPressedIcon(icon_down);// 设置按钮按下之后的图片
		return button;
	}

	private void updateBackImage() throws Exception {
		if (backLabel != null) {
			int backw = Win.this.frame.getWidth();
			int backh = Win.this.frame.getHeight();
			backLabel.setSize(new Dimension(backw, backh));
			backLabel.setText("<html><body><image width='" + backw
					+ "'height='" + (backh) + "' src='"
					+ Win.this.getClass().getResource("首页.jpg")
					+ "'></img></body></html>");
		}
	}

	class FrameListenner extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {
			try {
				updateBackImage();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public class openFrameAction extends AbstractAction {
		private String frameName = null;
		private JPanel login;
		private JTextField usr = new JTextField(10);
		private JPasswordField pass = new JPasswordField(10);
		public openFrameAction(){
			
		}
		public void actionPerformed(ActionEvent e) {
			// JInternalFrame jif = new JInternalFrame(frameName, true, true,
			// true, true);
			// desktoppane.add(jif);
			// jif.reshape(100, 0, 800, 500);
			// jif.show();

			switch (frameName) {
			case "销售商品":
				XSSPJIF xsspjif = new XSSPJIF();
				desktoppane.add(xsspjif);
				xsspjif.reshape(100, 0, 800, 500);
				xsspjif.show();
				break;
			case "进购商品":
				JGSPJIF jgspjif = new JGSPJIF();
				desktoppane.add(jgspjif);
				jgspjif.reshape(100, 0, 800, 500);
				jgspjif.show();
				break;
			case "查询商品库存":
				usr.setText("");
				pass.setText("");
				if( JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, login, "管理员登录",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null) && check(usr.getText(), pass.getText())){
					CXSPKC cxspkc = new CXSPKC();
					desktoppane.add(cxspkc);
					cxspkc.reshape(100, 0, 800, 500);
					cxspkc.show();
					break;
				}else{
					JOptionPane.showMessageDialog(null, "密码错误或者您取消了登录", 
							"密码错误或者您取消了登录", JOptionPane.WARNING_MESSAGE, null);
					break;
				}
			case "销售清单":
				XSQDJIF ssqdjif = new XSQDJIF();
				desktoppane.add(ssqdjif);
				ssqdjif.reshape(100, 0, 800, 500);
				ssqdjif.show();
				break;
			case "进购清单":
				JGQDJIF jgqdjif = new JGQDJIF();
				desktoppane.add(jgqdjif);
				jgqdjif.reshape(100, 0, 800, 500);
				jgqdjif.show();
				break;
			case "新商品入库":
				usr.setText("");
				pass.setText("");
				if( JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, login, "管理员登录",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null) && check(usr.getText(), pass.getText())){
					XSPRK xsprk = new XSPRK();
					desktoppane.add(xsprk);
					xsprk.reshape(200, 200, 800, 200);
					xsprk.show();
					break;
				}else{
					JOptionPane.showMessageDialog(null, "密码错误或者您取消了登录", "密码错误或者您取消了登录", JOptionPane.WARNING_MESSAGE, null);
					break;
				}
			}
		}

		public openFrameAction(String cName, String fName, Icon icon) {
			this.frameName = cName;
			putValue(Action.NAME, cName);
			putValue(Action.SHORT_DESCRIPTION, cName);
			putValue(Action.SMALL_ICON, icon);
			login = new JPanel();
			login.add(new JLabel("用户名: "));
			login.add(usr);
			login.add(new JLabel("密码 :"));
			login.add(pass);
		}
		public Boolean check(String usr, String pass){
			if(admin.getUSR().equals(usr)  && admin.getPASS().equals(pass)){
				return true;
			}else{
				return false;
			}
		}
	}

}
