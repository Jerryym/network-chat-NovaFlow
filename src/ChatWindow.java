import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/*
 * 聊天窗口
 */
public class ChatWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    // 控件
    private JPanel contPanel; // Login窗口面板容器
    private JTextArea txtRecord;// 聊天对话文本
    private JTextField txtInputfField;// 输入框
    private JButton sendButton;// 发送按钮

    private String m_SName;// 用户名
    private String m_SAddress;// IP地址
    private int m_iPort;// 端口号

    // 构造函数
    public ChatWindow(String SName, String SAddress, int iPort) {
        this.m_SName = SName;
        this.m_SAddress = SAddress;
        this.m_iPort = iPort;

        // 初始化窗口
        InitWindow();
        console("Sucessfully Connected!");
    }

    // 初始化窗口
    private void InitWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 窗口基本属性设置
        setTitle("Nest Chat Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 550);
        setLocationRelativeTo(null);
        contPanel = new JPanel();
        contPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contPanel);

        // 网格布局
        GridBagLayout gridbag = new GridBagLayout();
        gridbag.columnWidths = new int[] { 28, 815, 30, 7 };// Sum == 880，即列宽总和等于窗口总宽
        gridbag.rowHeights = new int[] { 25, 485, 40 };// Sum == 550，即行高总和等于窗口总长
        gridbag.columnWeights = new double[] { 1.0, 1.0 };
        gridbag.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
        contPanel.setLayout(gridbag);

        // 聊天对话文本
        txtRecord = new JTextArea();
        txtRecord.setEditable(false);
        GridBagConstraints gbc_txtRecord = new GridBagConstraints();
        gbc_txtRecord.insets = new Insets(0, 5, 0, 0);
        gbc_txtRecord.fill = GridBagConstraints.BOTH;
        gbc_txtRecord.gridx = 1;
        gbc_txtRecord.gridy = 1;
        gbc_txtRecord.gridwidth = 2;
        contPanel.add(txtRecord, gbc_txtRecord);

        // 输入框
        txtInputfField = new JTextField();
        txtInputfField.setColumns(10);
        GridBagConstraints gbc_txtInput = new GridBagConstraints();
        gbc_txtInput.insets = new Insets(0, 0, 0, 5);
        gbc_txtInput.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtInput.gridx = 1;
        gbc_txtInput.gridy = 2;
        contPanel.add(txtInputfField, gbc_txtInput);
        txtInputfField.requestFocusInWindow();// 设置输入框为默认焦点

        // 发送按钮
        sendButton = new JButton("Send");
        GridBagConstraints gbc_sendBtn = new GridBagConstraints();
        gbc_sendBtn.insets = new Insets(0, 0, 0, 5);
        gbc_sendBtn.gridx = 2;
        gbc_sendBtn.gridy = 2;
        contPanel.add(sendButton, gbc_sendBtn);

        setVisible((true));
    }

    public void console(String SMsg) {
        txtRecord.append(SMsg + "\n\r");
    }
}
