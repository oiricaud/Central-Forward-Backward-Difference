// Name: Oscar I. Ricaud
// Meeting Times: Tu-Th 1:30pm-2:50pm
// Instructor: Dr. Natasha S. Sharma
// Teaching Assistant: Julio Solis
// Homework 02

// About:
// Find the numerical derivative Dhf(x) at the indicated point using the
// forward, backward and central difference formula.
// h = {0.1, 0.05, 0.025, 0.0125, 0.00625}.

// As given in table 5.10 from the textbook, please compute the error and the ratio
// with which the error decreases. Also, estimate, the error using the relevant formulas given
// by 5.78, 5.80, 5.85 respectively with c replaced by the indicated x.


import static java.lang.Math.atan;

public class Main {

    public static void main(String[] args) {

        double[] h = {0.1, 0.05, 0.025, 0.0125, 0.00625};

// Problem 1
        double x0 = 0;
        double c0 = x0;
        String function1 = "e^x";
        double firstDeriv = Math.exp(x0);
        double secondDeriv = Math.exp(c0);
        System.out.println("P1) Function = " + function1 + ", evaluated at x = " + x0 + ", and c = " + c0);
        backwardDifference(h, firstDeriv, secondDeriv);
        centralDifference(h, function1);
        forwardDifference(h, firstDeriv, secondDeriv);

// Problem 2
        double x1 = 1;
        double c1 = x1;
        String function2 = "arctan(x^2 - x + 1)";
        double firstDeriv_2 = (2 * x1 - 1) / (Math.pow((Math.pow(x1, 2) - x1 + 1), 2) + 1);
        double secondDeriv_2 = ((2) / (Math.pow((Math.pow(x1, 2) - x1 + 1), 2) + 1)) - (2 * (Math.pow((2 * x1 - 1), 2)) *
                (Math.pow(x1, 2) - x1 + 1) / (Math.pow((Math.pow((Math.pow(x1, 2) - x1 + 1), 2) + 1), 2)));
        System.out.println("P2) Function = " + function2 + ", evaluated at x = " + x1 + ", and c = " + c1);
        backwardDifference(h, firstDeriv_2, secondDeriv_2);
        centralDifference(h, function2);
        forwardDifference(h, firstDeriv_2, secondDeriv_2);

// Problem 3
        int x2 = 1;
        double c2 = 1;
        String function3 = "arctan(100x^2 - 199x + 100)";
        double firstDeriv_3 = (200 * x2 - 199) / (Math.pow(((100 * (Math.pow(x2, 2)) - (199 * x2)) + 100), 2) + 1);
        double secondDeriv_3 = (-2 * (3000000 * Math.pow(x2, 4) - 11940000 * Math.pow(x2, 3) + 17840400 * Math.pow(x2, 2) - 11860599 * x2 + 2960000))
                / (Math.pow((10000 * Math.pow(x2, 4) - 39800 * Math.pow(x2, 3) + 59601 * Math.pow(x2, 2) - 39800 * x2 + 10001), 2));
        System.out.println("P3) Function = " + function3 + ", evaluated at x = " + x2 + ", and c = " + c2);
        System.out.println("secondDeriv_3 " + secondDeriv_3);
        backwardDifference(h, firstDeriv_3, secondDeriv_3);
        centralDifference(h, function3);
        forwardDifference(h, firstDeriv_3, secondDeriv_3);
    }

    // Methods
    private static void backwardDifference(double[] h, double firstDeriv, double secondDeriv) {
        System.out.println(" ");
        System.out.println("Backward difference formula we obtain");
        for (double aH : h) {
            System.out.println("    h = " + aH);
            double divDiff = (-1 * firstDeriv) + ((aH / 2) * secondDeriv);
            System.out.println("        DnF(x) = " + divDiff);
            System.out.println("        Error = " + ((aH / 2) * secondDeriv));
        }
    }

    private static void centralDifference(double[] h, String function) {
        System.out.println("Central difference formula we obtain");
        if (function.equals("e^x")) {
            double x0 = 0;
            double c = 0;
            double thirdDerivAtC = Math.exp(c);
            for (double aH : h) {
                System.out.println("    h = " + aH);
                double function_x_plus_h = Math.exp(x0 + aH);
                double function_x_minus_h = Math.exp(x0 - aH);
                double divDiff = (function_x_plus_h - function_x_minus_h) / (2 * aH);
                System.out.println("        DnF(x) = " + divDiff);
                System.out.println("        Error = " + (Math.pow(aH, 2) / 6) * thirdDerivAtC);
            }
        }
        if (function.equals("arctan(x^2 - x + 1)")) {
            double x1 = 1;
            double c1 = 1;
            double thirdDerivAtC = (2 * (2 * c1 - 1) * (6 * Math.pow(c1, 6) - 18 * Math.pow(c1, 5) + 27 * Math.pow(c1, 4) - 24 * Math.pow(c1, 3) - Math.pow(c1, 2) + 10 * c1 - 10))
                    / (Math.pow((Math.pow(c1, 4) - 2 * Math.pow(c1, 3) + 3 * Math.pow(x1, 2) - 2 * c1 + 2), 3));

            for (double aH : h) {
                System.out.println("   h = " + aH);
                double function_x_plus_h_2 = atan(Math.pow((x1 + aH), 2) - x1 + aH + 1);
                double function_x_minus_h_2 = atan(Math.pow((x1 - aH), 2) - x1 - aH + 1);
                double divDiff = (function_x_plus_h_2 - function_x_minus_h_2) / (2 * aH);
                System.out.println("        DnF(x) = " + divDiff);
                System.out.println("        Error = " + Math.pow(aH, 2) / 6 * thirdDerivAtC);
            }
        }
        if (function.equals("arctan(100x^2 - 199x + 100)")) {
            double x2 = 1;
            double c2 = 1;
            // Note I used Wolfram to evealute the derivative at c because the numbers were too long to be evaluated.
            double thirdDerivAtC = -(599) / (2);

            for (double aH : h) {
                System.out.println("   h = " + aH);
                double function_x_plus_h_2 = atan(100 * Math.pow((x2 + aH), 2) - 199 * (x2 + aH) + 100);
                double function_x_minus_h_2 = atan(100 * Math.pow((x2 - aH), 2) - 199 * (x2 - aH) + 100);
                double divDiff = (function_x_plus_h_2 - function_x_minus_h_2) / (2 * aH);
                System.out.println("        DnF(x) = " + divDiff);
                System.out.println("        Error = " + Math.pow(aH, 2) / 6 * thirdDerivAtC);
            }
        } else {
            System.out.println("Function not found");
        }
    }

    private static void forwardDifference(double[] h, double firstDeriv, double secondDeriv) {
        System.out.println(" ");
        System.out.println("Forward difference formula we obtain");
        for (double aH : h) {
            System.out.println("    h = " + aH);
            double divDiff = (firstDeriv) + ((aH / 2) * secondDeriv);
            System.out.println("        DnF(x) = " + divDiff);
            System.out.println("        Error = " + (-(aH / 2) * secondDeriv));
        }
    }
}
