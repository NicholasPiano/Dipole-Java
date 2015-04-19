// import things


// class
public class Monopole {

  public int id; // unique id
  public Vector position, velocity;
  public double charge;

  // constructor
  public Monopole(int monopoleId, int row, int column, double monopoleCharge) {
    id = monopoleId;
    position = new Vector(row, column);
    velocity = new Vector(0, 0);
    charge = monopoleCharge;
  }

  // methods
  public int getId () {
    return this.id;
  }

  public Vector getPosition () {
    return this.position;
  }

  public void setPosition (Vector newPosition) {
    this.position = newPosition;
  }

  public Vector getVelocity () {
    return this.velocity;
  }

  public void setVelocity (Vector newVelocity) {
    this.velocity = newVelocity;
  }

  public double getCharge () {
    return this.charge;
  }

}
