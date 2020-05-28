import java.util.function.BiFunction;

public abstract class Fraction<N, D> {

    private N                                                                      numerator;
    private D                                                                      denumerator;
    private BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> devider;
    private BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> summator;
    private BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> amplifier;
    private BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> substractor;

    public Fraction(N numerator, D denumerator) {
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    public Fraction(N numerator, D denumerator,
                    BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> devider,
                    BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> summator,
                    BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> amplifier,
                    BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> substractor) {
        this.numerator = numerator;
        this.denumerator = denumerator;
        this.devider = devider;
        this.summator = summator;
        this.amplifier = amplifier;
        this.substractor = substractor;
    }

    public BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> getDevider() {
        return devider;
    }

    public void setDevider(BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> devider) {
        this.devider = devider;
    }

    public BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> getSummator() {
        return summator;
    }

    public void setSummator(BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> summator) {
        this.summator = summator;
    }

    public BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> amplifier) {
        this.amplifier = amplifier;
    }

    public BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> getSubstractor() {
        return substractor;
    }

    public void setSubstractor(
            BiFunction<? extends Fraction, ? extends Fraction, ? extends Fraction> substractor) {
        this.substractor = substractor;
    }

    public N getNumerator() {
        return numerator;
    }

    public void setNumerator(N numerator) {
        this.numerator = numerator;
    }

    public D getDenumerator() {
        return denumerator;
    }

    public void setDenumerator(D denumerator) {
        this.denumerator = denumerator;
    }

}
