package com.tugalsan.api.color.client;

import com.tugalsan.api.hex.client.*;
import com.tugalsan.api.tuple.client.*;

public class TGS_ColorUtils {
 
    public static String toHex(TGS_Tuple3<Integer, Integer, Integer> colorRGB) {
        return TGS_HexUtils.toHex(new int[]{colorRGB.value0, colorRGB.value1, colorRGB.value2});
    }

    public static String toHexInverted(CharSequence hex) {
        var rgb = toRGB(hex);
        rgb.value0 = 255 - rgb.value0;
        rgb.value1 = 255 - rgb.value1;
        rgb.value2 = 255 - rgb.value2;
        return toHex(rgb);
    }

    public static TGS_Tuple3<Integer, Integer, Integer> toRGB(CharSequence colorHex) {
        int[] b = TGS_HexUtils.toInt(colorHex);
        return new TGS_Tuple3(b[2], b[1], b[0]);
    }

    public static String toRGBString(int red0_255, int green0_255, int blue0_255) {
        return "rgb(" + red0_255 + "," + green0_255 + "," + blue0_255 + ")";
    }

    public static TGS_Tuple3<Integer, Integer, Integer> HSBtoRGB(int hue, int saturation, int brightness) {
        int r = 0, g = 0, b = 0;

        brightness = (int) (brightness * 2.55);
        if (saturation == 0) {
            r = g = b = brightness;
        } else {
            double h = hue / 60.0;
            double f = h - Math.floor(h);
            int p = (brightness * (100 - saturation)) / 100;
            int q = (int) ((brightness * (100 - (saturation * f))) / 100);
            int t = (int) (brightness * (100 - (saturation * (1.0 - f)))) / 100;
            switch ((int) h) {
                case 0:
                    r = brightness;
                    g = t;
                    b = p;
                    break;
                case 1:
                    r = q;
                    g = brightness;
                    b = p;
                    break;
                case 2:
                    r = p;
                    g = brightness;
                    b = t;
                    break;
                case 3:
                    r = p;
                    g = q;
                    b = brightness;
                    break;
                case 4:
                    r = t;
                    g = p;
                    b = brightness;
                    break;
                case 5:
                    r = brightness;
                    g = p;
                    b = q;
                    break;
            }
        }
        return new TGS_Tuple3(r, g, b);
    }
}
