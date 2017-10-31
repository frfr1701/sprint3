package sprint3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Panels {

    private final File winsoundPath = new File("src\\sprint3\\winsound.wav");
    private final File movesoundPath = new File("src\\sprint3\\movesound.wav");
    private final Dimension gamesize = new Dimension(400, 400);
    private final Dimension menusize = new Dimension(400, 50);
    private final Dimension resultsize = new Dimension(400, 50);
    Dimension windowSize = new Dimension(400, 540);
    Dimension location = new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (windowSize.width / 2), (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (windowSize.height / 2));
    JButton[][] buttons = new JButton[4][4];
    JPanel game = new JPanel();
    JPanel menu = new JPanel();
    int[] emptyslot = {3, 3};
    JButton newGame = new JButton("Nytt Spel");
    JButton cancel = new JButton("Avbryt");
    JLabel result = new JLabel("", JLabel.CENTER);

    public Panels() {
        int count = 1;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
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
            }
        }
        newGame.setBackground(Color.BLACK);
        newGame.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        game.setLayout(new GridLayout(4, 4));
        for (JButton[] button : buttons) {
            for (int i = 0; i < buttons[0].length; i++) {
                game.add(button[i]);
            }
        }
        menu.setLayout(new GridLayout(1, 2));
        menu.add(newGame);
        menu.add(cancel);
        game.setPreferredSize(gamesize);
        menu.setPreferredSize(menusize);
        result.setPreferredSize(resultsize);
        result.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    void ifSwitch(ActionEvent ae) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (ae.getSource() == buttons[i][j]) {
                    if (((i - 1 == emptyslot[0] || i + 1 == emptyslot[0]) && j == emptyslot[1]) || ((j - 1 == emptyslot[1] || j + 1 == emptyslot[1]) && i == emptyslot[0])) {
                        movesound();
                        String temp = buttons[i][j].getText();
                        buttons[i][j].setText(buttons[emptyslot[0]][emptyslot[1]].getText());
                        buttons[i][j].setBackground(Color.WHITE);
                        buttons[emptyslot[0]][emptyslot[1]].setText(temp);
                        buttons[emptyslot[0]][emptyslot[1]].setBackground(Color.BLACK);
                        emptyslot[0] = i;
                        emptyslot[1] = j;
                    }
                }
            }
        }
    }

    boolean win() {
        return buttons[0][0].getText().equalsIgnoreCase("1") && buttons[0][1].getText().equalsIgnoreCase("2") && buttons[0][2].getText().equalsIgnoreCase("3")
                && buttons[0][3].getText().equalsIgnoreCase("4") && buttons[1][0].getText().equalsIgnoreCase("5") && buttons[1][1].getText().equalsIgnoreCase("6")
                && buttons[1][2].getText().equalsIgnoreCase("7") && buttons[1][3].getText().equalsIgnoreCase("8") && buttons[2][0].getText().equalsIgnoreCase("9")
                && buttons[2][1].getText().equalsIgnoreCase("10") && buttons[2][2].getText().equalsIgnoreCase("11") && buttons[2][3].getText().equalsIgnoreCase("12")
                && buttons[3][0].getText().equalsIgnoreCase("13") && buttons[3][1].getText().equalsIgnoreCase("14") && buttons[3][2].getText().equalsIgnoreCase("15");

    }
    
    private void movesound() {
        if (movesoundPath.exists()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(movesoundPath));
                clip.start();
            } catch (LineUnavailableException e) {
                System.out.println("null!");
            } catch (IOException e) {
                System.out.println("filen hittas inte!");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("filen stöds inte!");
            }
        }
    }

    void winsound() {
        if (winsoundPath.exists()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(winsoundPath));
                clip.start();
            } catch (LineUnavailableException e) {
                System.out.println("null!");
            } catch (IOException e) {
                System.out.println("filen hittas inte!");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("filen stöds inte!");
            }
        }
    }
}
