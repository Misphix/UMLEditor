package object.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import object.Port;

public class UmlUseCase extends UmlShape {


    public UmlUseCase(double x, double y) {
        width = 100;
        height = 50;

        name = "Use Case";
        this.x = x - width / 2;
        this.y = y - height / 2;

        portsInitialize();
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawUseCase(gc);
        for (Port port : ports) {
            port.draw(gc);
        }
    }

    private void drawUseCase(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.setStroke(Color.BLACK);
        gc.fillOval(x, y, width, height);
        gc.strokeOval(x, y, width, height);

        writeName(gc, height);
    }
}
