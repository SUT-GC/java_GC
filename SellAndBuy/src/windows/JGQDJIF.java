package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.model.ShopDao;
import com.shop.BuyShop;
import com.shop.SellShop;

public class JGQDJIF extends JInternalFrame {
	private Object[] columnTitle = new Object[] { "进货单号", "商品编号", "商品名称",
			"进货价格", "进货数量", "商品单位", "进货时间", "生产厂商" };
	private String[][] test = new String[][] { { "null", "null", "null",
			"null", "null", "null", "null", "null" } };
	private JTable table;
	private JButton selectButton = new JButton("查询");
	private JButton selectAllButton = new JButton("显示全部数据");
	private JLabel sellIDL = new JLabel("进货单号 ");
	private JTextField sellIDC = new JTextField(15);
	private JLabel goodIDL = new JLabel("商品编号 ");
	private JTextField goodIDC = new JTextField(15);
	private JCheckBox isSelectByDate = new JCheckBox("指定查询日期", false);
	private JLabel from = new JLabel("从");
	private JLabel to = new JLabel("到");
	private JTextField fromC = new JTextField(14);
	private JTextField toC = new JTextField(14);
	private DefaultTableModel model;
	private JButton updateButton = new JButton("修改此条记录");
	private JButton delButton = new JButton("删除此条记录");
	private ShopDao shopdao = new ShopDao();

	public JGQDJIF() {
		this.setTitle("查询进购清单界面");
		this.setResizable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		JPanel selectQuery1 = new JPanel();
		selectQuery1.add(sellIDL);
		selectQuery1.add(sellIDC);
		selectQuery1.add(goodIDL);
		selectQuery1.add(goodIDC);
		JPanel selectQuery2 = new JPanel();
		selectQuery2.add(isSelectByDate);
		selectQuery2.add(from);
		selectQuery2.add(fromC);
		selectQuery2.add(to);
		selectQuery2.add(toC);
		JPanel boxYSelectQuery = new JPanel();
		boxYSelectQuery.setLayout(new BoxLayout(boxYSelectQuery,
				BoxLayout.Y_AXIS));
		boxYSelectQuery.add(selectQuery1);
		boxYSelectQuery.add(selectQuery2);
		JPanel boxYButtons = new JPanel();
		boxYButtons.setLayout(new BoxLayout(boxYButtons, BoxLayout.Y_AXIS));
		boxYButtons.add(selectButton);
		boxYButtons.add(selectAllButton);
		JPanel selectXAll = new JPanel();
		selectXAll.add(boxYSelectQuery);
		selectXAll.add(boxYButtons, BorderLayout.EAST);
		this.add(selectXAll, BorderLayout.NORTH);
		model = new DefaultTableModel(test, columnTitle);
		table = new JTable(model);
		JScrollPane tableScrollPanel = new JScrollPane(table);
		this.add(tableScrollPanel);
		Box updateBox = new Box(BoxLayout.X_AXIS);
		updateBox
				.add(new JLabel(
						"-------------------------------------------------------------------------------------"
						+ "----------------------------------------------------------------------------------"
						+ "------------------------------------------------------------------------"));
		// updateBox.add(updateButton);
		// updateBox.add(delButton);
		this.add(updateBox, BorderLayout.SOUTH);
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = model.getRowCount();
				for (int i = 0; i < count; i++) {
					model.removeRow(0);
				}
				Vector<BuyShop> v = new Vector<BuyShop>();
				try {
					if (!isSelectByDate.isSelected()) {
						v = shopdao.selectBuyShop(sellIDC.getText(),
								goodIDC.getText());
						String[] s = new String[8];
						int i = 0;
						for (BuyShop ss : v) {
							s[0] = ss.getBuyID();
							s[1] = ss.getGoodNum();
							s[2] = ss.getGoodName() + "";
							s[3] = ss.getPrice() + "";
							s[4] = ss.getNumber() + "";
							s[5] = ss.getGoodUnit() + "";
							s[6] = ss.getBuyDate() + "";
							s[7] = ss.getBusinessName() + "";
							model.addRow(s);
						}
					} else {
						String[] datefs = (fromC.getText() + "").split("-");
						String[] datets = (toC.getText() + "").split("-");
						if (datefs.length == 3 && datets.length == 3) {
							Date from = new Date(
									Integer.valueOf(datefs[0]) - 1900, Integer
											.valueOf(datefs[1]) - 1, Integer
											.valueOf(datefs[2]) - 0);
							Date to = new Date(
									Integer.valueOf(datets[0]) - 1900, Integer
											.valueOf(datets[1]) - 1, Integer
											.valueOf(datets[2]) - 0);
							v = shopdao.selectBuyShopUesDate(from, to);
							String[] s = new String[8];
							int i = 0;
							for (BuyShop ss : v) {
								s[0] = ss.getBuyID();
								s[1] = ss.getGoodNum();
								s[2] = ss.getGoodName() + "";
								s[3] = ss.getPrice() + "";
								s[4] = ss.getNumber() + "";
								s[5] = ss.getGoodUnit() + "";
								s[6] = ss.getBuyDate() + "";
								s[7] = ss.getBusinessName() + "";
								model.addRow(s);
							}
						} else {
							JOptionPane.showConfirmDialog(null, "输入信息有误,执行失败",
									"输入信息有误,执行失败", JOptionPane.OK_OPTION,
									JOptionPane.WARNING_MESSAGE, null);
						}
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		selectAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = model.getRowCount();
				Vector<BuyShop> v = new Vector<BuyShop>();
				for (int i = 0; i < count; i++) {
					model.removeRow(0);
				}
				try {
					v = shopdao.selectBuyShop("", "");
					String[] s = new String[8];
					int i = 0;
					for (BuyShop ss : v) {
						s[0] = ss.getBuyID();
						s[1] = ss.getGoodNum();
						s[2] = ss.getGoodName() + "";
						s[3] = ss.getPrice() + "";
						s[4] = ss.getNumber() + "";
						s[5] = ss.getGoodUnit() + "";
						s[6] = ss.getBuyDate() + "";
						s[7] = ss.getBusinessName() + "";
						model.addRow(s);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
