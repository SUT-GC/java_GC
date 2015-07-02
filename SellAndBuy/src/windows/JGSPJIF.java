package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.ShopDao;
import com.shop.BuyShop;

public class JGSPJIF extends JInternalFrame {
	private JLabel buyIDL = new JLabel("进货单号 : ");
	private JTextField buyIDC = new JTextField(48);
	private JLabel goodIDL = new JLabel("商品编号 : ");
	private JTextField goodIDC = new JTextField(20);
	private JLabel goodNameL = new JLabel("  商品名称 : ");
	private JTextField goodNameC = new JTextField(20);
	private JLabel BusinessNameL = new JLabel("生产厂商 : ");
	private JTextField BusinessNameC = new JTextField(48);
	private JLabel goodPriceL = new JLabel("商品单价 : ");
	private JTextField goodPriceC = new JTextField(15);
	private JLabel buyNumL = new JLabel("( 元 )    购进数量 : ");
	private JTextField buyNumC = new JTextField(15);
	private JLabel buyUnitL = new JLabel("  单位 : ");
	private JComboBox<String> buyUnitList;
	private JButton buyIn = new JButton(" ---- 购入 ---- ");
	private JButton reset = new JButton(" ---- 重置 ---- ");
	private String[] goodUnits = new String[] { "个", "斤", "盒", "袋" };
	private ShopDao shopdao = new ShopDao();

	public JGSPJIF() {
		this.setTitle("进购商品界面");
		this.setResizable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		JPanel buyID = new JPanel();
		buyID.add(buyIDL);
		buyID.add(buyIDC);

		JPanel goodinfor = new JPanel();
		goodinfor.add(goodIDL);
		goodinfor.add(goodIDC);
		goodinfor.add(goodNameL);
		goodinfor.add(goodNameC);

		JPanel BusinessName = new JPanel();
		BusinessName.add(BusinessNameL);
		BusinessName.add(BusinessNameC);

		Vector<String> vector = new Vector<String>();
		for (int i = 0; i < goodUnits.length; i++) {
			vector.add(goodUnits[i]);
		}
		buyUnitList = new JComboBox<String>(vector);
		
		JPanel buyInformation = new JPanel();
		buyInformation.add(goodPriceL);
		buyInformation.add(goodPriceC);
		buyInformation.add(buyNumL);
		buyInformation.add(buyNumC);
		buyInformation.add(buyUnitL);
		buyInformation.add(buyUnitList);

		// buttons
		JPanel buttons = new JPanel();
		buttons.add(buyIn);
		buttons.add(reset);
		// 将新建BOX之后纵向添加元素
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(buyID);
		box.add(goodinfor);
		box.add(BusinessName);
		box.add(buyInformation);
		box.add(buttons);
		this.add(box);
		
		buyIDC.setText("BI"+(new Date()).getTime()+"");
			
		buyIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyShop buyshop = new BuyShop();
				buyshop.setBuyID(buyIDC.getText());
				buyshop.setGoodNum(goodIDC.getText());
				buyshop.setGoodName(goodNameC.getText());
				buyshop.setPrice(Float.valueOf(goodPriceC.getText()));
				buyshop.setNumber(Integer.valueOf(buyNumC.getText()));
				buyshop.setGoodUnit((String) buyUnitList.getSelectedItem());
				buyshop.setBusinessName(BusinessNameC.getText());
				float money = buyshop.getPrice() * buyshop.getNumber();
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(
						null, "商品总价为 : " + money + "(元)  \n请确认是否购进", "请确认是否购进",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null))
					;
				try {
					shopdao.insetBuyShop(buyshop);
					JOptionPane.showConfirmDialog(null, "添加成功", "添加成功",
							JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
							null);
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, "输入信息有误,执行失败",
							"输入信息有误,执行失败", JOptionPane.OK_OPTION,
							JOptionPane.WARNING_MESSAGE, null);
				}
				buyIDC.setText("BI"+(new Date()).getTime()+"");
			}
		});
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyIDC.setText("BI"+(new Date()).getTime()+"");
				goodIDC.setText("");
				goodNameC.setText("");
				BusinessNameC.setText("");
				goodPriceC.setText("");
				buyNumC.setText("");
			}
		});
	}
}
