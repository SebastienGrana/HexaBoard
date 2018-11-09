package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Text;

public class RectanglePaintListener implements PaintListener {


	  private Text txtArcWidth = null;
	  private Text txtArcHeight = null;
	/**
	 * This class gets the user input and draws the requested round rectangle
	 */
	public void paintControl(PaintEvent e) {
		// Get the canvas for drawing and its width and height
		Canvas canvas = (Canvas) e.widget;
		int x = canvas.getBounds().width;
		int y = canvas.getBounds().height;

		// Determine user input, defaulting everything to zero.
		// Any blank fields are converted to zero
		int arcWidth = 0;
		int arcHeight = 0;
		try {
			arcWidth = txtArcWidth.getText().length() == 0 ? 0 : Integer.parseInt(txtArcWidth.getText());
			arcHeight = txtArcWidth.getText().length() == 0 ? 0 : Integer.parseInt(txtArcHeight.getText());
		} catch (NumberFormatException ex) {
			// Any problems, set them both to zero
			arcWidth = 0;
			arcHeight = 0;
		}

		// Set the line width
		e.gc.setLineWidth(4);

		// Draw the round rectangle
		e.gc.drawRoundRectangle(10, 10, x - 20, y - 20, arcWidth, arcHeight);

	}
}
