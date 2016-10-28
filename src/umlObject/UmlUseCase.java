package umlObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class UmlUseCase extends UmlShape {
	@FXML
	private Text useCaseName;
	@FXML
	private Group connectPoints;
	@FXML
	private Rectangle right, up, down, left;
	private List<Rectangle> ports = new ArrayList<Rectangle>();
	private final String styleClass = "uml-use-case";
	
	public UmlUseCase(String name) {
		super(name);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UmlUseCase.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ports.add(down);
		ports.add(left);
		ports.add(right);
		ports.add(up);
		setStyleClass();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		useCaseName.setText(name);
	}
	
	@Override
	public void setStartPosition(double x, double y) {
		double width = 60;
		double height = 30;
		super.setPosition(x - width, y - height);
	}
	
	@Override
	public void selected() {
		super.selected();
		connectPoints.setVisible(true);
	}
	
	@Override
	public void unSelected() {
		super.unSelected();
		connectPoints.setVisible(false);
	}
	
	@Override
	public Rectangle getPort(Point2D clickPoint) {
		double distanceMin = Double.MAX_VALUE;
		Rectangle closestPort = null;
		
		for (Rectangle port : ports) {
			double distanceNow = parentToLocal(clickPoint).distance(port.getLayoutX(), port.getLayoutY());
			if ( distanceNow < distanceMin) {
				distanceMin = distanceNow;
				closestPort = port;
			}
		}
		
		return closestPort;
	}
	
	@Override
	protected void setStyleClass() {
		getStyleClass().add(styleClass);
	}
}
