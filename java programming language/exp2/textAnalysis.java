/**
 * textAnalysis.java -- Text Analysis
 *
 * Written on ������, 23 ���� 2016.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

public class textAnalysis {
  public static int getWordCount(String s) {
    int ret = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        if (i == 0) {
          ret++;
        } else {
          char prev_ch = s.charAt(i - 1);
          if ((prev_ch < 'a' || prev_ch > 'z')
              && (prev_ch < 'A' || prev_ch > 'Z'))
            ret++;
        }
      }
    }
    return ret;
  }
  public static void main(String[] args) {
    // ����frame���⣬Ĭ�ϴ�С
    JFrame frame = new JFrame("Text Analysis");
    frame.setSize(300, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // ��frame�Ĳ��ֹ�������ΪGridBagLayout������һ��
    Container pane = frame.getContentPane();
    pane.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    c.weightx = 1.0;  // ���������������ӣ�x����Ŀհ�����ȫ�����
    c.fill = GridBagConstraints.BOTH; // ����ÿ�������ڲ�������Ѹ��ӿռ�ȫ��ռ��
    c.ipady = 40;

    // �����м�����lbl_btn_back�����Ϸ���label��button
    Panel lbl_btn_back = new Panel();
    lbl_btn_back.setLayout(new GridLayout(1, 2));
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 1;
    pane.add(lbl_btn_back, c);

    // ���ù��û�������ı���
    JTextArea text = new JTextArea();
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.gridwidth = 2;
    pane.add(text, c);
    
    // ���ñ�ǩ�ĳ�ʼ���ݣ�������lbl_btn_back��
    JLabel label = new JLabel("<html>������0<br>��������0<br>�ַ�����0</html>");
    lbl_btn_back.add(label);

    // ���ð�ť�ĳ�ʼ���ݣ�������lbl_btn_back��
    JButton button = new JButton("ͳ������");
    lbl_btn_back.add(button);

    // �󶨰�ť�¼������û������ťʱ����label����
    button.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            label.setText("<html>������" + text.getLineCount() + "<br>��������" + getWordCount(text.getText()) + "<br>�ַ�����" + text.getText().length() + "</html>");
          }
        });

    // ��ʾ����
    frame.setVisible(true);
  }
}
