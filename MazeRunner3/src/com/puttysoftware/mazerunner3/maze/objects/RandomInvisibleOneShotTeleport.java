/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.editor.MazeEditorLogic;
import com.puttysoftware.mazerunner3.loader.ObjectImageConstants;
import com.puttysoftware.mazerunner3.loader.SoundConstants;
import com.puttysoftware.mazerunner3.loader.SoundLoader;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.utilities.MazeObjectInventory;

public class RandomInvisibleOneShotTeleport extends RandomInvisibleTeleport {
    // Constructors
    public RandomInvisibleOneShotTeleport() {
	super();
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_RANDOM_ONE_SHOT);
    }

    public RandomInvisibleOneShotTeleport(final int newRandomRangeY, final int newRandomRangeX) {
	super(newRandomRangeY, newRandomRangeX);
	this.setAttributeID(ObjectImageConstants.OBJECT_IMAGE_RANDOM_ONE_SHOT);
    }

    // Scriptability
    @Override
    public void postMoveAction(final boolean ie, final int dirX, final int dirY, final MazeObjectInventory inv) {
	final Application app = Game.getApplication();
	app.getGameManager().decay();
	int dr, dc;
	do {
	    dr = this.getDestinationRow();
	    dc = this.getDestinationColumn();
	} while (!app.getGameManager().tryUpdatePositionRelative(dr, dc));
	app.getGameManager().updatePositionRelative(dr, dc, 0);
	Game.getApplication().showMessage("Invisible Teleport!");
	SoundLoader.playSound(SoundConstants.SOUND_TELEPORT);
    }

    @Override
    public String getName() {
	return "Random Invisible One-Shot Teleport";
    }

    @Override
    public String getPluralName() {
	return "Random Invisible One-Shot Teleports";
    }

    @Override
    public AbstractMazeObject editorPropertiesHook() {
	final MazeEditorLogic me = Game.getApplication().getEditor();
	return me.editTeleportDestination(MazeEditorLogic.TELEPORT_TYPE_RANDOM_INVISIBLE_ONESHOT);
    }

    @Override
    public String getDescription() {
	return "Random Invisible One-Shot Teleports are random, invisible, and only work once.";
    }
}