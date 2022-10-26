import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Gui();
        Font[] fonts;
        fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts( );
        for (int i = 0; i < fonts.length; i++) {
            System.out.print(fonts[i].getFontName( ) + " : ");
            System.out.print(fonts[i].getFamily( ) + " : ");
            System.out.print(fonts[i].getName( ));
            System.out.println( );
        }
    }


}
