package shape;

import color.BridgeColor;

public class BridgeSquare extends BridgeShape {

    public BridgeSquare(BridgeColor color){
        super(color);
    }

    @Override
    public String draw() {
        return "Square was draw. "+color.fill();
    }
}
