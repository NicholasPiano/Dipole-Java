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

  public void update (Monopole[] M, double maxSpeed) {
    this.P.update(M, maxSpeed);
  }

}

class Panel extends JPanel {

  Monopole[] M;
  double ms;

  public Panel (Monopole[] monopoleArray) {

    // monopoles
    this.M = monopoleArray;

  }

  public void paintComponent (Graphics g) {
    // paint background
    super.paintComponent(g);

    int size = 10;

    // paint monopoles
    for (Monopole m : this.M) {
      int r = (int)m.getPosition().getArray()[0] - (int)(size/2.0); //account for size of oval
      int c = (int)m.getPosition().getArray()[1] - (int)(size/2.0);
      double v = m.getVelocity().getMagnitude();
      g.setColor(Color.getHSBColor(1.0f, 1.0f, (float)(v/this.ms)));
      g.fillOval(r, c, size, size);
    }

  }

  public void update (Monopole[] monopoleArray, double maxSpeed) {
    setMonopoles(monopoleArray);
    setMS(maxSpeed);
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

  public void setMS (double maxSpeed) {
    this.ms = maxSpeed > this.ms ? maxSpeed : this.ms;
  }

}
