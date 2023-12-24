import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;

    // 控件
    private JPanel contPanel; // Login窗口面板容器
    private JButton LoginBtn; // 登录按钮
    private JTextField Edit_Name; // 名称
    private JTextField Edit_Address;// IP地址
    private JTextField Edit_Port; // 端口号

    // 构造函数
    public Login() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 420);
        setLocationRelativeTo(null);
        contPanel = new JPanel();
        contPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contPanel.setLayout(null);
        setContentPane(contPanel);
        InitWindow();
    }

    // 初始化窗口
    private void InitWindow() {
        // 设置字体
        Font customFont = new Font("Consolas", Font.PLAIN, 12);

        // 名称
        JLabel Label_Name = new JLabel("Name:");
        Label_Name.setBounds(127, 34, 45, 16);
        Label_Name.setFont(customFont);
        contPanel.add(Label_Name);
        Edit_Name = new JTextField();
        Edit_Name.setBounds(67, 50, 165, 28);
        Edit_Name.setFont(customFont);
        contPanel.add(Edit_Name);
        Edit_Name.setColumns(10);

        // IP地址
        JLabel Label_Address = new JLabel("IP Address:");
        Label_Address.setBounds(111, 96, 80, 16);
        Label_Address.setFont(customFont);
        contPanel.add(Label_Address);
        Edit_Address = new JTextField();
        Edit_Address.setBounds(67, 116, 165, 28);
        Edit_Address.setFont(customFont);
        contPanel.add(Edit_Address);
        Edit_Address.setColumns(10);
        JLabel Label_AddressDesc = new JLabel("(eg. 192.168.0.2)");
        Label_AddressDesc.setBounds(90, 145, 120, 16);
        Label_AddressDesc.setFont(customFont);
        contPanel.add(Label_AddressDesc);

        // 端口号
        JLabel Label_Port = new JLabel("Port:");
        Label_Port.setBounds(133, 171, 40, 16);
        Label_Port.setFont(customFont);
        contPanel.add(Label_Port);
        Edit_Port = new JTextField();
        Edit_Port.setBounds(67, 191, 165, 28);
        Edit_Port.setFont(customFont);
        contPanel.add(Edit_Port);
        Edit_Port.setColumns(10);
        JLabel Label_PortDesc = new JLabel("(eg. 8088)");
        Label_PortDesc.setBounds(110, 222, 75, 16);
        Label_PortDesc.setFont(customFont);
        contPanel.add(Label_PortDesc);
        Edit_Port.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    String SName = Edit_Name.getText();
                    String SAddress = Edit_Address.getText();
                    int iPort = Integer.parseInt(Edit_Port.getText());
                    login(SName, SAddress, iPort);
                }
            }
        });

        // Login Button
        LoginBtn = new JButton("Log in");
        LoginBtn.setBounds(91, 300, 117, 29);
        LoginBtn.setFont(customFont);
        contPanel.add(LoginBtn);
        LoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String SName = Edit_Name.getText();
                String SAddress = Edit_Address.getText();
                int iPort = Integer.parseInt(Edit_Port.getText());
                login(SName, SAddress, iPort);
            }
        });
    }

    // Login Button触发事件
    private void login(String SName, String SAddress, int iPort) {
        // 关闭Login窗口
        dispose();
        // 弹出Client窗口
        new Client(SName, SAddress, iPort);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frameLogin = new Login();
                    frameLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
