/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractSingleLock;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class RoseLock extends AbstractSingleLock {
    // Constructors
    public RoseLock() {
	super(new RoseKey(), ColorConstants.COLOR_ROSE);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	if (this.isConditionallySolid(inv)) {
	    Boot.getApplication().showMessage("You need a rose key");
	}
	SoundManager.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
	return "Rose Lock";
    }

    @Override
    public String getPluralName() {
	return "Rose Locks";
    }

    @Override
    public String getDescription() {
	return "Rose Locks require Rose Keys to open.";
    }
}