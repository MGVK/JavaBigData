import java.util.function.BiFunction;

public abstract class Fraction<N, D> {

    private N                   numerator;
    private D                   denumerator;
    private BiFunction<N, D, ?> devider;
    private BiFunction<N, D, ?> summator;
    private BiFunction<N, D, ?> amplifier;
    private BiFunction<N, D, ?> substractor;

    public Fraction(N numerator, D denumerator) {
        this.numerator = numerator;
        this.denumerator = denumerator;
    }

    public Fraction(N numerator, D denumerator, BiFunction<N, D, ?> devider,
                    BiFunction<N, D, ?> summator, BiFunction<N, D, ?> amplifier,
                    BiFunction<N, D, ?> substractor) {
        this.numerator = numerator;
        this.denumerator = denumerator;
        this.devider = devider;
        this.summator = summator;
        this.amplifier = amplifier;
        this.substractor = substractor;
    }

    public Fraction(Fraction fraction) {

    }

    public BiFunction<N, D, ?> getSummator() {
        return summator;
    }

    public void setSummator(BiFunction<N, D, ?> summator) {
        this.summator = summator;
    }

    public BiFunction<N, D, ?> getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(BiFunction<N, D, ?> amplifier) {
        this.amplifier = amplifier;
    }

    public BiFunction<N, D, ?> getSubstractor() {
        return substractor;
    }

    public void setSubstractor(BiFunction<N, D, ?> substractor) {
        this.substractor = substractor;
    }

    public BiFunction<N, D, ?> getDevider() {
        return devider;
    }

    public void setDevider(BiFunction<N, D, ?> devider) {
        this.devider = devider;
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
