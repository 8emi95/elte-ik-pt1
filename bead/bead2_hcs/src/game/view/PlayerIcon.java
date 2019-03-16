package game.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class PlayerIcon extends ImageIcon {

	private static final long serialVersionUID = 6698090020759526037L;
	
	private static final double RATIO = 0.7;

	public PlayerIcon(String filename, int fieldWidth, int fieldHeight) {
		Image image = null;
		String workDir = System.getProperty("user.dir");
		File img = new File(workDir + "\\resources\\" + filename);

		try {
			image = ImageIO.read(img);
			image = image.getScaledInstance((int) (fieldWidth * RATIO), (int) (fieldHeight * RATIO),
					Image.SCALE_SMOOTH);
			setImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public abstract String getName();
}
