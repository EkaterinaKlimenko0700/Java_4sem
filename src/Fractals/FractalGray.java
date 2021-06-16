package Fractals;
public class FractalGray implements Fractal
{
    long N;
    long R;

    public FractalGray(long n, long r) {
        N = n;
        R = r;
    }

    @Override
    public double steps(double x, double y) {
        Complex z = new Complex(0,0);
        long i = 0;

        Complex c = new Complex(x, y);

        for( i = 0; i <= N; i ++)
        {
            z = z.times(z);
            z = z.plus(c);
            if(z.abs() > R)
                break;
        }

        return i/(double)N;
    }
}

