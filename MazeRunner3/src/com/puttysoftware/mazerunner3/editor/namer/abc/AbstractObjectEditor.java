/*  MazeRunnerII: A Scenario Editor
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.editor.namer.abc;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.puttysoftware.diane.gui.CommonDialogs;
import com.puttysoftware.mazerunner3.Boot;

public abstract class AbstractObjectEditor extends AbstractEditor {
    // Fields
    final int actionCmdLen;
    private final int abRows;
    private final int abCols;
    private JLabel[] nameLabels;
    private JTextField[] entryFields;
    private ArrayList<JComboBox<String>> entryLists;
    private JButton[][] actionButtons;
    boolean autoStore;
    private EventHandler handler;
    public static final boolean ENTRY_TYPE_TEXT = false;
    public static final boolean ENTRY_TYPE_LIST = true;

    protected AbstractObjectEditor(final String newSource, final int editorID, final int actionCommandLength,
	    final int actionButtonRows, final int actionButtonCols, final boolean autoStoreEnabled) {
	super(newSource, editorID);
	this.actionCmdLen = actionCommandLength;
	this.abRows = actionButtonRows;
	this.abCols = actionButtonCols;
	this.autoStore = autoStoreEnabled;
    }

    // Methods
    protected JTextField getEntryField(final int num) {
	return this.entryFields[num];
    }

    protected JComboBox<String> getEntryList(final int num) {
	return this.entryLists.get(num);
    }

    protected abstract void handleButtonClick(String cmd, int num);

    protected abstract void guiNameLabelProperties(JLabel nameLbl, int num);

    protected abstract boolean guiEntryType(int num);

    protected abstract void guiEntryFieldProperties(JTextField entry, int num);

    protected abstract String[] guiEntryListItems(int num);

    protected abstract void guiEntryListProperties(JComboBox<String> list, int num);

    protected abstract void guiActionButtonProperties(JButton actBtn, int row, int col);

    protected abstract String guiActionButtonActionCommand(int row, int col);

    protected abstract void autoStoreEntryFieldValue(JTextField entry, int num);

    protected abstract void autoStoreEntryListValue(JComboBox<String> list, int num);

    protected int guiGridRows() {
	return this.abCols;
    }

    @Override
    protected void setUpGUIHook(final Container outputPane) {
	this.handler = new EventHandler();
	outputPane.setLayout(new GridLayout(this.abCols, this.abRows));
	this.nameLabels = new JLabel[this.abCols];
	this.entryFields = new JTextField[this.abCols];
	this.entryLists = new ArrayList<>(this.abCols);
	for (int x = 0; x < this.abCols; x++) {
	    this.entryLists.add(x, new JComboBox<>(new String[] {}));
	}
	this.actionButtons = new JButton[this.abRows - 2][this.abCols];
	// Grid rows
	for (int x = 0; x < this.abCols; x++) {
	    // Create controls
	    this.nameLabels[x] = new JLabel();
	    this.guiNameLabelProperties(this.nameLabels[x], x);
	    final boolean entryType = this.guiEntryType(x);
	    if (entryType == AbstractObjectEditor.ENTRY_TYPE_LIST) {
		this.entryLists.set(x, new JComboBox<>(this.guiEntryListItems(x)));
		this.guiEntryListProperties(this.entryLists.get(x), x);
		if (this.isReadOnly()) {
		    this.entryLists.get(x).setEnabled(false);
		} else {
		    if (this.autoStore) {
			this.entryLists.get(x).setName(Integer.toString(x));
			this.entryLists.get(x).addFocusListener(this.handler);
		    }
		}
	    } else if (entryType == AbstractObjectEditor.ENTRY_TYPE_TEXT) {
		this.entryFields[x] = new JTextField();
		this.guiEntryFieldProperties(this.entryFields[x], x);
		if (this.isReadOnly()) {
		    this.entryFields[x].setEnabled(false);
		} else {
		    if (this.autoStore) {
			this.entryFields[x].setName(Integer.toString(x));
			this.entryFields[x].addFocusListener(this.handler);
		    }
		}
	    }
	    for (int y = 0; y < this.abRows - 2; y++) {
		this.actionButtons[y][x] = new JButton();
		this.guiActionButtonProperties(this.actionButtons[y][x], x, y);
		this.actionButtons[y][x].setActionCommand(this.guiActionButtonActionCommand(x, y));
		// Add action listener for button
		this.actionButtons[y][x].addActionListener(this.handler);
		if (this.isReadOnly()) {
		    this.actionButtons[y][x].setEnabled(false);
		}
	    }
	    // Add controls
	    outputPane.add(this.nameLabels[x]);
	    if (entryType == AbstractObjectEditor.ENTRY_TYPE_LIST) {
		outputPane.add(this.entryLists.get(x));
	    } else if (entryType == AbstractObjectEditor.ENTRY_TYPE_TEXT) {
		outputPane.add(this.entryFields[x]);
	    }
	    for (int y = 0; y < this.abRows - 2; y++) {
		outputPane.add(this.actionButtons[y][x]);
	    }
	}
    }

    @Override
    protected void reSetUpGUIHook(final Container outputPane) {
	this.handler = new EventHandler();
	outputPane.setLayout(new GridLayout(this.guiGridRows(), this.abRows));
	this.nameLabels = new JLabel[this.abCols];
	this.entryFields = new JTextField[this.abCols];
	this.entryLists = new ArrayList<>(this.abCols);
	for (int x = 0; x < this.abCols; x++) {
	    this.entryLists.add(x, new JComboBox<>(new String[] {}));
	}
	this.actionButtons = new JButton[this.abRows - 2][this.abCols];
	// Grid rows
	for (int x = 0; x < this.abCols; x++) {
	    // Create controls
	    this.nameLabels[x] = new JLabel();
	    this.guiNameLabelProperties(this.nameLabels[x], x);
	    final boolean entryType = this.guiEntryType(x);
	    if (entryType == AbstractObjectEditor.ENTRY_TYPE_LIST) {
		this.entryLists.set(x, new JComboBox<>(this.guiEntryListItems(x)));
		this.guiEntryListProperties(this.entryLists.get(x), x);
		if (this.isReadOnly()) {
		    this.entryLists.get(x).setEnabled(false);
		} else {
		    if (this.autoStore) {
			this.entryLists.get(x).setName(Integer.toString(x));
			this.entryLists.get(x).addFocusListener(this.handler);
		    }
		}
	    } else if (entryType == AbstractObjectEditor.ENTRY_TYPE_TEXT) {
		this.entryFields[x] = new JTextField();
		this.guiEntryFieldProperties(this.entryFields[x], x);
		if (this.isReadOnly()) {
		    this.entryFields[x].setEnabled(false);
		} else {
		    if (this.autoStore) {
			this.entryFields[x].setName(Integer.toString(x));
			this.entryFields[x].addFocusListener(this.handler);
		    }
		}
	    }
	    for (int y = 0; y < this.abRows - 2; y++) {
		this.actionButtons[y][x] = new JButton();
		this.guiActionButtonProperties(this.actionButtons[y][x], x, y);
		this.actionButtons[y][x].setActionCommand(this.guiActionButtonActionCommand(x, y));
		// Add action listener for button
		this.actionButtons[y][x].addActionListener(this.handler);
	    }
	    // Add controls
	    outputPane.add(this.nameLabels[x]);
	    if (entryType == AbstractObjectEditor.ENTRY_TYPE_LIST) {
		outputPane.add(this.entryLists.get(x));
	    } else if (entryType == AbstractObjectEditor.ENTRY_TYPE_TEXT) {
		outputPane.add(this.entryFields[x]);
	    }
	    for (int y = 0; y < this.abRows - 2; y++) {
		outputPane.add(this.actionButtons[y][x]);
	    }
	}
    }

    @Override
    protected void editObjectChanged() {
	// Do nothing
    }

    @Override
    protected void borderPaneHook() {
	// Do nothing
    }

    @Override
    public void redrawEditor() {
	// Do nothing
    }

    @Override
    public void switchToSubEditor() {
	// Do nothing
    }

    @Override
    public void switchFromSubEditor() {
	// Do nothing
    }

    private class EventHandler implements ActionListener, FocusListener {
	public EventHandler() {
	    // Do nothing
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
	    final AbstractObjectEditor ge = AbstractObjectEditor.this;
	    try {
		final String cmd = e.getActionCommand().substring(0, ge.actionCmdLen);
		final int num = Integer.parseInt(e.getActionCommand().substring(ge.actionCmdLen));
		ge.handleButtonClick(cmd, num);
		if (ge.autoStore) {
		    if (ge.guiEntryType(num) == AbstractObjectEditor.ENTRY_TYPE_LIST) {
			final JComboBox<String> list = ge.getEntryList(num);
			ge.autoStoreEntryListValue(list, num);
		    } else if (ge.guiEntryType(num) == AbstractObjectEditor.ENTRY_TYPE_TEXT) {
			final JTextField entry = ge.getEntryField(num);
			ge.autoStoreEntryFieldValue(entry, num);
		    }
		}
	    } catch (final NumberFormatException nfe) {
		CommonDialogs.showErrorDialog("An invalid value was entered.", ge.getEditorSource());
	    } catch (final Exception ex) {
		Boot.getErrorLogger().logError(ex);
	    }
	}

	@Override
	public void focusGained(final FocusEvent fe) {
	    // Do nothing
	}

	@Override
	public void focusLost(final FocusEvent fe) {
	    final AbstractObjectEditor ge = AbstractObjectEditor.this;
	    try {
		final Component comp = fe.getComponent();
		if (comp.getClass().equals(JTextField.class)) {
		    final JTextField entry = (JTextField) comp;
		    final int num = Integer.parseInt(entry.getName());
		    ge.autoStoreEntryFieldValue(entry, num);
		} else if (comp.getClass().equals(JComboBox.class)) {
		    @SuppressWarnings("unchecked")
		    final JComboBox<String> list = (JComboBox<String>) comp;
		    final int num = Integer.parseInt(list.getName());
		    ge.autoStoreEntryListValue(list, num);
		}
	    } catch (final NumberFormatException nfe) {
		CommonDialogs.showErrorDialog("An invalid value was entered.", ge.getEditorSource());
	    } catch (final Exception ex) {
		Boot.getErrorLogger().logError(ex);
	    }
	}
    }
}
