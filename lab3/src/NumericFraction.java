import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.function.BiFunction;

public class NumericFraction extends Fraction<Integer, Integer> {


    public NumericFraction(Integer numerator, Integer denumerator) {
        super(numerator, denumerator);
        setSummator((BiFunction<NumericFraction, NumericFraction, NumericFraction>) NumericFraction::sum);
        setAmplifier((BiFunction<NumericFraction, NumericFraction, NumericFraction>) NumericFraction::amplify);
        setDevider((BiFunction<NumericFraction, NumericFraction, NumericFraction>) NumericFraction::devide_);
        setSubstractor((BiFunction<NumericFraction, NumericFraction, NumericFraction>) NumericFraction::substract);
    }

    private static NumericFraction substract(NumericFraction fraction1, NumericFraction fraction2) {
        NumericFraction f = new NumericFraction(fraction2.getNumerator() * (-1), fraction2.getDenumerator());
        return sum(fraction1, f);
    }

    private static NumericFraction devide_(NumericFraction fraction1, NumericFraction fraction2) {
        return amplify(fraction2, fraction1);
    }

    private static NumericFraction amplify(NumericFraction fraction1, NumericFraction fraction2) {

        return new NumericFraction(fraction1.getNumerator() * fraction1.getNumerator(),
                fraction2.getDenumerator() * fraction2.getDenumerator());

    }

    private static NumericFraction sum(NumericFraction fraction1, NumericFraction fraction2) {

        int d = ArithmeticUtils.lcm(fraction1.getDenumerator(), fraction2.getDenumerator());

        return new NumericFraction(d / fraction1.getDenumerator() * fraction1.getNumerator() +
                                   d / fraction2.getDenumerator() * fraction2.getNumerator(), d);
    }

    @Override
    public String toString() {
        return "[" + getNumerator() + "/" + getDenumerator() + "]";
    }
}
