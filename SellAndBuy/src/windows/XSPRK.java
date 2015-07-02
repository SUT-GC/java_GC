package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.ShopDao;
import com.shop.ShopInformation;

public class XSPRK extends JInternalFrame {
	private JLabel GoodIDL = new JLabel("商品编号");
	private JTextField GoodIDC = new JTextField(25);
	private JLabel GoodNameL = new JLabel("商品名称");
	private JTextField GoodNameC = new JTextField(25);
	private JLabel GoodPriceL = new JLabel("商品售价");
	private JTextField GoodPriceC = new JTextField(16);
	private String[] GoodUtils = new String[] {"个","斤","盒","袋"};
	private JLabel GoodUtilL = new JLabel("(元) 单位");
	private JComboBox<String > GoodUtil = new JComboBox<String>(GoodUtils);
	private JButton ruku = new JButton("入库");
	private JButton reset = new JButton("重置");
	ShopDao shopdao = new ShopDao();
	public XSPRK(){
		this.setTitle("新商品入库界面");
		this.setResizable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		JPanel goodid =new JPanel();
		goodid.add(GoodIDL);
		goodid.add(GoodIDC);
		JPanel goodname = new JPanel();
		goodname.add(GoodNameL);
		goodname.add(GoodNameC);
		JPanel goodpu = new JPanel();
		goodpu.add(GoodPriceL);
		goodpu.add(GoodPriceC);
		goodpu.add(GoodUtilL);
		goodpu.add(GoodUtil);
		JPanel buttons = new JPanel();
		buttons.add(new JLabel("------------------------------------------------------------------------------------------------------------"));
		buttons.add(ruku);
		buttons.add(reset);
		buttons.add(new JLabel("--------------------------------------------------------------"));
		JPanel all = new JPanel();
		all.add(goodid);
		all.add(goodname);
		all.add(goodpu);
		all.add(buttons);
		this.add(all);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodIDC.setText("");
				GoodNameC.setText("");
				GoodPriceC.setText("");
			}
		});
		ruku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopInformation si = new ShopInformation();
				si.setGoodID(GoodIDC.getText());
				si.setGoodName(GoodNameC.getText());
				si.setGoodPrice(Float.valueOf(GoodPriceC.getText()));
				si.setGoodNum(0);
				si.setGoodUnit(GoodUtil.getSelectedItem()+"");
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(
						null, "请确认是否入库", "请确认是否入库",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null));
				try {
					shopdao.insetShopIn(si);
					JOptionPane.showConfirmDialog(
							null, "添加成功", "添加成功",
							JOptionPane.OK_OPTION,
							JOptionPane.WARNING_MESSAGE, null);
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showConfirmDialog(
							null, "输入信息有误,执行失败", "输入信息有误,执行失败",
							JOptionPane.OK_OPTION,
							JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
	}
}
