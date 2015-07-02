package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.model.ShopDao;
import com.shop.ShopInformation;

public class CXSPKC extends JInternalFrame {
	private Object[] columnTitle = new Object[] { "商品编号", "商品名称", "商品售价",
			"库存数量", "商品单位" };
	private String[][] test = new String[][] { { "null", "null", "null",
			"null", "null" } };
	private JTable table;
	private JButton selectButton = new JButton("查询");
	private JButton selectAllButton = new JButton("显示全部数据");
	private JLabel selectQueryL = new JLabel("选择查询条件");
	private Vector<String> keHuVector = new Vector<>();
	private Vector<String> conditionVector = new Vector<String>();
	private JComboBox<String> keHu;
	private JComboBox<String> condition;
	private JTextField content = new JTextField(20);
	// private JCheckBox isSelectByDate = new JCheckBox("指定查询日期", false);
	// private JLabel from = new JLabel("从");
	// private JLabel to = new JLabel("到");
	// private JTextField fromC = new JTextField(14);
	// private JTextField toC = new JTextField(14);
	private DefaultTableModel model;
	private JButton updateUsrAndPass = new JButton("修改用户名或密码");
	private JButton updateButton = new JButton("修改此条记录");
	private JButton delButton = new JButton("删除此条记录");
	private ShopDao shopdao = new ShopDao();

