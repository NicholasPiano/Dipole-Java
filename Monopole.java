// import things


// class
public class Monopole {

  public int id; // unique id
  public int r; // row
  public int c; // column
  public float charge;

  // constructor
  public Monopole(int row, int column, float monopoleCharge) {
    this.r = row;
    this.c = column;
    this.charge = monopoleCharge;
  }

  // methods
  public int getId () {
    return this.id;
  }

}
