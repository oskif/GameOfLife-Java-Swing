import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//public class Main extends JPanel implements Constants {
//    public static void main(String[] args) {
//        start();
//    }
//
//    public static void start() {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame frame = new JFrame(GameRendering.class.getSimpleName());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                final GameRendering gameRenderer = new GameRendering();
//                frame.add(gameRenderer);
//                frame.pack();
//                frame.setVisible(true);
//                // Dummy timer that reduces the lives every second. For demo purposes only of course
//                Timer t = new Timer(TIMER, new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        gameRenderer.nextFrame();
//                    }
//                });
//                t.start();
//            }
//
//        });
//    }
//}

public class Main implements Constants {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game Of Life");

        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamepanel.startGameThread();
    }
}