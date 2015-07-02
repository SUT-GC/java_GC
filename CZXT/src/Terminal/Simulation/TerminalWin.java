package Terminal.Simulation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TerminalWin {
	//定义窗口所需要的组件
	JFrame win = new JFrame("GC终端模拟器--文件管理系统");
	JTextArea jta = new JTextArea(50,50);
	JTextField jtf = new JTextField(50);
	JScrollPane tajsp = new JScrollPane(jta);
	Box box = new Box(BoxLayout.X_AXIS);
	JButton ok = new JButton("send your command");
	//定义接受命令变量
	String[] commands;
	String visual;
	//获得当前用户的名字
	private String HOSTNAME;
	private InetAddress hostip;
	//定义后台
	TermianlBackstage tb = new TermianlBackstage();
	//构造函数初始化localname
	public TerminalWin()  {
		try {
			hostip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		HOSTNAME = hostip.getHostName();
		HOSTNAME  = HOSTNAME+" : ";
		jta.append(HOSTNAME);
	}
	public void init(){
		box.add(jtf);
		box.add(ok);
		win.add(tajsp);
		win.add(box, BorderLayout.SOUTH);
		win.setSize(600, 700);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		//给ok按钮添加事件监听器
		Action okActionListener = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String command = jtf.getText();
				jtf.setText("");
				commands = command.split(" ");
				tb.setCommands(commands);
				tb.startWork();
				visual = tb.getResult();
				if(visual.equals("clear")){
					jta.setText(""+HOSTNAME);
				}else{
					jta.append(Arrays.toString(commands)+"\n"+visual+"\n"+HOSTNAME);
					tb.setResult(null);
				}
			}
		};
		ok.addActionListener(okActionListener);
		//将回车键与ok按钮关联起来
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'), "send");
		jtf.getActionMap().put("send", okActionListener);
	}
}
