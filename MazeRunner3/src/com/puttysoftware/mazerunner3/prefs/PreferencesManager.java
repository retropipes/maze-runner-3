/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.prefs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import com.puttysoftware.mazerunner3.battle.map.MapBattleSpeedConstants;
import com.puttysoftware.mazerunner3.maze.Extension;
import com.puttysoftware.mazerunner3.maze.MazeConstants;
import com.puttysoftware.mazerunner3.maze.abc.AbstractMazeObject;
import com.puttysoftware.mazerunner3.maze.objects.Dirt;
import com.puttysoftware.mazerunner3.maze.objects.Empty;
import com.puttysoftware.mazerunner3.maze.objects.Grass;
import com.puttysoftware.mazerunner3.maze.objects.Sand;
import com.puttysoftware.mazerunner3.maze.objects.Snow;
import com.puttysoftware.mazerunner3.maze.objects.Tile;
import com.puttysoftware.mazerunner3.maze.objects.Tundra;

public class PreferencesManager {
    // Fields
    private static PreferencesStoreManager storeMgr = new PreferencesStoreManager();
    private static PreferencesGUIManager guiMgr = new PreferencesGUIManager();
    static final int MUSIC_ALL = 0;
    public static final int MUSIC_EXPLORING = 1;
    public static final int MUSIC_BATTLE = 2;
    public static final int FILTER_MAZE = 1;
    public static final int FILTER_GAME = 2;
    static final int MUSIC_LENGTH = 3;
    private static final boolean BATTLE_STYLE_MAP = true;
    private static final String MAC_PREFIX = "HOME";
    private static final String WIN_PREFIX = "APPDATA";
    private static final String UNIX_PREFIX = "HOME";
    private static final String MAC_DIR = "/Library/Preferences/";
    private static final String WIN_DIR = "\\Putty Software\\MazeRunnerII\\";
    private static final String UNIX_DIR = "/.puttysoftware/mazerunner2/";
    private static final String MAC_FILE = "com.puttysoftware.mazerunner2";
    private static final String WIN_FILE = "MazeRunnerIIPreferences";
    private static final String UNIX_FILE = "MazeRunnerIIPreferences";

    // Private constructor
    private PreferencesManager() {
	// Do nothing
    }

    // Methods
    public static boolean getSoundsEnabled() {
	return PreferencesManager.storeMgr.getBoolean("SoundsEnabled", true);
    }

    public static void setSoundsEnabled(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("SoundsEnabled", value);
    }

    public static boolean getRPGEnabled() {
	return PreferencesManager.storeMgr.getBoolean("RPGEnabled", false);
    }

    public static void setRPGEnabled(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("RPGEnabled", value);
    }

    public static boolean getRandomBattleEnvironment() {
	return PreferencesManager.storeMgr.getBoolean("RandomBattleEnvironment", false);
    }

    public static void setRandomBattleEnvironment(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("RandomBattleEnvironment", value);
    }

    public static int getBattleSpeed() {
	return MapBattleSpeedConstants.BATTLE_SPEED_ARRAY[PreferencesManager.storeMgr.getInteger("BattleSpeed",
		MapBattleSpeedConstants.BATTLE_SPEED_MODERATE)];
    }

    static int getBattleSpeedValue() {
	return PreferencesManager.storeMgr.getInteger("BattleSpeed", MapBattleSpeedConstants.BATTLE_SPEED_MODERATE);
    }

    static void setBattleSpeed(final int value) {
	PreferencesManager.storeMgr.setInteger("BattleSpeed", value);
    }

    public static boolean getBattleStyle() {
	return PreferencesManager.storeMgr.getBoolean("BattleStyle", PreferencesManager.BATTLE_STYLE_MAP);
    }

    static void setBattleStyle(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("BattleStyle", value);
    }

    public static boolean areCharacterChangesPermanent() {
	return PreferencesManager.storeMgr.getBoolean("CharacterChangesPermanent", false);
    }

    static void setCharacterChangesPermanent(final boolean status) {
	PreferencesManager.storeMgr.setBoolean("CharacterChangesPermanent", status);
    }

