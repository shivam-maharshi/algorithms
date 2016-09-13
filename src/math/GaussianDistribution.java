package math;

/**
 * Return an array with n numbers representing a Gaussian Distribution function.
 * 
 * @author shivam.maharshi
 */
public class GaussianDistribution {
  
  public static void main(String[] args) {
    double[] curve = generateArray(100, 0, 1);
    curve = normalize(curve);
    for (double c : curve)
      System.out.println(c);
  }
  
  public static double[] normalize(double[] n) {
    double sum = n[0];
    for(int i=1; i<n.length; i++)
      sum += 2 * n[i];
    for(int i=0; i<n.length; i++)
      n[i] = n[i]/sum;
    return n;
  }
  
  public static double[] generateArray(int n, double mu, double sigma) {
    double[] curve = new double[n];
    double twoSigmaSquare = 2 * sigma * sigma;
    double sigmaRootTwoPie = sigma * Math.sqrt(2* Math.PI);
    for(int i=0; i<n; i++)
      curve[i] = getDensityValue(i, mu, twoSigmaSquare, sigmaRootTwoPie);
    return curve;
  }
  
  public static double getDensityValue(int x, double mu, double twoSigmaSquare, double sigmaRootTwoPie) {
    double diffFromMeanSquare = (x-mu) * (x-mu);
    return Math.pow(Math.E, -diffFromMeanSquare / twoSigmaSquare) / sigmaRootTwoPie;
  }

}
