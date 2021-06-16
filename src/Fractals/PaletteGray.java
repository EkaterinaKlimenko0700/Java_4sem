package Fractals;

import javafx.scene.paint.Color;

public class PaletteGray implements Palette
{
    @Override
    public Color color(double v) {
        if(v>1)
            v=1;
        return Color.gray(v);
    }
}

