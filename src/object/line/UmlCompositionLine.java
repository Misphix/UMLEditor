package object.line;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import object.Constants;
import object.Port;

public class UmlCompositionLine extends UmlLine {

    public UmlCompositionLine(Port start, Port end) {
        super(start, end);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double width = 10;
        super.draw(gc);

        gc.save();
        double startX = start.getX() + Constants.PORT_WIDTH / 2;
        double startY = start.getY() + Constants.PORT_WIDTH / 2;
        Rotate r = new Rotate(getAngle() - 45, startX, startY);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.strokeRect(startX, startY, width, width);
        gc.fillRect(startX, startY, width, width);
        gc.restore();
    }
}
