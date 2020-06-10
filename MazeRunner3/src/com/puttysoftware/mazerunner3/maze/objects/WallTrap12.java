/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractWallTrap;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class WallTrap12 extends AbstractWallTrap {
    public WallTrap12() {
	super(12, new TrappedWall12());
    }

    @Override
    public String getDescription() {
	return "Wall Traps 12 disappear when stepped on, causing all Trapped Walls 12 to also disappear.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_SMALL_12;
    }
}
