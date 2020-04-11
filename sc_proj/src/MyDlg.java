package lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyDlg extends JDialog implements ActionListener {

    AnFrame parent;
    Container cp;
    JLabel headTitle;
    Vocabulary vocas;
    Font myfont = new Font("궁서체",Font.BOLD,30);


    MyDlg(AnFrame frame, String title, boolean modal, int type, Vocabulary v) {
        super(frame, title, modal);
        parent = frame;
        vocas = v;
        init(type);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    void init(int type) {
        cp = this.getContentPane();
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                super.windowClosing(e);
                parent.dlg = null;
                dispose();
            }

        });
        switch (type) {

            case 1: {
                this.setSize(400, 400);
                headTitle = new JLabel("주관식 풀기",SwingConstants.CENTER);
                headTitle.setFont(myfont);

                JPanel proPn = new JPanel();
                proPn.setLayout(new GridLayout(6, 2));
                Voca[] prolist = vocas.getSubjectProblem();
                JLabel engs[] = new JLabel[5];
                JTextField ans[] = new JTextField[5];

                JButton exit = new JButton("채점");
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        int count = 0;
                        for (int i = 0; i < 5; i++) {
                            for (String c : prolist[i].getKoreanVoca()) {
                                if (c.contentEquals(ans[i].getText())) {
                                    count++;
                                    break;
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "맞은 개수 : " + count + " / 5");
                    }

                });

                JButton answer = new JButton("정답보기");
                answer.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        for (int i = 0; i < 5; i++) {
                            ans[i].setText(prolist[i].getKoreanVoca()[0]);
                        }

                    }

                });

                for (int i = 0; i < 5; i++) {
                    engs[i] = new JLabel(prolist[i].getEnglishVoca());
                    ans[i] = new JTextField();
                }
                for (int i = 0; i < 5; i++) {
                    proPn.add(engs[i]);
                    proPn.add(ans[i]);
                }
                proPn.add(exit);
                proPn.add(answer);
                cp.setLayout(new BorderLayout());
                cp.add(headTitle, BorderLayout.NORTH);
                cp.add(proPn, BorderLayout.CENTER);
                break;
            }
            case 2: {

                ObjectProblem[] op = vocas.getObjectProblem();

                this.setSize(800, 400);
                headTitle = new JLabel("객관식 풀기",SwingConstants.CENTER);
                headTitle.setFont(myfont);

                JPanel proPn = new JPanel();
                proPn.setLayout(new GridLayout(6, 2));
                JLabel engs[] = new JLabel[5];
                JRadioButton ans[][] = new JRadioButton[5][4];
                ButtonGroup group[] = new ButtonGroup[5];
                JPanel sel[] = new JPanel[5];

                JButton exit = new JButton("채점");
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        int count = 0;
                        for (int i = 0; i < 5; i++)
                            for (int j = 0; j < 4; j++) {
                                if (ans[i][j].isSelected()) {
                                    if (ans[i][j].getText().contentEquals(op[i].getAnswerKorean())) {
                                        count++;
                                    }
                                    break;
                                }
                            }
                        JOptionPane.showMessageDialog(null, "맞은 개수 : " + count + " / 5");

                    }

                });

                JButton out = new JButton("나가기");
                out.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        parent.dlg = null;
                        dispose();
                    }

                });

                for (int i = 0; i < 5; i++) {
                    group[i] = new ButtonGroup();
                    engs[i] = new JLabel(op[i].getAnswerEnglish());
                    sel[i] = new JPanel();
                    for (int j = 0; j < 4; j++) {
                        ans[i][j] = new JRadioButton(op[i].getExemple()[j].getKoreanVoca()[0]);
                        group[i].add(ans[i][j]);
                        sel[i].add(ans[i][j]);
                    }
                }
                for (int i = 0; i < 5; i++) {
                    proPn.add(engs[i]);
                    proPn.add(sel[i]);
                }
                proPn.add(exit);
                proPn.add(out);
                cp.setLayout(new BorderLayout());
                cp.add(headTitle, BorderLayout.NORTH);
                cp.add(proPn, BorderLayout.CENTER);
                break;

            }

            case 3:{
                this.setSize(500, 200);
                headTitle = new JLabel("빈도순 보기",SwingConstants.CENTER);
                headTitle.setFont(myfont);
                JTextArea ta = new JTextArea();
                ta.setText(vocas.printFrequancyUp());
                cp.setLayout(new BorderLayout());
                cp.add(headTitle, BorderLayout.NORTH);
                cp.add(new JScrollPane(ta), BorderLayout.CENTER);
                break;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
