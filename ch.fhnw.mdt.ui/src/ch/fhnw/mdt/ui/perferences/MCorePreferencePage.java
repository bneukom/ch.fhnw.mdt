package ch.fhnw.mdt.ui.perferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;

public class MCorePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Create the preference page.
	 */
	public MCorePreferencePage() {
		super(FLAT);
		setTitle("MCore Preferences");
	}

	/**
	 * Create contents of the preference page.
	 */
	@Override
	protected void createFieldEditors() {
		{
			StringFieldEditor stringFieldEditor = new StringFieldEditor("id", "Device Port", -1, StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent());
			stringFieldEditor.setStringValue("/dev/ttyUSB0");
			addField(stringFieldEditor);
		}
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference page
	}

}
