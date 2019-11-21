package chapter04practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

public class Login extends JFrame {
    private JPanel panel;
    private JLabel nameLabel, pwdLabel;
    private JButton loginButton, registerButton;
    private JTextField nameField;
    private JPasswordField pwdField;
    private RegisterDialog registerDialog;
    private static Vector<Student> students = new Vector<Student>();

    public Login() {
        super("login");
        panel = new JPanel(null);
        nameLabel = new JLabel("name");
        pwdLabel = new JLabel("pwd");
        loginButton = new JButton("login");
        loginButton.addActionListener(new BtnListener());//监听事件
        registerButton = new JButton("register");
        registerButton.addActionListener(new BtnListener());//监听事件
        nameField = new JTextField(16);//设置文本框的长度
        pwdField = new JPasswordField(16);//设置密码框

        registerDialog = new RegisterDialog(this);
        Student student1 = new Student("zhangsan", "123");
        students.add(student1);

        nameLabel.setBounds(30, 30, 60, 25);
        nameField.setBounds(95, 30, 120, 25);
        pwdLabel.setBounds(30, 60, 60, 25);
        pwdField.setBounds(95, 60, 120, 25);
        loginButton.setBounds(30, 90, 80, 25);
        registerButton.setBounds(130, 90, 80, 25);

        panel.add(nameLabel);//把组件添加到面板panel
        panel.add(nameField);
        panel.add(pwdLabel);
        panel.add(pwdField);
        panel.add(loginButton);
        panel.add(registerButton);

        this.add(panel);//实现面板panel
        this.setSize(280, 220);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//设置可见
    }

    class BtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {
                String name = nameField.getText();
                String pwd = pwdField.getText();
                Student student = new Student(name, pwd);
                Boolean b = Boolean.FALSE;
                for (int i = 0; i < students.size(); i++) {
                    if(students.get(i).getName().equals(name)&&students.get(i).getPwd().equals(pwd)){
                        b = !b;
                    }
                }

                if (b) {
                    JOptionPane.showMessageDialog(null, "Login success!");
                } else {
                    JOptionPane.showMessageDialog(null, "username or pwd error!");
                }
            } else {
                registerDialog.setVisible(true);
            }
        }
    }

    public static class RegisterDialog extends JDialog {
        // 声明组件
        private JPanel p;
        private JLabel lblName, lblPwd, lblRePwd, lblMsg;
        // 声明一个文本框
        private JTextField txtName;
        // 声明两个密码框
        private JPasswordField txtPwd, txtRePwd;
        // 声明一个文本域
        private JTextArea txtAddress;
        private JButton btnReg, btnCancel;

        public RegisterDialog(JFrame f) {
            super(f, "Register", true);
            // 创建面板，面板的布局为NULL
            p = new JPanel(null);

            // 实例化5个标签
            lblName = new JLabel("name");
            lblPwd = new JLabel("pwd");
            lblRePwd = new JLabel("confirmPwd");
            // 显示信息的标签
            lblMsg = new JLabel();
            // 设置标签的文字颜色是红色
            lblMsg.setForeground(Color.red);

            // 创建一个长度为20的文本框
            txtName = new JTextField(20);

            // 创建两个密码框，长度20
            txtPwd = new JPasswordField(20);
            txtRePwd = new JPasswordField(20);
            // 设置密码框显示的字符为*
            txtPwd.setEchoChar('*');
            txtRePwd.setEchoChar('*');

            // 创建一个文本域
            txtAddress = new JTextArea(20, 2);

            // 创建两个按钮
            btnReg = new JButton("Register");
            btnCancel = new JButton("Clear");

            // 注册确定按钮的事件处理
            btnReg.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 设置信息标签为空，清空原来历史信息
                    lblMsg.setText("");
                    // 获取用户输入的用户名
                    String strName = txtName.getText();
                    if (strName == null || strName.equals("")) {
                        lblMsg.setText("please input your name!");
                        return;
                    }
                    // 获取用户输入的密码
                    String strPwd = new String(txtPwd.getPassword());
                    if (strPwd == null || strPwd.equals("")) {
                        lblMsg.setText("please input your pwd!");
                        return;
                    }
                    // 获取用户输入的确认密码
                    String strRePwd = new String(txtRePwd.getPassword());
                    if (strRePwd == null || strRePwd.equals("")) {
                        lblMsg.setText("please input your confirmPwd!");
                        return;
                    }
                    // 判断确认密码是否跟密码相同
                    if (!strRePwd.equals(strPwd)) {
                        lblMsg.setText("Pwd != confirmPwd");
                        return;
                    }
                    Student student = new Student(strName, strPwd);
                    students.add(student);
                    lblMsg.setText("register success!");
                }
            });

            // 取消按钮的事件处理
            btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 清空所有文本组件中的文本
                    txtName.setText("");
                    txtPwd.setText("");
                    txtRePwd.setText("");
                    txtAddress.setText("");
                    // 设置信息标签为空
                    lblMsg.setText("");
                }
            });

            // 定位所有组件
            lblName.setBounds(30, 30, 80, 25);
            txtName.setBounds(105, 30, 120, 25);
            lblPwd.setBounds(30, 60, 80, 25);
            txtPwd.setBounds(105, 60, 120, 25);
            lblRePwd.setBounds(30, 90, 80, 25);
            txtRePwd.setBounds(105, 90, 120, 25);
            lblMsg.setBounds(50, 125, 200, 25);
            btnReg.setBounds(60, 155, 80, 25);
            btnCancel.setBounds(145, 155, 80, 25);

            // 将组件添加到面中
            p.add(lblName);
            p.add(txtName);
            p.add(lblPwd);
            p.add(txtPwd);
            p.add(lblRePwd);
            p.add(txtRePwd);
            p.add(lblMsg);
            p.add(btnReg);
            p.add(btnCancel);

            // 将面板添加到窗体中
            this.add(p);

            // 设定窗口大小
            this.setSize(280, 250);
            this.setLocationRelativeTo(this);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Login();//调用login方法
    }
}

