/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractTrappedWall;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class TrappedWall5 extends AbstractTrappedWall {
    public TrappedWall5() {
	super(5);
    }

    @Override
    public String getDescription() {
	return "Trapped Walls 5 disappear when any Wall Trap 5 is triggered.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_LARGE_5;
    }
}
