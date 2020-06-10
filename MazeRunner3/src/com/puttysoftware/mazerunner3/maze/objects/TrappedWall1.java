/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractTrappedWall;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class TrappedWall1 extends AbstractTrappedWall {
    public TrappedWall1() {
	super(1);
    }

    @Override
    public String getDescription() {
	return "Trapped Walls 1 disappear when any Wall Trap 1 is triggered.";
    }

    @Override
    public int getAttributeID() {
	return ObjectImageConstants.OBJECT_IMAGE_LARGE_1;
    }
}
