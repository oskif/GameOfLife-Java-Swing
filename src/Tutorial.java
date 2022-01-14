import java.awt.*;

public class Tutorial implements Constants{
    GamePanel gp;
    KeyHandler keyH;
    Tutorial(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
    }
    public void draw(Graphics2D g2){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, FONT_SIZE));
        g2.setColor(Color.WHITE);
        String[]line = new String[10];
        line[0] = "Gra game of life toczy sie na plaszczyznie podzielonej na kwadratowe komorki. Każda komórka ma ośmiu";
        line[1] = "„sąsiadów”, a komórki przylegające do niej bokami i rogami. Każda komórka może znajdować się w jednym";
        line[2] = "z dwóch stanów: może być albo „żywa” (włączona),albo „martwa” (wyłączona). Stany komórek zmieniają";
        line[3] = "się w pewnych jednostkach czasu.Stan wszystkich komórek w pewnej jednostce czasu jest używany do";
        line[4] = "obliczenia stanu wszystkich komórek w następnej jednostce. Po obliczeniu wszystkie komórki zmieniają";
        line[5] = "swój stan dokładnie w tym samym momencie. Stan komórki zależy tylko od liczby jej żywych sąsiadów.";
        line[6] = "W grze w życie nie ma graczy w dosłownym tego słowa znaczeniu. Udział człowieka sprowadza się jedynie";
        line[7] = "do ustalenia stanu początkowego komórek";
        line[8] = "";
        line[9] = "Za pomocą lewego przycisku myszy ";
        for(int i = 0; i<7; i++) {
            g2.drawString(line[i], 0, (i+1)*FONT_SIZE*10/8);
        }
    }
}
