/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractPort;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class TPort extends AbstractPort {
    // Constructors
    public TPort() {
	super(new TPlug(), 'T');
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_T_PORT;
    }
}
