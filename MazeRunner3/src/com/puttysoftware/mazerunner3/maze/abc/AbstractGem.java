/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: mazer5d@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.abc;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.objects.Empty;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.SoundManager;

public abstract class AbstractGem extends AbstractMazeObject {
    // Fields
    private static final long SCORE_SMASH = 10L;
    private static final long SCORE_GRAB = 20L;

    // Constructors
    protected AbstractGem(final int tc) {
	super(false, true);
	this.setTemplateColor(tc);
    }

    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	Boot.getApplication().getGameManager().decay();
	Boot.getApplication().getGameManager().addToScore(AbstractGem.SCORE_GRAB);
	this.postMoveActionHook();
	Boot.getApplication().getGameManager().redrawMaze();
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_GEM;
    }

    public abstract void postMoveActionHook();

    @Override
    protected void setTypes() {
	this.type.set(TypeConstants.TYPE_GEM);
	this.type.set(TypeConstants.TYPE_CONTAINABLE);
    }

    @Override
    public int getLayer() {
	return MazeConstants.LAYER_OBJECT;
    }

    @Override
    public boolean arrowHitAction(final int locX, final int locY, final int locZ, final int dirX, final int dirY,
	    final int arrowType, final MazeObjectInventory inv) {
	Boot.getApplication().getGameManager().morph(new Empty(), locX, locY, locZ);
	SoundManager.playSound(SoundConstants.SOUND_SHATTER);
	Boot.getApplication().getGameManager().addToScore(AbstractGem.SCORE_SMASH);
	return false;
    }

    @Override
    public int getCustomProperty(final int propID) {
	return AbstractMazeObject.DEFAULT_CUSTOM_VALUE;
    }

    @Override
    public void setCustomProperty(final int propID, final int value) {
	// Do nothing
    }
}