    public static int getViewingWindowSize() {
	return PreferencesManager.storeMgr.getInteger("ViewingWindowSize",
		PreferencesGUIManager.DEFAULT_VIEWING_WINDOW_SIZE);
    }

    static void setViewingWindowSize(final int value) {
	PreferencesManager.storeMgr.setInteger("ViewingWindowSize", value);
    }

    public static String getLastDirOpen() {
	return PreferencesManager.storeMgr.getString("LastDirOpen", "");
    }

    public static void setLastDirOpen(final String value) {
	PreferencesManager.storeMgr.setString("LastDirOpen", value);
    }

    public static String getLastDirSave() {
	return PreferencesManager.storeMgr.getString("LastDirSave", "");
    }

    public static void setLastDirSave(final String value) {
	PreferencesManager.storeMgr.setString("LastDirSave", value);
    }

    public static int getLastFilterUsedOpen() {
	return PreferencesManager.storeMgr.getInteger("LastFilterUsed", PreferencesManager.FILTER_MAZE);
    }

    public static void setLastFilterUsedOpen(final int value) {
	PreferencesManager.storeMgr.setInteger("LastFilterUsed", value);
    }

    public static boolean shouldCheckUpdatesAtStartup() {
	return PreferencesManager.storeMgr.getBoolean("UpdatesStartup", true);
    }

    static void setCheckUpdatesAtStartup(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("UpdatesStartup", value);
    }

    public static boolean oneMove() {
	return PreferencesManager.storeMgr.getBoolean("OneMove", true);
    }

    static void setOneMove(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("OneMove", value);
    }

    public static boolean getMusicEnabled(final int mus) {
	if (!PreferencesManager.storeMgr.getBoolean("MUSIC_0", false)) {
	    return false;
	} else {
	    return PreferencesManager.storeMgr.getBoolean("MUSIC_" + mus, true);
	}
    }

    public static AbstractMazeObject getEditorDefaultFill() {
	final String choice = PreferencesManager.storeMgr.getString("EditorDefaultFill", "Grass");
	if (choice.equals("Tile")) {
	    return new Tile();
	} else if (choice.equals("Grass")) {
	    return new Grass();
	} else if (choice.equals("Dirt")) {
	    return new Dirt();
	} else if (choice.equals("Snow")) {
	    return new Snow();
	} else if (choice.equals("Tundra")) {
	    return new Tundra();
	} else if (choice.equals("Sand")) {
	    return new Sand();
	} else {
	    return null;
	}
    }

    public static AbstractMazeObject getEditorDefaultFill(final int layer) {
	if (layer == MazeConstants.LAYER_OBJECT) {
	    return new Empty();
	} else {
	    final String choice = PreferencesManager.storeMgr.getString("EditorDefaultFill", "Grass");
	    if (choice.equals("Tile")) {
		return new Tile();
	    } else if (choice.equals("Grass")) {
		return new Grass();
	    } else if (choice.equals("Dirt")) {
		return new Dirt();
	    } else if (choice.equals("Snow")) {
		return new Snow();
	    } else if (choice.equals("Tundra")) {
		return new Tundra();
	    } else if (choice.equals("Sand")) {
		return new Sand();
	    } else {
		return null;
	    }
	}
    }

    static void setEditorDefaultFill(final String value) {
	PreferencesManager.storeMgr.setString("EditorDefaultFill", value);
    }

    public static boolean getEditorAutoEdge() {
	return PreferencesManager.storeMgr.getBoolean("EditorAutoEdge", false);
    }

    static void setEditorAutoEdge(final boolean value) {
	PreferencesManager.storeMgr.setBoolean("EditorAutoEdge", value);
    }

    static void setMusicEnabled(final int mus, final boolean status) {
	PreferencesManager.storeMgr.setBoolean("MUSIC_" + mus, status);
    }

    public static JFrame getPrefFrame() {
	return PreferencesManager.guiMgr.getPrefFrame();
    }

    public static void showPrefs() {
	PreferencesManager.guiMgr.showPrefs();
    }

