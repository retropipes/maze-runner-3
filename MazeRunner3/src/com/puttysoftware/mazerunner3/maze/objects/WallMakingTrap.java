/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractTrap;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public class WallMakingTrap extends AbstractTrap {
    public WallMakingTrap() {
        super(ColorConstants.COLOR_BRIDGE,
                ObjectImageConstants.OBJECT_IMAGE_WALL_MAKING,
                ColorConstants.COLOR_BROWN);
    }

    @Override
    public String getName() {
        return "Wall-Making Trap";
    }

    @Override
    public String getPluralName() {
        return "Wall-Making Traps";
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY,
            final MazeObjectInventory inv) {
        SoundManager.playSound(SoundConstants.SOUND_WALK);
        Boot.getApplication().getGameManager()
                .delayedDecayTo(new Wall());
    }

    @Override
    public String getDescription() {
        return "Wall-Making Traps create a Wall when you step OFF them.";
    }
}
