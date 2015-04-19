// import


public class Run {

  // main
  public static void main (String[] args) {

    // make new run and run it
    Run R = new Run();
    R.run();

  }

  // class
  Frame F;
  Monopole[] M;

  public Run () {

    // monopoles
    M = randomMonopoleArray(1);

    // frame
    F = new Frame(M);

  }

  public static Monopole[] randomMonopoleArray (int count) {

    Monopole[] M = new Monopole[count];

    // generate random coordinates

    return M;

  }

  public void run () {

    F.pack();
    F.setVisible(true);

  }

}
