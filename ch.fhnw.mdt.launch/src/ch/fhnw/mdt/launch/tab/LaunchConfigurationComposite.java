package ch.fhnw.mdt.launch.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LaunchConfigurationComposite extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LaunchConfigurationComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Group grpProject = new Group(this, SWT.NONE);
		grpProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpProject.setText("Project:");
		grpProject.setLayout(new GridLayout(2, false));
		
		text = new Text(grpProject, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnBrowse = new Button(grpProject, SWT.NONE);
		btnBrowse.setText("Browse...");
		
		Group grpFile = new Group(this, SWT.NONE);
		grpFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpFile.setText("File:");
		grpFile.setLayout(new GridLayout(2, false));
		
		text_1 = new Text(grpFile, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSearch = new Button(grpFile, SWT.NONE);
		btnSearch.setText("Search...");
		
		Group grpTargetDevice = new Group(this, SWT.NONE);
		grpTargetDevice.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpTargetDevice.setText("Target Device:");
		grpTargetDevice.setLayout(new GridLayout(2, false));
		
		Button btnCheckButton = new Button(grpTargetDevice, SWT.CHECK);
		btnCheckButton.setSelection(true);
		btnCheckButton.setText("Use Workspace Default");
		new Label(grpTargetDevice, SWT.NONE);
		
		text_2 = new Text(grpTargetDevice, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_1 = new Button(grpTargetDevice, SWT.NONE);
		button_1.setEnabled(false);
		button_1.setText("Browse...");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
