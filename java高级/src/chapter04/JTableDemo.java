package chapter04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class JTableDemo extends JFrame {
    // 声明滚动面板
    private JScrollPane spTable;
    // 声明一个盛放按钮的面板
    private JPanel pButtons;
    private JButton bthDelete, btnFlush;
    // 声明默认表格模式
    private DefaultTableModel model;
    // 声明表格
    private JTable table;

	ArrayList<Student> studentArr = new ArrayList<Student>(3);


    public JTableDemo() {
        super("用户表");

		studentArr.add(new Student(0, "张三", "male"));
		studentArr.add(new Student(1, "李四", "male"));
		studentArr.add(new Student(2, "王红", "female"));

        // 创建默认表格模式
        model = new DefaultTableModel();
        // 创建表格
        table = new JTable(model);
        // 设置表格选择模式为单一选择
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 创建一个滚动面板，包含表格
        spTable = new JScrollPane(table);
        // 将滚动面板添加到窗体中央
        this.add(spTable, BorderLayout.CENTER);

        // 创建按钮
        bthDelete = new JButton("删除");
        btnFlush = new JButton("刷新");
        // 创建面板
        pButtons = new JPanel();
        // 将按钮添加到面板中
        pButtons.add(bthDelete);
        pButtons.add(btnFlush);
        // 将盛放按钮的面板添加到窗体的南部（下面）
        this.add(pButtons, BorderLayout.SOUTH);

        // 注册监听
        bthDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用删除数据的方法
                deleteData();
            }
        });
        btnFlush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 调用显示数据的方法
                showData();
            }
        });

        // 初始化显示表格数据
        this.showData();

        // 设定窗口大小
        this.setSize(500, 400);
        // 设定窗口左上角坐标（X轴200像素，Y轴100像素）
        this.setLocation(200, 100);
        // 设定窗口默认关闭方式为退出应用程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口可视（显示）
        this.setVisible(true);
    }

    // 查看userdetails表，并显示到表格中
    private void showData() {
        try {
            Vector<String> title = new Vector<String>();
            title.add("id");
            title.add("name");
            title.add("sex");

            // 表格数据
            Vector<Vector<String>> data = new Vector<Vector<String>>();

            for (int i = 0; i < studentArr.size(); i++) {
                Vector<String> rowdata = new Vector<String>();
                rowdata.add(String.valueOf(studentArr.get(i).getId()));
                rowdata.add(studentArr.get(i).getName());
                rowdata.add(studentArr.get(i).getSex());
                data.add(rowdata);
            }
            if (studentArr.size() == 0) {
                model.setDataVector(null, title);
            } else {
                model.setDataVector(data, title);
            }
        } catch (Exception ee) {
            System.out.println(ee.toString());
            JOptionPane.showMessageDialog(this, "系统出现异常错误。请检查数据库。系统即将退出！！！",
                    "错误", 0);
        }
    }

    // 删除数据
    public void deleteData() {
        int index[] = table.getSelectedRows();
        if (index.length == 0) {
            JOptionPane.showMessageDialog(this, "请选择要删除的记录", "提示",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            try {
                int k = JOptionPane.showConfirmDialog(this,
                        "您确定要从数据库中删除所选的数据吗 ？", "删除", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (k == JOptionPane.YES_OPTION) {
                    try {

                        String id = table.getValueAt(index[0], 0).toString();

						studentArr.remove(Integer.parseInt(id));
                        JOptionPane.showMessageDialog(this, "删除操作成功完成!",
                                "成功", JOptionPane.PLAIN_MESSAGE);
                        showData();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(this, "抱歉!删除数据失败!【系统异常！】", "失败:",
                        0);
            }
        }
    }

    public class Student {
        private int id;
        private String name;
        private String sex;

        public Student(int id, String name, String sex) {
            this.id = id;
            this.name = name;
            this.sex = sex;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public static void main(String[] args) {
        new JTableDemo();
    }
}
