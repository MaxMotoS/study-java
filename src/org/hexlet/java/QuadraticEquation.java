package org.hexlet.java;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 24.06.13
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    private double D;

    private double x1;
    private double x2;

    QuadraticEquation() {a = b = c = 0;}

    QuadraticEquation(double a,
                      double b,
                      double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        Solution();
    }

    private void Discriminant () {
        D = b * b - 4 * a *c;
    }

    private void Solution() {
        Discriminant();
        if (D >= 0) {
            x1 = (0 - b + Math.sqrt(D)) / (2 * a);
            x2 = (0 - b - Math.sqrt(D)) / (2 * a);
        }
    }

    public double[] getSolution() {
        double[] solution;
        if (D > 0) {
            solution = new double[2];
            solution[0] = x1;
            solution[1] = x2;
            return solution;
        }
        if (D == 0) {
            solution = new double[1];
            solution[0] = x1;
            return solution;
        }
        return null;
    }
}
