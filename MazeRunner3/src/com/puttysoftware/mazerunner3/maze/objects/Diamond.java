/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.maze.abc.AbstractScoreIncreaser;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class Diamond extends AbstractScoreIncreaser {
    // Fields
    private static final long SCORE_INCREASE = 500L;

    // Constructors
    public Diamond() {
	super(ColorConstants.COLOR_CYAN);
    }

    @Override
    public String getName() {
	return "Diamond";
    }

    @Override
    public String getPluralName() {
	return "Diamonds";
    }

    @Override
    public void postMoveActionHook() {
	Boot.getApplication().getGameManager().addToScore(Diamond.SCORE_INCREASE);
    }

    @Override
    public String getDescription() {
	return "Diamonds increase your score when picked up.";
    }
}
