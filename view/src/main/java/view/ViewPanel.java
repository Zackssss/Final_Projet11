package view;

import entity.Tileset;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

import javax.swing.JPanel;

import static java.lang.Thread.sleep;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/**
	 * The view frame.
	 */
	private ViewFrame viewFrame;
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) throws IOException {
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
	 * @param viewFrame the new view frame
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
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		ArrayList<Tileset> DrawMap = this.getViewFrame().getModel().getMap();
		BufferedImage imageTemp = null;

		try {
			imageTemp = ImageIO.read(new File("C:\\Users\\zacbo\\Documents\\JAVA\\Remake Projet Java\\sprites" + "\\" + "background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<1; i++){
				graphics.drawImage(imageTemp, 0, 0, 2112, 1056, null);
		}


		for (int i = 0; i < DrawMap.size(); i++) {

			try {
				if (DrawMap.get(i).getFactory().equals("Empty")) {
				} else if (DrawMap.get(i).getFactory().equals("Player") || DrawMap.get(i).getFactory().equals("Enemy")) {
					imageTemp = ImageIO.read(new File("C:\\Users\\zacbo\\Documents\\JAVA\\Remake Projet Java\\sprites\\" + DrawMap.get(i).getFactory() + ".png"));
				} else {
					imageTemp = ImageIO.read(new File("C:\\Users\\zacbo\\Documents\\JAVA\\Remake Projet Java\\sprites\\" + DrawMap.get(i).getFactory() + ".png"));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(imageTemp, DrawMap.get(i).getX() * 3, DrawMap.get(i).getY() * 3, 48, 48, null);
		}

			this.repaint();

		}

	}

