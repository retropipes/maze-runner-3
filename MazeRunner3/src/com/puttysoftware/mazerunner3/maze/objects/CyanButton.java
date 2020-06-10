/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractButton;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class CyanButton extends AbstractButton {
    public CyanButton() {
	super(new CyanWallOff(), new CyanWallOn(), ColorConstants.COLOR_CYAN);
    }

    @Override
    public String getName() {
	return "Cyan Button";
    }

    @Override
    public String getPluralName() {
	return "Cyan Buttons";
    }

    @Override
    public String getDescription() {
	return "Cyan Buttons will cause all Cyan Walls Off to become On, and all Cyan Walls On to become Off.";
    }
}
