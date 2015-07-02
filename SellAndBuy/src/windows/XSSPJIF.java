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
import com.shop.SellShop;

public class XSSPJIF extends JInternalFrame {
	private ShopDao shopdao = new ShopDao();
	private String sellID;
	private String goodID;
	private float goodPrice;
	private int sellNumber;
	private String[] goodUnits = new String[] { "个", "斤", "盒", "袋" };
	private float sumPrivce;
	private JLabel sellIDL = new JLabel("订单编号 : ");
	private JTextField sellIDC = new JTextField(48);
	private JLabel goodIDL = new JLabel("商品编号 : ");
	private JTextField goodIDC = new JTextField(48);
	private JLabel goodPriceL = new JLabel("商品单价 : ");
	private JTextField goodPriceC = new JTextField(15);
	private JLabel sellNumL = new JLabel("( 元 )    销售数量 : ");
	private JTextField sellNumC = new JTextField(15);
	private JLabel sellUnitL = new JLabel("  单位 : ");
	private JComboBox<String> sellUnitList;
	private JButton sellOut = new JButton(" ---- 售出 ---- ");
	private JButton reset = new JButton(" ---- 重置 ---- ");

	public XSSPJIF() {
		this.setTitle("销售商品界面");
		this.setResizable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		// sellIDL and sellIDC
		JPanel sellIDLandIDC = new JPanel();
		// sellIDLandIDC.setLayout(new BoxLayout(sellIDLandIDC,
		// BoxLayout.X_AXIS));
		sellIDLandIDC.add(sellIDL);
		sellIDLandIDC.add(sellIDC);
		// goodIDL and goodIDC
		JPanel goodIDLandIDC = new JPanel();
		goodIDLandIDC.add(goodIDL);
		goodIDLandIDC.add(goodIDC);
		// 初始化JCB
		Vector<String> vector = new Vector<String>();
		for (int i = 0; i < goodUnits.length; i++) {
			vector.add(goodUnits[i]);
		}
		sellUnitList = new JComboBox<String>(vector);
		// goodPrivceL C and sellNumL C and sellUnitL and List
		JPanel sellInformation = new JPanel();
		sellInformation.add(goodPriceL);
		sellInformation.add(goodPriceC);
		sellInformation.add(sellNumL);
		sellInformation.add(sellNumC);
		sellInformation.add(sellUnitL);
		sellInformation.add(sellUnitList);
		// buttons
		JPanel buttons = new JPanel();
		buttons.add(sellOut);
		buttons.add(reset);
		// 将新建BOX之后纵向添加元素
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(sellIDLandIDC);
		box.add(goodIDLandIDC);
		box.add(sellInformation);
		box.add(buttons);
		this.add(box);
		sellIDC.setText("XS"+(new Date()).getTime()+"");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellIDC.setText("XS"+(new Date()).getTime()+"");
				goodIDC.setText("");
				goodPriceC.setText("");
				sellNumC.setText("");
			}
		});
		sellOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellShop sellshop = new SellShop();
				sellshop.setGoodID(goodIDC.getText());
				sellshop.setGoodPrice(Float.valueOf(goodPriceC.getText()));
				sellshop.setNumber(Integer.valueOf(sellNumC.getText()));
				sellshop.setSellID(sellIDC.getText());
				sellshop.setGoodUnit((String) sellUnitList.getSelectedItem());
				System.out.println(sellshop);
				float money = sellshop.getGoodPrice() * sellshop.getNumber();
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(
						null, "商品总价为 : "+money+"(元)  \n请确认是否售出", "请确认是否售出",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null));

				try {
					shopdao.insetSellShop(sellshop);
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
				sellIDC.setText("XS"+(new Date()).getTime()+"");
			}
		});
	}
}
