package sprint3;

import java.awt.Color;
import java.util.Random;

public class Shuffle {

    static Panels make(Panels panels) {
        for (int changes = 100000; changes > 0; changes--) {
            boolean done = false;
            Random random = new Random();
            while (!done) {
                int randomdirection = random.nextInt(4) + 1;
                String tempS = panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].getText();
                Color tempC = panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].getBackground();
                switch (randomdirection) {
                    case 1:
                        if (0 < panels.emptyslot[0]) {
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setText(panels.buttons[panels.emptyslot[0] - 1][panels.emptyslot[1]].getText());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setBackground(panels.buttons[panels.emptyslot[0] - 1][panels.emptyslot[1]].getBackground());
                            panels.buttons[panels.emptyslot[0] - 1][panels.emptyslot[1]].setText(tempS);
                            panels.buttons[panels.emptyslot[0] - 1][panels.emptyslot[1]].setBackground(tempC);
                            panels.emptyslot[0] -= 1;
                            done = true;
                        }
                        break;
                    case 2:
                        if (3 > panels.emptyslot[0]) {
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setText(panels.buttons[panels.emptyslot[0] + 1][panels.emptyslot[1]].getText());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setBackground(panels.buttons[panels.emptyslot[0] + 1][panels.emptyslot[1]].getBackground());
                            panels.buttons[panels.emptyslot[0] + 1][panels.emptyslot[1]].setText(tempS);
                            panels.buttons[panels.emptyslot[0] + 1][panels.emptyslot[1]].setBackground(tempC);
                            panels.emptyslot[0] += 1;
                            done = true;
                        }
                        break;
                    case 3:
                        if (0 < panels.emptyslot[1]) {
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setText(panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] - 1].getText());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setBackground(panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] - 1].getBackground());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] - 1].setText(tempS);
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] - 1].setBackground(tempC);
                            panels.emptyslot[1] -= 1;
                            done = true;
                        }
                        break;
                    case 4:
                        if (3 > panels.emptyslot[1]) {
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setText(panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] + 1].getText());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1]].setBackground(panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] + 1].getBackground());
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] + 1].setText(tempS);
                            panels.buttons[panels.emptyslot[0]][panels.emptyslot[1] + 1].setBackground(tempC);
                            panels.emptyslot[1] += 1;
                            done = true;
                        }
                        break;
                }
            }
        }
        return panels;
    }
}
