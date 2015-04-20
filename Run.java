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
    M = randomMonopoleArray(300);

    // frame
    F = new Frame(M);

  }

  public static Monopole[] randomMonopoleArray (int count) {

    Random r = new Random();

    Monopole[] M = new Monopole[count];

    // generate random coordinates
    for (int i=0; i<count; i++) {
      M[i] = new Monopole(i, r.nextInt(300)+150, r.nextInt(300)+150, /*r.nextDouble()*2.0f - */1.0f);
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

    double timestep = 0.01;
    Vector centre = new Vector(300,300);
    double maxSpeed = 0;

    // loop through monopoles twice and update the positions
    for (Monopole i : this.M) {

      Vector acceleration = new Vector(0,0);
      double currentRadius = Vector.distance(i.getPosition(), centre);

      // loop over second monopole
      for (Monopole j : this.M) {
        if (i.getId()!=j.getId()) {

          // unit vector joining I and J
          Vector unitItoJ = Vector.sub(i.getPosition(), j.getPosition()); unitItoJ.unit();

          // force
          double force = j.getCharge() * Math.pow(timestep, 1.0 / Math.abs(i.getId()-j.getId())) / Math.pow(Vector.distance(i.getPosition(), j.getPosition()), 2);
          unitItoJ.scalarMult(force);

          // acceleration
          acceleration = Vector.add(acceleration, unitItoJ);

        }
      }

      // find vector perpendicular to radial
      Vector radial = Vector.sub(i.getPosition(), centre);
      Vector perpendicular = new Vector(1, -radial.getArray()[0] / radial.getArray()[1]); // solve from dot product
      perpendicular.unit();
      double pdp = Vector.dot(perpendicular, perpendicular);
      double pm = perpendicular.getMagnitude();

      // set velocity
      perpendicular.scalarMult(Vector.dot(Vector.add(i.getVelocity(), acceleration), perpendicular) / (pdp * pm));
      i.setVelocity(perpendicular);
      maxSpeed = maxSpeed > i.getVelocity().getMagnitude() ? maxSpeed : i.getVelocity().getMagnitude();

      // set position
      Vector newPosition = Vector.add(i.getPosition(), i.getVelocity());
      double radius = Vector.distance(newPosition, centre);
      double ratio = currentRadius / radius;
      newPosition.scalarMult(ratio);

      // newPosition.boundaryConditions(600,600);
      i.setPosition(newPosition);

    }

    // update frame with new monopoles
    this.F.update(this.M, maxSpeed / this.M.length);
  }

}
