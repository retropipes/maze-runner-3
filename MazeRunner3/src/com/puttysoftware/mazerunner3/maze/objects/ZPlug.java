/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractPlug;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class ZPlug extends AbstractPlug {
    // Constructors
    public ZPlug() {
	super('Z');
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_Z_PLUG;
    }
}