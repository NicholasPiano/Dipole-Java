import java.lang.Math;

public class Vector {
	private double vArray[];

	// constructor
	public Vector (double r, double c) {
		vArray = new double[]{r, c};
	}

  public Vector (double[] vectorArray) {
    vArray = vectorArray;
  }

	//instance methods
	public double getMagnitude() { // get scalar magnitude of vector
		double sum = 0;
		for (int i=0; i<vArray.length; i++) { // go through each element
			sum += vArray[i]*vArray[i];
		}
		sum = Math.sqrt(sum);
		return sum;
	}

	public void scalarMult(double s) { // multiply by a scalar
		for (int i=0; i<vArray.length; i++) {
			if (vArray[i] != 0) {
				vArray[i] *= s;
			}
		}
	}

	public void unit() { // get unit vector in the direction of vector A
		Vector B = new Vector(vArray);
		double magnitude = B.getMagnitude();
		if (magnitude != 0) {
			B.scalarMult(1.0/magnitude);
			vArray = B.getArray();
		}
	}

  public void boundaryConditions(int rMax, int cMax) {
    vArray[0] = vArray[0] < rMax ? (vArray[0] < 0 ? (double)rMax + (vArray[0] / (double)rMax) - (long)(vArray[0] / (double)rMax) : vArray[0]) : (vArray[0] / (double)rMax) - (long)(vArray[0] / (double)rMax);
    vArray[1] = vArray[1] < cMax ? (vArray[1] < 0 ? (double)cMax + (vArray[1] / (double)cMax) - (long)(vArray[1] / (double)cMax) : vArray[1]) : (vArray[1] / (double)cMax) - (long)(vArray[1] / (double)cMax);
  }

	// static methods
	public static Vector add(Vector A, Vector B) { // static method to add A to B
		int len = A.getArray().length;
		double sums[] = new double[len];
		for (int i = 0; i<len; i++) {
			sums[i] = A.getArray()[i] + B.getArray()[i];
		}
		return new Vector(sums);
	}

	public static Vector sub(Vector A, Vector B) { // subtract vector B from vector A
		int len = A.getArray().length;
		double diffs[] = new double[len];
		for (int i = 0; i<len; i++) {
			diffs[i] = A.getArray()[i] - B.getArray()[i];
		}
		return new Vector(diffs);
	}

	public static double distance(Vector A, Vector B) { // get scalar distance between Vectors
		return Vector.sub(A, B).getMagnitude();
	}

	public static double dot(Vector A, Vector B) { //dot product of A and B
		int len = A.getArray().length;
		double sum = 0.0;
		for (int i = 0; i<len; i++) {
			sum += A.getArray()[i]*B.getArray()[i];
		}
		return sum;
	}

	//setters
	public void setArray(double A[]) {vArray = A;}

	//getters
	public double[] getArray() {return vArray;}
}
