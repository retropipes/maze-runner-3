/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractGround;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.maze.utilities.TypeConstants;

public class Tundra extends AbstractGround {
    // Constructors
    public Tundra() {
	super(ColorConstants.COLOR_TUNDRA);
    }

    @Override
    public String getName() {
	return "Tundra";
    }

    @Override
    public String getPluralName() {
	return "Squares of Tundra";
    }

    @Override
    public String getDescription() {
	return "Tundra is one of the many types of ground.";
    }

    @Override
    protected void setTypes() {
	super.setTypes();
	this.type.set(TypeConstants.TYPE_GENERATION_ELIGIBLE);
    }
}