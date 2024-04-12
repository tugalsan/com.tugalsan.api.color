package com.tugalsan.api.color.client;

import com.tugalsan.api.hex.client.*;

public class TGS_ColorUtils {

    public static String toHex(TGS_Color colorRGB) {
        return TGS_HexUtils.toHex(new int[]{colorRGB.r(), colorRGB.g(), colorRGB.b()});
    }

    public static String toHexInverted(CharSequence hex) {
        var rgb = toRGB(hex);
        return toHex(new TGS_Color(
                255 - rgb.r(),
                255 - rgb.g(),
                255 - rgb.b()
        ));
    }

    public static TGS_Color toRGB(CharSequence colorHex) {
        var b = TGS_HexUtils.toInt(colorHex);
        return TGS_Color.of(b[2], b[1], b[0]);
    }

    public static String toRGBString(int red0_255, int green0_255, int blue0_255) {
        return "rgb(" + red0_255 + "," + green0_255 + "," + blue0_255 + ")";
    }

    public static TGS_Color HSBtoRGB(int hue, int saturation, int brightness) {
        int r = 0, g = 0, b = 0;
        brightness = (int) (brightness * 2.55);
        if (saturation == 0) {
            r = g = b = brightness;
        } else {
            var h = hue / 60.0;
            var f = h - Math.floor(h);
            var p = (brightness * (100 - saturation)) / 100;
            var q = (int) ((brightness * (100 - (saturation * f))) / 100);
            var t = (int) (brightness * (100 - (saturation * (1.0 - f)))) / 100;
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
        return TGS_Color.of(r, g, b);
    }
}
