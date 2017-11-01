package sprint3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

final class Panels {

    private final Dimension gamesize = new Dimension(400, 400);
    private final Dimension menusize = new Dimension(400, 50);
    private final Dimension resultsize = new Dimension(400, 50);
    private final JPanel game = new JPanel();
    private final JPanel menu = new JPanel();
    private final JLabel result = new JLabel("", JLabel.CENTER);
    private final JButton newGame = new JButton("Nytt Spel");
    private final JButton cancel = new JButton("Avbryt");
    private final Dimension windowSize = new Dimension(400, 540);
    private final Dimension location = new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (windowSize.width / 2), (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (windowSize.height / 2));
    private final JButton[][] buttons = new JButton[4][4];
    private final int[] emptyslot = {3, 3};
    private final Sound make = new Sound();

    Panels() {
        int count = 1;
        for (int i = 0; i < getRowLength(); i++) {
            for (int j = 0; j < getColumnLength(); j++) {
                if (i == 3 && j == 3) {
                    buttons[i][j] = new JButton("    ");
                    buttons[i][j].setBackground(Color.WHITE);
                } else {
                    String slot = "" + (count);
                    buttons[i][j] = new JButton(slot);
                    buttons[i][j].setBackground(Color.BLACK);
                    count++;
                }
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                game.add(buttons[i][j]);
            }
        }
        newGame.setBackground(Color.BLACK);
        newGame.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        game.setLayout(new GridLayout(4, 4));
        menu.setLayout(new GridLayout(1, 2));
        menu.add(newGame);
        menu.add(cancel);
        game.setPreferredSize(gamesize);
        menu.setPreferredSize(menusize);
        result.setPreferredSize(resultsize);
        result.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    void ifSwitch(ActionEvent ae) {
        for (int i = 0; i < getRowLength(); i++) {
            for (int j = 0; j < getColumnLength(); j++) {
                if (ae.getSource() == buttons[i][j]) {
                    if (((i - 1 == emptyslot[0] || i + 1 == emptyslot[0]) && j == emptyslot[1]) || ((j - 1 == emptyslot[1] || j + 1 == emptyslot[1]) && i == emptyslot[0])) {
                        make.movesound();
                        swapButtons(i, j);
                    }
                }
            }
        }
    }

    void swapButtons(int i, int j) {
        String temp = buttons[i][j].getText();
        buttons[i][j].setText(buttons[emptyslot[0]][emptyslot[1]].getText());
        buttons[i][j].setBackground(Color.WHITE);
        buttons[emptyslot[0]][emptyslot[1]].setText(temp);
        buttons[emptyslot[0]][emptyslot[1]].setBackground(Color.BLACK);
        emptyslot[0] = i;
        emptyslot[1] = j;
    }

    boolean win() {
        return buttons[0][0].getText().equalsIgnoreCase("1") && buttons[0][1].getText().equalsIgnoreCase("2") && buttons[0][2].getText().equalsIgnoreCase("3")
                && buttons[0][3].getText().equalsIgnoreCase("4") && buttons[1][0].getText().equalsIgnoreCase("5") && buttons[1][1].getText().equalsIgnoreCase("6")
                && buttons[1][2].getText().equalsIgnoreCase("7") && buttons[1][3].getText().equalsIgnoreCase("8") && buttons[2][0].getText().equalsIgnoreCase("9")
                && buttons[2][1].getText().equalsIgnoreCase("10") && buttons[2][2].getText().equalsIgnoreCase("11") && buttons[2][3].getText().equalsIgnoreCase("12")
                && buttons[3][0].getText().equalsIgnoreCase("13") && buttons[3][1].getText().equalsIgnoreCase("14") && buttons[3][2].getText().equalsIgnoreCase("15");

    }

    void changeResultText(String message) {
        result.setText(message);
    }

    void changeBlankRow(int change) {
        String tempS = buttons[emptyslot[0]][emptyslot[1]].getText();
        Color tempC = buttons[emptyslot[0]][emptyslot[1]].getBackground();
        buttons[emptyslot[0]][emptyslot[1]].setText(buttons[emptyslot[0] + change][emptyslot[1]].getText());
        buttons[emptyslot[0]][emptyslot[1]].setBackground(buttons[emptyslot[0] + change][emptyslot[1]].getBackground());
        buttons[emptyslot[0] + change][emptyslot[1]].setText(tempS);
        buttons[emptyslot[0] + change][emptyslot[1]].setBackground(tempC);
        emptyslot[0] += change;
    }

    void changeBlankColumn(int change) {
        String tempS = buttons[emptyslot[0]][emptyslot[1]].getText();
        Color tempC = buttons[emptyslot[0]][emptyslot[1]].getBackground();
        buttons[emptyslot[0]][emptyslot[1]].setText(buttons[emptyslot[0]][emptyslot[1] + change].getText());
        buttons[emptyslot[0]][emptyslot[1]].setBackground(buttons[emptyslot[0]][emptyslot[1] + change].getBackground());
        buttons[emptyslot[0]][emptyslot[1] + change].setText(tempS);
        buttons[emptyslot[0]][emptyslot[1] + change].setBackground(tempC);
        emptyslot[1] += change;
    }

    JButton getButton(int i, int j) {
        return buttons[i][j];
    }

    int[] getEmptySlot() {
        return emptyslot;
    }

    int getRowLength() {
        return buttons.length;
    }

    int getColumnLength() {
        return buttons[0].length;
    }

    JPanel getGame() {
        return game;
    }

    JPanel getMenu() {
        return menu;
    }

    JLabel getResult() {
        return result;
    }

    JButton getNewGame() {
        return newGame;
    }

    JButton getCancel() {
        return cancel;
    }

    Dimension getWindowSize() {
        return windowSize;
    }

    int getLocationWidth() {
        return location.width;
    }

    int getLocationHeight() {
        return location.height;
    }

    void makeWinSound() {
        make.winsound();
    }
}
