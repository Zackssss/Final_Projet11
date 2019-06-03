package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * Draws inside the graphic interface.
 *
 * @author Zachary Morello &amp;&amp; Hugo Bouillon
 */

class ViewPanel extends JPanel implements Observer {

	/** The view frame */

	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = -998294702363713521L;

	/** Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);

	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	/*
	 * (non-Javadoc)
	 *
	 * Paints the graphic interface.
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		ArrayList<entity.Tileset> DrawMap = this.getViewFrame().getModel().getMap();
		BufferedImage imageTemp = null;

		for (int i = 0; i < DrawMap.size(); i++) {

			try {
					imageTemp = ImageIO.read(new File("C:\\Users\\mrsyl\\Desktop\\Final_Projet11\\sprites\\" + DrawMap.get(i).getFactory().getName() + ".png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(imageTemp, DrawMap.get(i).getX() * 32, DrawMap.get(i).getY() * 32, 32, 32, null);
		}

		this.repaint();

	}

}