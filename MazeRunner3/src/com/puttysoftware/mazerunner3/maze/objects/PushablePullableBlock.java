/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractMovableObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;
import com.puttysoftware.mazerunner3.resourcemanagers.ObjectImageConstants;

public class PushablePullableBlock extends AbstractMovableObject {
    // Constructors
    public PushablePullableBlock() {
        super(true, true, ObjectImageConstants.OBJECT_IMAGE_PULLABLE);
        this.setTemplateColor(ColorConstants.COLOR_BLOCK);
    }

    @Override
    public String getName() {
        return "Pushable/Pullable Block";
    }

    @Override
    public String getPluralName() {
        return "Pushable/Pullable Blocks";
    }

    @Override
    public String getDescription() {
        return "Pushable/Pullable Blocks can be both pushed and pulled.";
    }
}
