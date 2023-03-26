package tictactoy;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Tictactoy extends JFrame {

    JButton[][] toy = new JButton[3][3];
    int[][] xvalue = new int[3][3]; //storing which position 2 for system 1 for user 
    int ii = 0, jj = 0;//take the first toy user entered 
    int random1 = 0, random2 = 0; //sore random number generated from Math class
    static JFrame frame;

    Tictactoy() {
        JPanel p1 = new JPanel(new GridLayout(3, 3, 3, 3));
        p1.setBorder(new LineBorder(Color.CYAN, 10));
        p1.setBackground(Color.CYAN);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j] = new JButton("");
                toy[i][j].setBackground(new Color(10, 110, 91));
                toy[i][j].setFont(new Font("Serif", Font.BOLD, 100));
                toy[i][j].setForeground(Color.WHITE);
                p1.add(toy[i][j]);
            }
        }
        add(p1);

        ToyListener listener = new ToyListener();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j].addActionListener(listener);
            }
        }
    }

    class ToyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = "X";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (toy[i][j] == e.getSource()) {
                        //used for detecting if a button not to be pressed more than one 
                        //if it pressed,it will return without changing the button
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                if (xvalue[i][j] == 1 || xvalue[i][j] == 2) {
                                    return;
                                }
                            }
                        }
                        ii = i;
                        jj = j;
                        xvalue[i][j] = 1;
                        toy[i][j].setText("x");
                        toy[i][j].setForeground(Color.PINK);

                        if ((xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 1) || (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 1) || (xvalue[2][0] == 1 && xvalue[2][1] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 1) || (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 1) || (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 1) || (xvalue[0][2] == 1 && xvalue[1][1] == 1 && xvalue[2][0] == 1)) {
                            JOptionPane.showMessageDialog(null, "you win !!");
                            restartTicTac();
                        } else if ((xvalue[0][0] == 2 && xvalue[0][1] == 2 && xvalue[0][2] == 2) || (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2) || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                            JOptionPane.showMessageDialog(null, "you Loss !!");
                            restartTicTac();
                        }
                        defence();
                        if ((xvalue[0][0] == 1 && xvalue[0][1] == 1 && xvalue[0][2] == 1) || (xvalue[1][0] == 1 && xvalue[1][1] == 1 && xvalue[1][2] == 1) || (xvalue[2][0] == 1 && xvalue[2][1] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][0] == 1 && xvalue[2][0] == 1) || (xvalue[0][1] == 1 && xvalue[1][1] == 1 && xvalue[2][1] == 1) || (xvalue[0][2] == 1 && xvalue[1][2] == 1 && xvalue[2][2] == 1)
                                || (xvalue[0][0] == 1 && xvalue[1][1] == 1 && xvalue[2][2] == 1) || (xvalue[0][2] == 1 && xvalue[1][1] == 1 && xvalue[2][0] == 1)) {
                            JOptionPane.showMessageDialog(null, "you win !!");
                            restartTicTac();
                        } else if ((xvalue[0][0] == 2 && xvalue[0][1] == 2 && xvalue[0][2] == 2) || (xvalue[1][0] == 2 && xvalue[1][1] == 2 && xvalue[1][2] == 2) || (xvalue[2][0] == 2 && xvalue[2][1] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][0] == 2 && xvalue[2][0] == 2) || (xvalue[0][1] == 2 && xvalue[1][1] == 2 && xvalue[2][1] == 2) || (xvalue[0][2] == 2 && xvalue[1][2] == 2 && xvalue[2][2] == 2)
                                || (xvalue[0][0] == 2 && xvalue[1][1] == 2 && xvalue[2][2] == 2) || (xvalue[0][2] == 2 && xvalue[1][1] == 2 && xvalue[2][0] == 2)) {
                            JOptionPane.showMessageDialog(null, "you Loss !!");
                            restartTicTac();
                        }
                        int counter = 0;
                        for (int m = 0; m < 3; m++) {
                            for (int n = 0; n < 3; n++) {
                                if (xvalue[m][n] != 0) {
                                    counter++;
                                }
                            }
                        }
                        if (counter == 9) {
                            JOptionPane.showMessageDialog(null, "try again");
                            restartTicTac();
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        frame = new Tictactoy();

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void defence() {

        // prefix w stands for win
        int wrow = 0, wcol = 0;
        int wdiagonal = 0;
        boolean tv = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xvalue[i][j] == 2) {
                    wrow++;
                }
                if (xvalue[j][i] == 2) {
                    wcol++;
                }
                if (xvalue[i][j] == 2 && i == j) {
                    wdiagonal++;
                }
            }

            if (wcol > 1) {
                for (int k = 0; k < 3; k++) {
                    if (xvalue[k][i] == 0) {
                        xvalue[k][i] = 2;
                        toy[k][i].setText("O");
                        tv = false;
                    }
                }
            } else if (wrow > 1) {
                for (int k = 0; k < 3; k++) {
                    if (xvalue[i][k] == 0) {
                        xvalue[i][k] = 2;
                        toy[i][k].setText("O");
                        tv = false;
                    }
                }
            } else if (wdiagonal > 1) {
                for (int k = 0; k < 3; k++) {
                    if (xvalue[k][k] == 0) {
                        xvalue[k][k] = 2;
                        toy[k][k].setText("O");
                        tv = false;
                    }
                }
            } else if (xvalue[2][0] == 0 && xvalue[0][2] == 2 && xvalue[1][1] == 2) {
                xvalue[2][0] = 2;
                toy[2][0].setText("O");
                tv = false;
            } else if (xvalue[2][0] == 2 && xvalue[0][2] == 0 && xvalue[1][1] == 2) {
                xvalue[0][2] = 2;
                toy[0][2].setText("O");
                tv = false;
            } else if (xvalue[2][0] == 2 && xvalue[0][2] == 2 && xvalue[1][1] == 0) {
                xvalue[1][1] = 2;
                toy[1][1].setText("O");
                tv = false;
            }

            wcol = 0;
            wrow = 0;
        }

        int row = 0, col = 0;
        int diagonal = 0;

        if (tv) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (xvalue[i][j] == 1) {
                        row++;
                    }
                    if (xvalue[j][i] == 1) {
                        col++;
                    }

                    if (xvalue[i][j] == 1 && i == j) {
                        diagonal++;
                    }
                }
                if (xvalue[2][0] == 0 && xvalue[0][2] == 1 && xvalue[1][1] == 1) {
                    xvalue[2][0] = 2;
                    toy[2][0].setText("O");
                    tv = false;
                } else if (xvalue[2][0] == 1 && xvalue[0][2] == 0 && xvalue[1][1] == 1) {
                    xvalue[0][2] = 2;
                    toy[0][2].setText("O");
                    tv = false;
                } else if (xvalue[2][0] == 1 && xvalue[0][2] == 1 && xvalue[1][1] == 0) {
                    xvalue[1][1] = 2;
                    toy[1][1].setText("O");
                    tv = false;
                } else if (diagonal > 1) {
                    for (int k = 0; k < 3; k++) {
                        if (xvalue[k][k] == 0) {
                            xvalue[k][k] = 2;
                            toy[k][k].setText("O");
                            tv = false;
                        }
                    }
                } else if (col > 1) {
                    for (int k = 0; k < 3; k++) {
                        if (xvalue[k][i] == 0) {
                            xvalue[k][i] = 2;
                            toy[k][i].setText("O");
                            tv = false;
                        }
                    }
                } else if (row > 1) {
                    for (int k = 0; k < 3; k++) {
                        if (xvalue[i][k] == 0) {
                            xvalue[i][k] = 2;
                            toy[i][k].setText("O");
                            tv = false;
                        }
                    }
                }

                col = 0;
                row = 0;
            }
        }
        if (tv) {
            getElse();
        }
    }

    void getElse() {

        int counter = 0;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (xvalue[m][n] != 0) {
                    counter++;
                }
            }
        }
        if (counter == 9) {
            JOptionPane.showMessageDialog(null, "try again");
            restartTicTac();
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xvalue[i][j] == 2) {
                    for (int k = 0; k < 3; k++) {
                        if (xvalue[i][k] == 0) {
                            xvalue[i][k] = 2;
                            toy[i][k].setText("O");
                            return;
                        }
                        if (xvalue[k][i] == 0) {
                            xvalue[k][i] = 2;
                            toy[k][i].setText("O");
                            return;
                        }
                    }
                }
            }
            if (i == 2) {
                int row, col;

                while (true) {
                    row = (int) (Math.random() * 3);
                    col = (int) (Math.random() * 3);

                    if (xvalue[row][col] == 0) {
                        xvalue[row][col] = 2;
                        toy[row][col].setText("O");
                        break;
                    } else if (xvalue[col][row] == 0) {
                        xvalue[col][row] = 2;
                        toy[col][row].setText("O");
                        break;
                    }
                }
            }
        }
    }

    //used for clearing the frame
    void restartTicTac() {

        ii = 0;
        jj = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                toy[i][j].setText("");
                toy[i][j].setBackground(new Color(10, 110, 91));
                toy[i][j].setFont(new Font("Serif", Font.BOLD, 100));
                toy[i][j].setForeground(Color.WHITE);
                xvalue[i][j] = 0;
            }
        }
    }
}
