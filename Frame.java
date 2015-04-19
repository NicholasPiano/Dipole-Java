import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

  Panel P;

  public Frame (Monopole[] monopoleArray) {

    // bounds and layout
    setBounds(100, 100, 600, 600);
		setBackground(Color.black);
		getContentPane().setLayout(new BorderLayout());

    // panel
    P = new Panel(monopoleArray);
    getContentPane().add(P, BorderLayout.CENTER);


    // exit on close
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void update (Monopole[] M) {
    this.P.update(M);
  }

}

class Panel extends JPanel {

  Monopole[] M;

  public Panel (Monopole[] monopoleArray) {

    // monopoles
    this.M = monopoleArray;

  }

  public void paintComponent (Graphics g) {
    // paint background
    super.paintComponent(g);

    int size = 10;

    // paint monopoles
    g.setColor(Color.white);
    for (Monopole m : this.M) {
      int r = (int)m.getPosition().getArray()[0] - (int)(size/2.0); //account for size of oval
      int c = (int)m.getPosition().getArray()[1] - (int)(size/2.0);
      g.fillOval(r, c, size, size);
    }

  }

  public void update (Monopole[] monopoleArray) {
    setMonopoles(monopoleArray);
    repaint();
  }

  public Dimension getPreferredSize() {
  	setSize(600, 600);
  	return getSize();
  }

  // get and set
  public void setMonopoles (Monopole[] monopoleArray) {
    this.M = monopoleArray;
  }

}
