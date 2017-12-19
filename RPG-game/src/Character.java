import java.awt.*;

public class Character extends PositionedImage {
  int currentHp;
  int maxHp;
  int defendPoint;
  int strikePoint;
  boolean isAlive;
  int level;

  public Character(String filename, int posX, int posY, boolean isAlive) {
    super(filename, posX, posY);
  }

  public Character() {
  }

  public static int d6() {
    return (int) (1 + Math.random() * 6);
  }




}