import java.awt.*;

public class GameTable {
  int[][] table;
  int width;

  public GameTable(int[][] table, int width) {
    this.table = table;
    this.width = width;

  }

  public void TableDrawer(Graphics graphics){
    for (int i = 0; i <this.table.length ; i++) {
      for (int j = 0; j <this.table.length ; j++) {
        if (this.table[i][j] == 1) {
          PositionedImage wall = new PositionedImage("/Users/quoctungnguyen/Desktop/RPG-game/src/wall.png", j*72, i*72);
          wall.draw(graphics);
        } else if (this.table[i][j]==0) {
          PositionedImage path = new PositionedImage("/Users/quoctungnguyen/Desktop/RPG-game/src/floor.png", j * 72, i * 72);
          path.draw(graphics);
        }

      }

    }

  }
}
