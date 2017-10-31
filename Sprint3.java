package sprint3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Sprint3 extends JFrame {

    Panels panels = new Panels();
    boolean active = true;

    Sprint3() {
        panels = Shuffle.make(panels);

        class MyListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (active) {
                    panels.ifSwitch(ae);
                    if (panels.win()) {
                        panels.winsound();
                        panels.result.setText("Grattis, du vann!");
                        active = false;
                    }
                }
                if (ae.getSource() == panels.newGame) {
                    panels.result.setText("");
                    active = true;
                    panels = Shuffle.make(panels);
                }
                if (ae.getSource() == panels.cancel) {
                    System.exit(0);
                }   
            }
        }
        MyListener listen = new MyListener();
        panels.newGame.addActionListener(listen);
        panels.cancel.addActionListener(listen);
        for (JButton[] button : panels.buttons) {
            for (int i = 0; i < panels.buttons[0].length; i++) {
                button[i].addActionListener(listen);
            }
        }
    }

    void program() {
        add(panels.game);
        add(panels.result);
        add(panels.menu);
        pack();
        setLayout(new FlowLayout());
        setTitle("Slide Puzzle by Fredrik | Java17 Nackademin");
        setSize(panels.windowSize);
        setLocation(panels.location.width, panels.location.height);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Sprint3 start = new Sprint3();
        start.program();
    }
}
