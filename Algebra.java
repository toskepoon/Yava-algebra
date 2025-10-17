public final class OlympiadAlgebraFull {

    private OlympiadAlgebraFull() { }

    public static double abs(double x) {
        if (x < 0) {
            x = -x;
        }
        return x;
    }

    public static double sqrt(double x) {
        if (x <= 0) {
            return 0;
        }

        double guess;
        if (x >= 1.0) {
            guess = x;
        } else {
            guess = 1.0;
        }

        int iteration = 0;
        while (iteration < 30) {
            double quotient = x / guess;
            double average = (guess + quotient) / 2.0;
            guess = average;
            iteration++;
        }
        return guess;
    }

    public static double pow(double base, int exp) {
        double result = 1.0;
        int i = 0;
        while (i < exp) {
            result = result * base;
            i++;
        }
        return result;
    }

    public static double arithmeticMean(double[] a) {
        double sum = 0.0;
        int i = 0;
        while (i < a.length) {
            sum = sum + a[i];
            i++;
        }
        return sum / a.length;
    }

    public static double geometricMean(double[] a) {
        double product = 1.0;
        int i = 0;
        while (i < a.length) {
            product = product * a[i];
            i++;
        }

        int n = a.length;
        double y;
        if (product >= 1.0) {
            y = product;
        } else {
            y = 1.0;
        }

        int iteration = 0;
        while (iteration < 25) {
            double power = 1.0;
            int k = 0;
            while (k < n - 1) {
                power = power * y;
                k++;
            }
            double numerator = (n - 1) * y + product / power;
            double newY = numerator / n;
            y = newY;
            iteration++;
        }
        return y;
    }

    public static double harmonicMean(double[] a) {
        double reciprocalSum = 0.0;
        int i = 0;
        while (i < a.length) {
            reciprocalSum = reciprocalSum + (1.0 / a[i]);
            i++;
        }
        return a.length / reciprocalSum;
    }

    public static boolean checkAMGM(double[] a) {
        double am = arithmeticMean(a);
        double gm = geometricMean(a);
        double diff = am - gm;
        if (diff < 0 && abs(diff) > 1e-9) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkCauchySchwarz(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must be the same length.");
        }

        double dot = 0.0;
        double sumA2 = 0.0;
        double sumB2 = 0.0;

        int i = 0;
        while (i < a.length) {
            dot = dot + (a[i] * b[i]);
            sumA2 = sumA2 + (a[i] * a[i]);
            sumB2 = sumB2 + (b[i] * b[i]);
            i++;
        }

        double leftSide = dot * dot;
        double rightSide = sumA2 * sumB2;
        if (leftSide <= rightSide + 1e-9) {
            return true;
        } else {
            return false;
        }
    }

    public static double squareOfSum(double a, double b) {
        double a2 = a * a;
        double b2 = b * b;
        double twoAB = 2.0 * a * b;
        double total = a2 + twoAB + b2;
        return total;
    }

    public static double squareOfDifference(double a, double b) {
        double a2 = a * a;
        double b2 = b * b;
        double twoAB = 2.0 * a * b;
        double total = a2 - twoAB + b2;
        return total;
    }

    public static double sumOfCubes(double a, double b) {
        double sum = a + b;
        double part = a * a - a * b + b * b;
        double result = sum * part;
        return result;
    }

    public static double differenceOfCubes(double a, double b) {
        double diff = a - b;
        double part = a * a + a * b + b * b;
        double result = diff * part;
        return result;
    }

    public static double squareOfThree(double a, double b, double c) {
        double a2 = a * a;
        double b2 = b * b;
        double c2 = c * c;
        double pairSum = 2.0 * (a * b + b * c + c * a);
        double total = a2 + b2 + c2 + pairSum;
        return total;
    }

    public static boolean sumSquaresInequality(double a, double b, double c) {
        double left = a * a + b * b + c * c;
        double right = a * b + b * c + c * a;
        if (left + 1e-9 >= right) {
            return true;
        } else {
            return false;
        }
    }

    public static double am2(double a, double b) {
        double sum = a + b;
        double result = sum / 2.0;
        return result;
    }

    public static double gm2(double a, double b) {
        double product = a * b;
        double root = sqrt(product);
        return root;
    }

    public static boolean amgm2(double a, double b) {
        double am = am2(a, b);
        double gm = gm2(a, b);
        if (am + 1e-9 >= gm) {
            return true;
        } else {
            return false;
        }
    }

    public static double am3(double a, double b, double c) {
        double sum = a + b + c;
        double result = sum / 3.0;
        return result;
    }

    public static double gm3(double a, double b, double c) {
        double product = a * b * c;
        double result = pow(product, 1) / pow(1, 1); 
        double x = product;
        double y = 1.0;
        int iteration = 0;
        while (iteration < 25) {
            double y2 = y * y;
            y = (2.0 * y + x / y2) / 3.0;
            iteration++;
        }
        return y;
    }

    public static boolean amgm3(double a, double b, double c) {
        double am = am3(a, b, c);
        double gm = gm3(a, b, c);
        if (am + 1e-9 >= gm) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        double[] nums = {2.0, 5.0, 7.0};
        double[] other = {1.0, 3.0, 4.0};

        System.out.println("Arithmetic Mean = " + arithmeticMean(nums));
        System.out.println("Geometric Mean = " + geometricMean(nums));
        System.out.println("AM ≥ GM ? " + checkAMGM(nums));
        System.out.println("Cauchy–Schwarz holds? " + checkCauchySchwarz(nums, other));
        System.out.println("(3 + 4)^2 = " + squareOfSum(3, 4));
        System.out.println("a² + b² + c² ≥ ab + bc + ca ? " + sumSquaresInequality(1, 2, 3));
    }
}

