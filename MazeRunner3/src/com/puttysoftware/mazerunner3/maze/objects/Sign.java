/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractTextHolder;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class Sign extends AbstractTextHolder {
    // Constructors
    public Sign() {
	super();
    }

    @Override
    public int getBaseID() {
	return ObjectImageConstants.OBJECT_IMAGE_SIGN;
    }

    @Override
    public String getName() {
	return "Sign";
    }

    @Override
    public String getPluralName() {
	return "Signs";
    }

    @Override
    public String getDescription() {
	return "Signs display their message when walked into.";
    }
}