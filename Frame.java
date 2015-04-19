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

    // paint monopoles
    for (Monopole m : this.M) {

    }

  }

  public void update (Monopole[] monopoleArray) {

  }

  public Dimension getPreferredSize() {
  	setSize(600, 600);
  	return getSize();
  }

}
