package hu.elte.progtech.country.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import hu.elte.progtech.country.model.CountryEngine;

public class FlagFileBrowserButton extends JButton {

	private static final long serialVersionUID = 905831054005535618L;

	public FlagFileBrowserButton(Component parent, CountryEngine engine) {
		super("Tallózás...");
		addActionListener(parent, engine);
	}

	private void addActionListener(Component parent, CountryEngine engine) {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				setDefaultDirectory(chooser);
				setFilters(chooser);
				int answer = chooser.showOpenDialog(parent);
				if (answer == JFileChooser.APPROVE_OPTION) {
					try {
						engine.startNewGame(chooser.getSelectedFile());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(parent, "Cannot parse file", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			private void setFilters(JFileChooser chooser) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Flag files", "flag");
				chooser.setFileFilter(filter);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.setMultiSelectionEnabled(false);
			}

			private void setDefaultDirectory(JFileChooser chooser) {
				File workingDirectory = new File(Paths.get(".").toAbsolutePath().normalize().toString());
				chooser.setCurrentDirectory(workingDirectory);
			}
		});
	}

}
