// import
import java.util.Random;
import java.lang.Math;

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
    M = randomMonopoleArray(100);

    // frame
    F = new Frame(M);

  }

  public static Monopole[] randomMonopoleArray (int count) {

    Random r = new Random();

    Monopole[] M = new Monopole[count];

    // generate random coordinates
    for (int i=0; i<count; i++) {
      M[i] = new Monopole(i, r.nextInt(600), r.nextInt(600), /*r.nextDouble()*2.0f - */1.0f);
    }

    return M;

  }

  public void run () {

    F.pack();
    F.setVisible(true);

    // infinite loop for simulation
    while (true) {
      this.update();
    }

  }

  public void update () {

    double timestep = 0.001;

    // loop through monopoles twice and update the positions
    for (Monopole i : this.M) {

      Vector acceleration = new Vector(0,0);

      // loop over second monopole
      for (Monopole j : this.M) {
        if (i.getId()!=j.getId()) {

          // unit vector joining I and J
          Vector unitItoJ = Vector.sub(i.getPosition(), j.getPosition()); unitItoJ.unit();

          // force
          double force = j.getCharge() * timestep / Math.pow(Vector.distance(i.getPosition(), j.getPosition()), 2);
          unitItoJ.scalarMult(force);

          // acceleration
          acceleration = Vector.add(acceleration, unitItoJ);

        }
      }

      // set velocity
      Vector newVelocity = Vector.add(i.getVelocity(), acceleration);
      i.setVelocity(newVelocity);

      // set position
      Vector newPosition = Vector.add(i.getPosition(), newVelocity);
      newPosition.boundaryConditions(600,600);
      i.setPosition(newPosition);

    }

    // update frame with new monopoles
    this.F.update(this.M);
  }

}
