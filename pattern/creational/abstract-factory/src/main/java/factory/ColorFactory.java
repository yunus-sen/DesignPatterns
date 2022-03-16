package factory;

import color.Color;
import color.Red;
import color.Yellow;

public class ColorFactory extends AbstractFactory<Color> {
    @Override
    public Color newInstance(String type) {
        if (type.equalsIgnoreCase("red")) {
            return new Red();
        } else if (type.equalsIgnoreCase("yellow")) {
            return new Yellow();
        }
        return null;
    }
}
