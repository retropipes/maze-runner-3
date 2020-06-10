package com.puttysoftware.mazerunner3.editor;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.puttysoftware.mazerunner3.DrawGrid;
import com.puttysoftware.mazerunner3.prefs.PreferencesManager;
import com.puttysoftware.mazerunner3.resourcemanagers.ImageTransformer;

class EditorDraw extends JPanel {
    private static final long serialVersionUID = 35935343464625L;
    private final DrawGrid drawGrid;

    public EditorDraw(final DrawGrid grid) {
	super();
	this.drawGrid = grid;
	final int vSize = PreferencesManager.getViewingWindowSize();
	final int gSize = ImageTransformer.getGraphicSize();
	this.setPreferredSize(new Dimension(vSize * gSize, vSize * gSize));
    }

    @Override
    public void paintComponent(final Graphics g) {
	super.paintComponent(g);
	if (this.drawGrid != null) {
	    final int gSize = ImageTransformer.getGraphicSize();
	    final int vSize = PreferencesManager.getViewingWindowSize();
	    for (int x = 0; x < vSize; x++) {
		for (int y = 0; y < vSize; y++) {
		    g.drawImage(this.drawGrid.getImageCell(y, x), x * gSize, y * gSize, gSize, gSize, null);
		}
	    }
	}
    }
}
