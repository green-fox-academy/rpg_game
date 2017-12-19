import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

  int testBoxX;
  int testBoxY;
  GameTable tempTable;
  Character dasd;
  static Hero theHero;

  public Board() {
    this.testBoxX = 0;
    this.testBoxY = 0;
    theHero = new Hero(0,0);


    // set the size of your draw board
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    this.tempTable.TableDrawer(graphics);
    this.dasd.draw(graphics);

   // graphics.fillRect(testBoxX, testBoxY, 100, 100);
    // here you have a 720x720 canvas
    // you can create and draw an image using the class below e.g.

       // PositionedImage image = new PositionedImage("/Users/quoctungnguyen/Desktop/RPG-game/src/floor.png", i*72, j*72);
       // image.draw(graphics);



    }



  public static void main(String[] args) {
    // Here is how you set up a new window and adding our board to it
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    // Here is how you can add a key event listener
    // The board object will be notified when hitting any key
    // with the system calling one of the below 3 methods
    frame.addKeyListener(board);
    // Notice (at the top) that we can only do this
    // because this Board class (the type of the board object) is also a KeyListener
    int[][] tableX = {
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 0, 0, 0}
    };
    GameTable table = new GameTable(tableX, 720);
    board.tempTable =table;


    board.dasd = theHero;
  }

  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box

    if (e.getKeyCode() == KeyEvent.VK_UP) {
      theHero.moving(0, -72);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      theHero.moving(0, +72);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      theHero.moving(-72, 0);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      theHero.moving(+72, 0);
      // and redraw to have a new picture with the new coordinates

    }
    repaint();
  }
}