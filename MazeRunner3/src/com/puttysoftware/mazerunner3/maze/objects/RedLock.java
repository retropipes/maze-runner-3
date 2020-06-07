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

public class RedLock extends AbstractSingleLock {
    // Constructors
    public RedLock() {
        super(new RedKey(), ColorConstants.COLOR_RED);
    }

    // Scriptability
    @Override
    public void moveFailedAction(final boolean ie, final int dirX,
            final int dirY, final MazeObjectInventory inv) {
        if (this.isConditionallySolid(inv)) {
            Boot.getApplication().showMessage("You need a red key");
        }
        SoundManager.playSound(SoundConstants.SOUND_WALK_FAILED);
    }

    @Override
    public String getName() {
        return "Red Lock";
    }

    @Override
    public String getPluralName() {
        return "Red Locks";
    }

    @Override
    public String getDescription() {
        return "Red Locks require Red Keys to open.";
    }
}