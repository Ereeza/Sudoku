import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Controller implements KeyListener {
    JTextField Fusha[][] = new JTextField[9][9];
    private int Zgjidhja[][] = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {3, 1, 2, 8, 4, 5, 9, 6, 7},
            {6, 9, 7, 3, 1, 2, 8, 4, 5},
            {8, 4, 5, 6, 9, 7, 3, 1, 2},
            {2, 3, 1, 5, 7, 4, 6, 9, 8},
            {9, 6, 8, 2, 3, 1, 5, 7, 4},
            {5, 7, 4, 9, 6, 8, 2, 3, 1}
    };
    public void controller() {
        JFrame Korniza = new JFrame(); //Krijimi i nje objekti JFrame
        Korniza.setLayout(new GridLayout(9, 9));
        Font Fonti = new Font("Monospaced", Font.BOLD, 30);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField fusha = new JTextField();
                Korniza.add(fusha);
                fusha.addKeyListener(this);
                fusha.setFocusable(true);
                Fusha[i][j] = fusha;
                fusha.setFont(Fonti);
                fusha.setHorizontalAlignment(JTextField.CENTER);
                if (((i < 3 || i > 5) && (j < 3 || j > 5))) {
                    Fusha[i][j].setBackground(Color.CYAN);
                } else if ((i > 2 && i < 6) && (j > 2 && j < 6)) {
                    Fusha[i][j].setBackground(Color.CYAN);
                } else {
                    Fusha[i][j].setBackground(Color.LIGHT_GRAY);
                }
            }
        }



        Fusha[1][0].setText("7");
        Fusha[1][0].setForeground(Color.BLUE);
        Fusha[1][0].setEditable(false);
        Fusha[1][5].setText("3");
        Fusha[1][5].setForeground(Color.BLUE);
        Fusha[1][5].setEditable(false);
        Fusha[1][6].setText("4");
        Fusha[1][6].setForeground(Color.BLUE);
        Fusha[1][6].setEditable(false);

        Fusha[2][1].setText("5");
        Fusha[2][1].setForeground(Color.BLUE);
        Fusha[2][1].setEditable(false);
        Fusha[2][3].setText("7");
        Fusha[2][3].setForeground(Color.BLUE);
        Fusha[2][3].setEditable(false);
        Fusha[2][6].setText("1");
        Fusha[2][6].setForeground(Color.BLUE);
        Fusha[2][6].setEditable(false);

        Fusha[3][2].setText("2");
        Fusha[3][2].setForeground(Color.BLUE);
        Fusha[3][2].setEditable(false);
        Fusha[3][3].setText("8");
        Fusha[3][3].setForeground(Color.BLUE);
        Fusha[3][3].setEditable(false);
        Fusha[3][7].setText("6");
        Fusha[3][7].setForeground(Color.BLUE);
        Fusha[3][7].setEditable(false);

        Fusha[4][7].setText("4");
        Fusha[4][7].setForeground(Color.BLUE);
        Fusha[4][7].setEditable(false);
        Fusha[4][8].setText("5");
        Fusha[4][8].setForeground(Color.BLUE);
        Fusha[4][8].setEditable(false);

        Fusha[5][1].setText("4");
        Fusha[5][1].setForeground(Color.BLUE);
        Fusha[5][1].setEditable(false);
        Fusha[5][3].setText("6");
        Fusha[5][3].setForeground(Color.BLUE);
        Fusha[5][3].setEditable(false);
        Fusha[5][6].setText("3");
        Fusha[5][6].setForeground(Color.BLUE);
        Fusha[5][6].setEditable(false);

        Fusha[6][1].setText("3");
        Fusha[6][1].setForeground(Color.BLUE);
        Fusha[6][1].setEditable(false);
        Fusha[6][5].setText("4");
        Fusha[6][5].setForeground(Color.BLUE);
        Fusha[6][5].setEditable(false);

        Fusha[7][1].setText("6");
        Fusha[7][1].setForeground(Color.BLUE);
        Fusha[7][1].setEditable(false);
        Fusha[7][5].setText("1");
        Fusha[7][5].setForeground(Color.BLUE);
        Fusha[7][5].setEditable(false);
        Fusha[7][6].setText("5");
        Fusha[7][6].setForeground(Color.BLUE);
        Fusha[7][6].setEditable(false);

        Fusha[8][2].setText("4");
        Fusha[8][2].setForeground(Color.BLUE);
        Fusha[8][2].setEditable(false);
        Fusha[8][5].setText("8");
        Fusha[8][5].setForeground(Color.BLUE);
        Fusha[8][5].setEditable(false);
        Fusha[8][6].setText("2");
        Fusha[8][6].setForeground(Color.BLUE);
        Fusha[8][6].setEditable(false);
        Fusha[8][8].setText("1");
        Fusha[8][8].setForeground(Color.BLUE);
        Fusha[8][8].setEditable(false);


        Korniza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Korniza.setSize(400, 400);
        Korniza.setTitle("Sudoku Game");

        Korniza.setVisible(true);

    }

    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    int[][] winnerArray = new int[9][9];
    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String a = Fusha[i][j].getText().trim();
                int result;
                try{
                    result = Integer.parseInt(a);
                }catch(NumberFormatException ex){
                    result = -1;
                }
                winnerArray[i][j] = result;
                if (equal()){
                    JOptionPane.showMessageDialog(null, "Ju keni zgjidhur sudokun me sukses!");
                }

            }
        }
    }
    public boolean equal() {
        boolean[] a = new boolean[9];
        for (int i = 0; i < Zgjidhja.length; i++) {
            if (Arrays.equals(Zgjidhja[i], winnerArray[i])) {
                a[i] = true;
                for (int j = 0; j < a.length; j++) {
                    if (!a[i]){
                        break;
                    }else if(i < (a.length -1)){
                        continue;
                    }else{
                        return true;
                    }
                }
            }
        }

        return false;
    }
}