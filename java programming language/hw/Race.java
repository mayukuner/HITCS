/**
 * Race.java -- The Race Between Hare and Tortoise
 *
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

class Runner extends JLabel {
  private int when_to_stop,  // ֹͣʱ��clocksֵ
    stop_time_length,        // ֹͣ��ʱ�䳤��
    px_in_one_step,          // ÿ50ms��x��������������أ�
    clocks,                  // ��¼���߳����п�ʼ��ʱ�䣨t / 50ms)
    yc;                      // ��label��y����
  private ImageIcon img_run, // ����ʱ��ImageIcon
    img_stop;                // ͣ����Ϣʱ��ImageIcon
  public Runner(int _when_to_stop,
                int _stop_time_length,
                int _px_in_one_step,
                int _yc,
                ImageIcon _img_run,
                ImageIcon _img_stop) {
    when_to_stop = _when_to_stop;
    stop_time_length = _stop_time_length;
    px_in_one_step = _px_in_one_step;
    yc = _yc;
    img_run = _img_run;
    img_stop = _img_stop;
  }
  public void init() {
    setSize(70, 70);    // ����label��С
    setLocation(0, yc); // ���ó�ʼλ��
    setIcon(img_run);   // ����ͼƬ
    clocks = 0;          
  }
  public void go() {
    clocks++;
    if (clocks <= 400 / px_in_one_step + stop_time_length  // û��Խ���յ���
        && (clocks < when_to_stop                          
            || clocks > when_to_stop + stop_time_length)) {  // û����Ϣ��ʱ��
      setLocation(getX() + px_in_one_step, yc);
      setIcon(img_run);
    } else {
      setIcon(img_stop);
    } 
  }
}

class RaceThread implements Runnable {
  
  Thread hare, tortoise, thread_draw_line;

  JFrame frame;
  Container pane;
  Runner runner_hare, runner_tortoise;
  
  public void init() {
    hare = new Thread(this);
    tortoise = new Thread(this);
    thread_draw_line = new Thread(this);

    // ��frame���л�������
    frame = new JFrame("The Race Between The Hare and The Tortoise");
    pane = frame.getContentPane();
    pane.setBackground(Color.white);

    // ��ʼ������label
    runner_hare = new Runner(50, 300, 3, 50, 
                             new ImageIcon(
                                 new ImageIcon("run_hare.jpg")
                                 .getImage()
                                 .getScaledInstance(70, 70, Image.SCALE_SMOOTH)),
                             new ImageIcon(
                                 new ImageIcon("stop_hare.jpg")
                                 .getImage()
                                 .getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
    // ��ʼ���ڹ�label
    runner_tortoise = new Runner(50, 4, 1, 200, 
                             new ImageIcon(
                                 new ImageIcon("run_tortoise.jpg")
                                 .getImage()
                                 .getScaledInstance(70, 70, Image.SCALE_SMOOTH)),
                             new ImageIcon(
                                 new ImageIcon("stop_tortoise.jpg")
                                 .getImage()
                                 .getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

  }
  
  public void start() {
    
    frame.setSize(500,350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    pane.setLayout(null);
    pane.add(runner_hare);
    pane.add(runner_tortoise);

    runner_hare.init();
    runner_tortoise.init();
    
    frame.setVisible(true);

    // �߳̿�ʼ����
    hare.start();
    tortoise.start();
    thread_draw_line.start();
  }

  public void run() {
    while (true) {
      if (Thread.currentThread() == thread_draw_line) {  // ���յ���
        Graphics g = frame.getGraphics();
        g.setColor(Color.BLACK);
        g.drawLine(450, 5, 450, 345);
        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else if (Thread.currentThread() == hare) {  // ������
        runner_hare.go();
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        runner_tortoise.go();
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {  // ���ڹ�
          e.printStackTrace();
        }
      }
    }
  }
}

public class Race {
  static RaceThread thread;
  public static void main(String[] args) {
    thread = new RaceThread();
    thread.init();
    thread.start();
  }
}
