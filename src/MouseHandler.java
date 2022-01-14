import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
    public boolean mousePressed;
    public int mouseX, mouseY;

    @Override
    public void mousePressed(MouseEvent e) {
        mouseY = (int) e.getPoint().getX();
        mouseX = (int) e.getPoint().getY();
        mousePressed = true;
    }

    public void mouseDragged(MouseEvent e) {
        mouseY = (int) e.getPoint().getX();
        mouseX = (int) e.getPoint().getY();

    }

    public void mouseReleased(MouseEvent e) {
        //mousePressed = false;
    }


}
