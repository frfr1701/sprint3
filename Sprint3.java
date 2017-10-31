package sprint3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Sprint3 extends JFrame {

    Panels panels = new Panels();
    Shuffle shuffle = new Shuffle();
    boolean active = true;

    Sprint3() {
        panels = shuffle.make(panels);

        class MyListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (active) {
                    panels.ifSwitch(ae);
                    if (panels.win()) {
                        panels.makeWinSound();
                        panels.changeResultText("Grattis, du vann!");
                        active = false;
                    }
                }
                if (ae.getSource() == panels.getNewGame()) {
                    panels.changeResultText("");
                    active = true;
                    panels = shuffle.make(panels);
                }
                if (ae.getSource() == panels.getCancel()) {
                    System.exit(0);
                }   
            }
        }
        MyListener listen = new MyListener();
        panels.getNewGame().addActionListener(listen);
        panels.getCancel().addActionListener(listen);
        for (int i = 0; i < panels.getRowLength(); i++) {
            for (int j = 0; j < panels.getColumnLength(); j++) {
                panels.getButton(i, j).addActionListener(listen);
            }
        }
    }

    void program() {
        add(panels.getGame());
        add(panels.getResult());
        add(panels.getMenu());
        pack();
        setLayout(new FlowLayout());
        setTitle("Slide Puzzle by Fredrik | Java17 Nackademin");
        setSize(panels.getWindowSize());
        setLocation(panels.getLocationWidth(), panels.getLocationHeight());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Sprint3 start = new Sprint3();
        start.program();
    }
}