    private static String getPrefsDirPrefix() {
	final String osName = System.getProperty("os.name");
	if (osName.indexOf("Mac OS X") != -1) {
	    // Mac OS X
	    return System.getenv(PreferencesManager.MAC_PREFIX);
	} else if (osName.indexOf("Windows") != -1) {
	    // Windows
	    return System.getenv(PreferencesManager.WIN_PREFIX);
	} else {
	    // Other - assume UNIX-like
	    return System.getenv(PreferencesManager.UNIX_PREFIX);
	}
    }

    private static String getPrefsDirectory() {
	final String osName = System.getProperty("os.name");
	if (osName.indexOf("Mac OS X") != -1) {
	    // Mac OS X
	    return PreferencesManager.MAC_DIR;
	} else if (osName.indexOf("Windows") != -1) {
	    // Windows
	    return PreferencesManager.WIN_DIR;
	} else {
	    // Other - assume UNIX-like
	    return PreferencesManager.UNIX_DIR;
	}
    }

    private static String getPrefsFileExtension() {
	return "." + Extension.getPreferencesExtension();
    }

    private static String getPrefsFileName() {
	final String osName = System.getProperty("os.name");
	if (osName.indexOf("Mac OS X") != -1) {
	    // Mac OS X
	    return PreferencesManager.MAC_FILE;
	} else if (osName.indexOf("Windows") != -1) {
	    // Windows
	    return PreferencesManager.WIN_FILE;
	} else {
	    // Other - assume UNIX-like
	    return PreferencesManager.UNIX_FILE;
	}
    }

    private static String getPrefsFile() {
	final StringBuilder b = new StringBuilder();
	b.append(PreferencesManager.getPrefsDirPrefix());
	b.append(PreferencesManager.getPrefsDirectory());
	b.append(PreferencesManager.getPrefsFileName());
	b.append(PreferencesManager.getPrefsFileExtension());
	return b.toString();
    }

    public static void writePrefs() {
	try (BufferedOutputStream bos = new BufferedOutputStream(
		new FileOutputStream(PreferencesManager.getPrefsFile()))) {
	    PreferencesManager.storeMgr.saveStore(bos);
	} catch (final IOException io) {
	    // Ignore
	}
    }

    static void readPrefs() {
	try (BufferedInputStream bis = new BufferedInputStream(
		new FileInputStream(PreferencesManager.getPrefsFile()))) {
	    // Read new preferences
	    PreferencesManager.storeMgr.loadStore(bis);
	} catch (final IOException io) {
	    // Populate store with defaults
	    PreferencesManager.storeMgr.setString("LastDirOpen", "");
	    PreferencesManager.storeMgr.setString("LastDirSave", "");
	    PreferencesManager.storeMgr.setInteger("LastFilterUsed", PreferencesManager.FILTER_MAZE);
	    PreferencesManager.storeMgr.setBoolean("UpdatesStartup", true);
	    PreferencesManager.storeMgr.setBoolean("OneMove", true);
	    for (int x = 0; x < PreferencesManager.MUSIC_LENGTH; x++) {
		PreferencesManager.storeMgr.setBoolean("MUSIC_" + x, true);
	    }
	    PreferencesManager.storeMgr.setString("EditorDefaultFill", "Grass");
	    PreferencesManager.storeMgr.setInteger("ViewingWindowSize",
		    PreferencesGUIManager.DEFAULT_VIEWING_WINDOW_SIZE);
	    PreferencesManager.storeMgr.setInteger("BattleSpeed", 2);
	    PreferencesManager.storeMgr.setInteger("GeneratorRandomness", 3);
	    PreferencesManager.storeMgr.setBoolean("CharacterChangesPermanent", false);
	    PreferencesManager.storeMgr.setBoolean("SoundsEnabled", true);
	    PreferencesManager.storeMgr.setBoolean("RandomBattleEnvironment", false);
	    PreferencesManager.storeMgr.setBoolean("RPGEnabled", false);
	    PreferencesManager.storeMgr.setBoolean("BattleStyle", PreferencesManager.BATTLE_STYLE_MAP);
	}
    }
}
