package sprint3;

import java.util.Random;

class Shuffle {

    Panels make(Panels panels) {
        Random random = new Random();
        for (int changes = 100000; changes > 0; changes--) {
            boolean done = false;
            while (!done) {
                int randomdirection = random.nextInt(4) + 1;
                switch (randomdirection) {
                    case 1:
                        if (0 < panels.getEmptySlot()[0]) {
                            panels.changeBlankRow(-1);
                            done = true;
                        }
                        break;
                    case 2:
                        if (3 > panels.getEmptySlot()[0]) {
                            panels.changeBlankRow(1);
                            done = true;
                        }
                        break;
                    case 3:
                        if (0 < panels.getEmptySlot()[1]) {
                            panels.changeBlankColumn(-1);
                            done = true;
                        }
                        break;
                    case 4:
                        if (3 > panels.getEmptySlot()[1]) {
                            panels.changeBlankColumn(1);
                            done = true;
                        }
                        break;
                }
            }
        }
        return panels;
    }
}
