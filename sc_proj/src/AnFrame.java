package lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnFrame extends JFrame {

    Container cp;
    JPanel mainPanel;
    JLabel mainHead;

    JButton mainBtn[] = new JButton[4];
    JPanel btnP = new JPanel();
    Font myfont = new Font("궁서체",Font.BOLD,30);

    Vocabulary vocas =new Vocabulary("words.txt");

    AnFrame pass = this;

    MyDlg dlg = null;

    AnFrame(){
        this.setTitle("201911190 안재민");
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

        this.setVisible(true);
    }

    void init() {
        cp = this.getContentPane();
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        setBotPanel();

        mainHead = new JLabel("Vocabulary Game",SwingConstants.CENTER);
        mainHead.setSize(new Dimension(600,200));
        mainHead.setFont(myfont);
        mainHead.setHorizontalAlignment(JLabel.CENTER);
        mainHead.setBackground(Color.WHITE);

        cp.setLayout(new BorderLayout());

        cp.add(mainHead,BorderLayout.NORTH);
        cp.add(mainPanel,BorderLayout.CENTER);
    }

    void setBotPanel() {

        mainBtn = new JButton[4];
        mainBtn[0] = new JButton("주관식 풀기");
        mainBtn[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(dlg == null)
                    dlg = new MyDlg(pass,"주관식",false,1,vocas);
                else
                    dlg.requestFocus();
            }

        });
        mainBtn[1] = new JButton("객관식 풀기");
        mainBtn[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(dlg == null)
                    dlg = new MyDlg(pass,"주관식",false,2,vocas);
                else
                    dlg.requestFocus();
            }

        });
        mainBtn[2] = new JButton("단어장");
        mainBtn[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(dlg == null)
                    dlg = new MyDlg(pass,"주관식",false,3,vocas);
                else
                    dlg.requestFocus();
            }

        });
        mainBtn[3] = new JButton("게임 종료");
        mainBtn[3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

        });


        btnP = new JPanel();
        btnP.setLayout(new GridLayout(7,1));
        btnP.setBackground(Color.WHITE);

        for(int i=0;i<4;i++)
            mainBtn[i].setBackground(Color.WHITE);

        btnP.add(mainBtn[0]);
        btnP.add(new JPanel());
        btnP.add(mainBtn[1]);
        btnP.add(new JPanel());
        btnP.add(mainBtn[2]);
        btnP.add(new JPanel());
        btnP.add(mainBtn[3]);

        mainPanel.setLayout(new GridLayout(1,3));
        mainPanel.add(new JPanel());
        mainPanel.add(btnP);
        mainPanel.add(new JPanel());

    }




}
