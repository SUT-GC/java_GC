import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class HandDraw {
	private String compand = null;
	private int AREA_WIDTH = 1260;
	private int AREA_HEIGHT = 600;
	private int PREX = -1;
	private int PREY = -1;
	private int DRAWTSX = 0;
	private int DRAWTSY = 0;
	private int DRAWTEX = 0;
	private int DRAWTEY = 0;
	private int LINESTARTX = 0;
	private int LINESTARTY = 0;
	private int LINEENDX = 0;
	private int LINEENDY = 0;
	private Color forecolor = Color.BLACK;
	private Color backcolor = Color.BLACK;
	private JMenuBar jmb = new JMenuBar();
	private JMenu edit = new JMenu("编辑");
	private JMenu caidan = new JMenu("菜单");
	private JMenuItem save = new JMenuItem("保存图像");
	private JMenuItem open = new JMenuItem("打开图片");
	private JMenuItem newone = new JMenuItem("新建图像");
	private JMenuItem setBackGroud = new JMenuItem("设置图像背景颜色");
	private JPopupMenu pop = new JPopupMenu();
	private MenuActionListener ac = new MenuActionListener();
	private JMenuItem drawLine = new JMenuItem("绘制直线");
	private JMenuItem drawOval = new JMenuItem("绘制椭圆");
	private JMenuItem drawRect = new JMenuItem("绘制长方形");
	private JMenuItem drawRoundRect = new JMenuItem("绘制圆角矩形");
	private JMenuItem drawPolyLine = new JMenuItem("绘制折线");
	private JMenuItem changeColor = new JMenuItem("选择画笔颜色");
	private JMenuItem deleteG = new JMenuItem("取消画笔");
	private JMenuItem eraser = new JMenuItem("橡皮擦");
	private BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private Graphics g = image.getGraphics();
	private JFrame window = new JFrame("GC");
	private DrawCanvas mydraw = new DrawCanvas();

	public void init() {
		// 添加菜单栏
		jmb.add(caidan);
		jmb.add(edit);
		caidan.add(newone);
		caidan.add(save);
		caidan.add(open);
		edit.add(setBackGroud);
		// 为菜单栏添加事件监听器
		save.addActionListener(caidanAL);
		open.addActionListener(caidanAL);
		newone.addActionListener(caidanAL);
		setBackGroud.addActionListener(caidanAL);
		window.setJMenuBar(jmb);
		// 添加右键弹出栏
		pop.add(drawLine);
		pop.add(drawOval);
		pop.add(drawRect);
		pop.add(drawPolyLine);
		pop.add(drawRoundRect);
		// 添加菜单的分割线
		pop.addSeparator();
		pop.add(changeColor);
		pop.addSeparator();
		pop.add(deleteG);
		pop.addSeparator();
		pop.add(eraser);
		// 将画布底画成白色
		g.setColor(Color.WHITE);
		mydraw.add(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		mydraw.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		window.add(mydraw);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		mydraw.setComponentPopupMenu(pop);
		mydraw.addMouseListener(ac);
		mydraw.addMouseMotionListener(ac);
		// 注册事件监听器
		drawLine.addActionListener(ac);
		drawOval.addActionListener(ac);
		drawRect.addActionListener(ac);
		drawPolyLine.addActionListener(ac);
		drawRoundRect.addActionListener(ac);
		changeColor.addActionListener(ac);
		deleteG.addActionListener(ac);
		eraser.addActionListener(ac);
	}

	class MenuActionListener implements ActionListener, MouseMotionListener,
			MouseListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			compand = e.getActionCommand();
			if (compand == "取消画笔") {
				compand = null;
			}
			if (compand == "选择画笔颜色") {
				forecolor = JColorChooser.showDialog(window, "选择画笔颜色",
						forecolor);
				final JColorChooser colorPane = new JColorChooser(forecolor);
				JDialog jd = JColorChooser.createDialog(window, "选择画笔颜色",
						false, colorPane, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								colorPane.getColor();
							}
						}, null);
			}
		}

		public void mouseDragged(MouseEvent e) {
			if (compand == "绘制折线") {
				if (PREX > 0 && PREY > 0) {
					g.setColor(forecolor);
					g.drawLine(PREX, PREY, e.getX(), e.getY());
				}
				PREX = e.getX();
				PREY = e.getY();
				mydraw.repaint();
			}
		}

		public void mouseMoved(MouseEvent e) {

		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			if (compand != null && e.getButton() == MouseEvent.BUTTON1) {
				switch (compand) {
				case "绘制直线":
					LINESTARTX = e.getX();
					LINESTARTY = e.getY();
					break;
				default:
					DRAWTSX = e.getX();
					DRAWTSY = e.getY();
					break;
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (compand != null && e.getButton() == MouseEvent.BUTTON1) {
				switch (compand) {
				case "绘制直线":
					LINEENDX = e.getX();
					LINEENDY = e.getY();
					g.setColor(forecolor);
					g.drawLine(LINESTARTX, LINESTARTY, LINEENDX, LINEENDY);
					mydraw.repaint();
					break;
				case "绘制长方形":
					DRAWTEX = e.getX();
					DRAWTEY = e.getY();
					g.setColor(forecolor);
					g.drawRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					g.fillRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					mydraw.repaint();
					break;
				case "绘制椭圆":
					DRAWTEX = e.getX();
					DRAWTEY = e.getY();
					g.setColor(forecolor);
					g.drawOval(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					g.fillOval(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					mydraw.repaint();
					break;
				case "绘制圆角矩形":
					DRAWTEX = e.getX();
					DRAWTEY = e.getY();
					g.setColor(forecolor);
					g.drawRoundRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX,
							DRAWTEY - DRAWTSY, (int) ((DRAWTEX - DRAWTSX) / 4),
							(int) ((DRAWTEX - DRAWTSX) / 4));
					g.fillRoundRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX,
							DRAWTEY - DRAWTSY, (int) ((DRAWTEX - DRAWTSX) / 4),
							(int) ((DRAWTEX - DRAWTSX) / 4));
					mydraw.repaint();
					break;
				case "橡皮擦":
					DRAWTEX = e.getX();
					DRAWTEY = e.getY();
					g.setColor(backcolor);
					g.drawRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					g.fillRect(DRAWTSX, DRAWTSY, DRAWTEX - DRAWTSX, DRAWTEY
							- DRAWTSY);
					mydraw.repaint();
					break;
				}
			}
			PREX = -1;
			PREY = -1;
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}
	}

	ActionListener caidanAL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "新建图像") {
				g.setColor(Color.WHITE);
				g.drawRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
				g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
				mydraw.repaint();
			} else if (e.getActionCommand() == "设置图像背景颜色") {
				int ok = JOptionPane.showConfirmDialog(window,
						" 如果现在设置背景颜色,你的画布将会被刷新,是否继续!", "警告",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (ok == 0) {
					backcolor = JColorChooser.showDialog(window, "选择画笔颜色",
							backcolor);
					final JColorChooser colorPane = new JColorChooser(backcolor);
					JDialog jd = JColorChooser.createDialog(window, "选择画笔颜色",
							false, colorPane, new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									colorPane.getColor();
								}
							}, null);
					g.setColor(backcolor);
					g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
					mydraw.repaint();
				}
			} else if (e.getActionCommand() == "打开图片") {
				try {
					JFileChooser filechooser = new JFileChooser();
					filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int result = filechooser.showOpenDialog(window);
					if (filechooser.CANCEL_OPTION == result) {
						return;
					}
					File filename = filechooser.getSelectedFile();
					String xAndy = "0 0";
					xAndy = JOptionPane.showInputDialog(window, "请输入显示图片的起始坐标");
					if (xAndy == null) {
						xAndy = "0 0";
					}
					String[] xAndyToString = xAndy.split(" ");
					int x = Integer.valueOf(xAndyToString[0]);
					int y = Integer.valueOf(xAndyToString[1]);
					if (filename == null || filename.equals(" ")) {
						JOptionPane.showConfirmDialog(window, "地址无效", "警告",
								JOptionPane.CLOSED_OPTION,
								JOptionPane.ERROR_MESSAGE, null);
					} else {

						Image srcImage = ImageIO.read(filename);
						g.drawImage(srcImage, x, y, srcImage.getWidth(null),
								srcImage.getHeight(null), null);
						mydraw.repaint();

					}
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(window, "地址无效", "警告",
							JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE, null);
				}
			} else if (e.getActionCommand() == "保存图像") {
				JFileChooser filechooser = new JFileChooser();
				filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = filechooser.showSaveDialog(window);
				if (filechooser.CANCEL_OPTION == result) {
					return;
				}
				File filename = filechooser.getSelectedFile();
				if (filename == null || filename.equals(" ")) {
					JOptionPane.showConfirmDialog(window, "地址无效", "警告",
							JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					try {
						ImageIO.write(image, "jpeg",
								new File(filename.toString() + ".jpg"));
					} catch (IOException e1) {
						JOptionPane.showConfirmDialog(window, "地址无效", "警告",
								JOptionPane.CLOSED_OPTION,
								JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}
	};

	class DrawCanvas extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}
}