	public CXSPKC() {
		this.setTitle("查询商品库存界面");
		this.setResizable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		keHuVector.add("商品编号");
		keHuVector.add("商品全称");
		keHu = new JComboBox<String>(keHuVector);
		conditionVector.add("等于");
		conditionVector.add("包含");
		condition = new JComboBox<String>(conditionVector);
		JPanel selectQuery1 = new JPanel();
		selectQuery1.add(selectQueryL);
		selectQuery1.add(keHu);
		selectQuery1.add(condition);
		selectQuery1.add(content);
		// JPanel selectQuery2 = new JPanel();
		// selectQuery2.add(isSelectByDate);
		// selectQuery2.add(from);
		// selectQuery2.add(fromC);
		// selectQuery2.add(to);
		// selectQuery2.add(toC);
		JPanel boxYSelectQuery = new JPanel();
		boxYSelectQuery.setLayout(new BoxLayout(boxYSelectQuery,
				BoxLayout.Y_AXIS));
		boxYSelectQuery.add(selectQuery1);
		// boxYSelectQuery.add(selectQuery2);
		JPanel boxYButtons = new JPanel();
		boxYButtons.setLayout(new BoxLayout(boxYButtons, BoxLayout.Y_AXIS));
		boxYButtons.add(selectButton);
		boxYButtons.add(selectAllButton);
		JPanel selectYAll = new JPanel();
		selectYAll.add(boxYSelectQuery);
		selectYAll.add(boxYButtons, BorderLayout.EAST);
		this.add(selectYAll, BorderLayout.NORTH);
		model = new DefaultTableModel(test, columnTitle);
		table = new JTable(model);
		JScrollPane tableScrollPanel = new JScrollPane(table);
		this.add(tableScrollPanel);
		Box updateBox = new Box(BoxLayout.X_AXIS);
		updateBox
				.add(new JLabel(
						"------------------------------------------------------------"));
		updateBox.add(updateUsrAndPass);
		updateBox.add(updateButton);
		updateBox.add(delButton);
		updateBox
				.add(new JLabel(
						"---------------------------------------------------------------"));
		this.add(updateBox, BorderLayout.SOUTH);
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(keHu.getSelectedItem() + "");
				System.out.println(condition.getSelectedItem() + " ");
				int count = model.getRowCount();
				Vector<ShopInformation> v = new Vector<>();
				for (int i = 0; i < count; i++) {
					model.removeRow(0);
				}
				if ((keHu.getSelectedItem() + "").equals("商品编号")
						&& (condition.getSelectedItem() + "").equals("等于")) {
					try {
						v = shopdao.selectSI(content.getText() + "", "");
						String[] s = new String[5];
						int i = 0;
						for (ShopInformation ss : v) {
							s[0] = ss.getGoodID();
							s[1] = ss.getGoodName();
							s[2] = ss.getGoodPrice() + "";
							s[3] = ss.getGoodNum() + "";
							s[4] = ss.getGoodUnit() + "";
							model.addRow(s);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if ((keHu.getSelectedItem() + "").equals("商品全称")
						&& (condition.getSelectedItem() + "").equals("等于")) {
					try {
						v = shopdao.selectSI("", content.getText() + "");
						String[] s = new String[5];
						int i = 0;
						for (ShopInformation ss : v) {
							s[0] = ss.getGoodID();
							s[1] = ss.getGoodName();
							s[2] = ss.getGoodPrice() + "";
							s[3] = ss.getGoodNum() + "";
							s[4] = ss.getGoodUnit() + "";
							model.addRow(s);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if((keHu.getSelectedItem() + "").equals("商品编号")
						&& (condition.getSelectedItem() + "").equals("包含")){
					try {
						v = shopdao.selectSILikeID(content.getText());
						String[] s = new String[5];
						int i = 0;
						for (ShopInformation ss : v) {
							s[0] = ss.getGoodID();
							s[1] = ss.getGoodName();
							s[2] = ss.getGoodPrice() + "";
							s[3] = ss.getGoodNum() + "";
							s[4] = ss.getGoodUnit() + "";
							model.addRow(s);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else if((keHu.getSelectedItem() + "").equals("商品全称")
						&& (condition.getSelectedItem() + "").equals("包含")){
					try {
						v = shopdao.selectSILikeName(content.getText());
						String[] s = new String[5];
						int i = 0;
						for (ShopInformation ss : v) {
							s[0] = ss.getGoodID();
							s[1] = ss.getGoodName();
							s[2] = ss.getGoodPrice() + "";
							s[3] = ss.getGoodNum() + "";
							s[4] = ss.getGoodUnit() + "";
							model.addRow(s);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		selectAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = model.getRowCount();
				Vector<ShopInformation> v = new Vector<>();
				for (int i = 0; i < count; i++) {
					model.removeRow(0);
				}
				try {
					v = shopdao.selectSI("", "");
					String[] s = new String[5];
					int i = 0;
					for (ShopInformation ss : v) {
						s[0] = ss.getGoodID();
						s[1] = ss.getGoodName();
						s[2] = ss.getGoodPrice() + "";
						s[3] = ss.getGoodNum() + "";
						s[4] = ss.getGoodUnit() + "";
						model.addRow(s);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		updateUsrAndPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel newadmin = new JPanel();
				JTextField newusr = new JTextField(10);
				JTextField newpass = new JTextField(10);
				newadmin.add(new JLabel("新用户名 : "));
				newadmin.add(newusr);
				newadmin.add(new JLabel("新密码 : "));
				newadmin.add(newpass);
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(
						null, newadmin, "请输入新的用户名及密码	",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null)) {
					if (newusr.getText().equals("")
							|| newpass.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "新用户名或密码格式不正确",
								"新用户名或密码格式不正确", JOptionPane.WARNING_MESSAGE,
								null);
					} else {
						Win.admin.setUSR(newusr.getText());
						Win.admin.setPASS(newpass.getText());
						JOptionPane.showMessageDialog(null, "修改成功", "修改成功",
								JOptionPane.WARNING_MESSAGE, null);
					}
				}
			}
		});
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table.getSelectedRow();
				int ifDel = JOptionPane.showConfirmDialog(null,
						"您确定要删除本行数据么? ", "您确定要删除本行数据么? ",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null);
				if (ifDel == JOptionPane.OK_OPTION) {
					try {
						shopdao.delShopIN((String) model.getValueAt(selectRow,
								0));
						JOptionPane.showConfirmDialog(null, "删除成功 ! ",
								"删除成功 ! ", JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null);
						selectAllButton.doClick();
					} catch (SQLException e1) {
						JOptionPane.showConfirmDialog(null, "删除失败 ! ",
								"删除失败 ! ", JOptionPane.OK_OPTION,
								JOptionPane.WARNING_MESSAGE, null);
					}
				}
			}
		});
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectRow = table.getSelectedRow();
				JTextField goodID = new JTextField(15);
				goodID.setText((String) model.getValueAt(selectRow, 0));
				JTextField goodName = new JTextField(15);
				goodName.setText((String) model.getValueAt(selectRow, 1));
				JTextField goodPrice = new JTextField(12);
				goodPrice.setText((String) model.getValueAt(selectRow, 2));
				JTextField goodNum = new JTextField(15);
				goodNum.setText((String) model.getValueAt(selectRow, 3));
				String[] GoodUtils = new String[] { "个", "斤", "盒", "袋" };
				JLabel GoodUtilL = new JLabel("(元) 单位");
				JComboBox<String> GoodUtil = new JComboBox<String>(GoodUtils);
				JLabel goodIDL = new JLabel("商品编号");
				JLabel goodNameL = new JLabel("商品名称");
				JLabel goodPriceL = new JLabel("商品价格");
				JLabel goodNumL = new JLabel("商品数量");
				JPanel all = new JPanel();
				all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
				all.add(goodIDL);
				all.add(goodID);
				all.add(goodNameL);
				all.add(goodName);
				all.add(goodNumL);
				all.add(goodNum);
				JPanel pu = new JPanel();
				pu.add(goodPriceL);
				pu.add(goodPrice);
				pu.add(GoodUtilL);
				pu.add(GoodUtil);
				all.add(pu);
				int ifok = JOptionPane.showConfirmDialog(null, all,
						"请重新输入该记录信息", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null);
				if (ifok == JOptionPane.OK_OPTION) {
					ShopInformation s = new ShopInformation();
					s.setGoodID(goodID.getText());
					s.setGoodName(goodName.getText());
					s.setGoodNum(Integer.valueOf(goodNum.getText()));
					s.setGoodPrice(Float.valueOf(goodPrice.getText()));
					s.setGoodUnit((String) GoodUtil.getSelectedItem());
					System.out.println(s);
					try {
						shopdao.delShopIN((String) model.getValueAt(selectRow,
								0));
						shopdao.insetShopIn(s);
						selectAllButton.doClick();
						JOptionPane.showConfirmDialog(null, "修改成功 ! ",
								"修改成功 ! ", JOptionPane.OK_OPTION,
								JOptionPane.PLAIN_MESSAGE, null);
					} catch (SQLException e1) {
						JOptionPane.showConfirmDialog(null, "修改失败 ! ",
								"修改失败 ! ", JOptionPane.OK_OPTION,
								JOptionPane.WARNING_MESSAGE, null);
					}
				}
			}
		});
	}
}
