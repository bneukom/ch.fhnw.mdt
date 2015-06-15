package ch.fhnw.mdt.launch.tab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.eclipse.cdt.managedbuilder.core.IManagedBuildInfo;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.ui.CElementLabelProvider;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import ch.fhnw.mdt.build.nature.McoreNatureCore;

public class LaunchConfigurationComposite extends Composite {
	private final Text projectNameText;
	private final Text executableFilePathText;
	private final Text targetDeviceNameText;

	private IProject project;
	private IResource executableResource;
	private final Button searchFileButton;

	private static final String MCORE_EXECUTABLE_FILE_EXTENSION = "fs";
	private MCoreLaunchConfigurationTab mCoreLaunchConfigurationTab;

	/**
	 * Create the composite.
	 * 
	 * @param mCoreLaunchConfigurationTab
	 * @param parent
	 * @param style
	 */
	public LaunchConfigurationComposite(MCoreLaunchConfigurationTab mCoreLaunchConfigurationTab, final Composite parent, final int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		this.mCoreLaunchConfigurationTab = mCoreLaunchConfigurationTab;

		final Group grpProject = new Group(this, SWT.NONE);
		grpProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpProject.setText("Project:");
		grpProject.setLayout(new GridLayout(2, false));

		this.projectNameText = new Text(grpProject, SWT.BORDER);
		this.projectNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button browseProjectButton = new Button(grpProject, SWT.NONE);
		browseProjectButton.setText("Browse...");
		browseProjectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				updateProjectName(chooseMCoreProject());
			}
		});

		final Group grpFile = new Group(this, SWT.NONE);
		grpFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpFile.setText("File:");
		grpFile.setLayout(new GridLayout(2, false));

		this.executableFilePathText = new Text(grpFile, SWT.BORDER);
		this.executableFilePathText.setEnabled(false);
		this.executableFilePathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		this.searchFileButton = new Button(grpFile, SWT.NONE);
		this.searchFileButton.setEnabled(false);
		this.searchFileButton.setText("Search...");
		this.searchFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				updateExeutableFileName(chooseMCoreExecutableFile(project));
			}
		});

		final Group grpTargetDevice = new Group(this, SWT.NONE);
		grpTargetDevice.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpTargetDevice.setText("Target Device:");
		grpTargetDevice.setLayout(new GridLayout(2, false));

		final Button btnCheckButton = new Button(grpTargetDevice, SWT.CHECK);
		btnCheckButton.setEnabled(false);
		btnCheckButton.setSelection(true);
		btnCheckButton.setText("Use Workspace Default");
		new Label(grpTargetDevice, SWT.NONE);

		this.targetDeviceNameText = new Text(grpTargetDevice, SWT.BORDER);
		this.targetDeviceNameText.setEnabled(false);
		this.targetDeviceNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button browseDevice = new Button(grpTargetDevice, SWT.NONE);
		browseDevice.setEnabled(false);
		browseDevice.setText("Browse...");

	}

	/**
	 * Returns the current project name or an empty String if no project has
	 * been set.
	 * 
	 * @return
	 */
	public String getProjectName() {
		return projectNameText.getText();
	}

	/**
	 * Returns the current project or <code>null</code> if no project has been
	 * set.
	 * 
	 * @return
	 */
	public IProject getProject() {
		return project;
	}

	/**
	 * Returns the current executable file name or an empty String if no
	 * executable file has been set.
	 * 
	 * @return
	 */
	public String getExecutableFilePath() {
		return executableFilePathText.getText();
	}

	/**
	 * Returns the current executable file {@link IResource} or
	 * <code>null</code> if no executable file has been set.
	 * 
	 * @return
	 */
	public IResource getExecutableFile() {
		return executableResource;
	}

	/**
	 * Sets the project. If the project can not be found in the workspace, this
	 * method will do nothing.
	 * 
	 * @param projectName
	 */
	public void setProject(String projectName) {
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);

		updateProjectName(projectResource != null && projectResource instanceof IProject ? Optional.of((IProject) projectResource) : Optional.empty());
	}

	/**
	 * Sets the executable file. If no project has been set or the file can not
	 * be found in the project, this method will do nothing.
	 * 
	 * @param attribute
	 */
	public void setExecutableFile(String executableFilePath) {
		if (project == null) {
			return;
		}

		final IResource file = project.findMember(executableFilePath);
		if (file != null) {
			this.executableFilePathText.setText(executableFilePath);
			this.executableResource = (IResource) file;
		}
	}

	private void updateExeutableFileName(final Optional<IResource> resource) {
		resource.ifPresent(r -> this.executableFilePathText.setText(r.getProjectRelativePath().toString()));

		this.executableResource = resource.orElse(null);

		mCoreLaunchConfigurationTab.update();
	}

	private void updateProjectName(final Optional<IProject> project) {
		project.ifPresent(p -> {
			this.projectNameText.setText(p.getName());
			this.executableFilePathText.setText("");
			this.executableResource = null;
		});

		this.project = project.orElse(null);
		this.searchFileButton.setEnabled(project.isPresent());
		this.executableFilePathText.setEnabled(project.isPresent());

		mCoreLaunchConfigurationTab.update();
	}

	protected Optional<IResource> chooseMCoreExecutableFile(IProject project) {
		final IResource[] mCoreExecutableFiles = getMCoreExecutableResources(project);
		final ILabelProvider labelProvider = new CElementLabelProvider();
		final ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);

		dialog.setMessage("Choose MCore Executable File");
		dialog.setElements(mCoreExecutableFiles);

		if (dialog.open() == ElementListSelectionDialog.OK) {
			return Optional.of((IResource) dialog.getFirstResult());
		}
		return Optional.empty();
	}

	protected Optional<IProject> chooseMCoreProject() {
		final IProject[] mCoreProjects = getMCoreProjects();
		final ILabelProvider labelProvider = new CElementLabelProvider();
		final ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);

		dialog.setMessage("Choose MCore Project");
		dialog.setElements(mCoreProjects);

		if (dialog.open() == ElementListSelectionDialog.OK) {
			return Optional.of((IProject) dialog.getFirstResult());
		}
		return Optional.empty();
	}

	protected IResource[] getMCoreExecutableResources(final IProject mCoreProject) {
		try {
			final List<IResource> executableResource = new ArrayList<IResource>();
			mCoreProject.accept(r -> {
				if (r.getFileExtension() != null && r.getFileExtension().equals(MCORE_EXECUTABLE_FILE_EXTENSION)) {
					executableResource.add(r);
				}

				return true;
			});

			return executableResource.toArray(new IResource[0]);

		} catch (final CoreException e) {
			e.printStackTrace();
		}

		return new IResource[0];
	}

	protected IProject[] getMCoreProjects() {
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		return Arrays.stream(projects).filter(p -> p.isOpen()).filter(p -> {
			final IManagedBuildInfo buildInfo = ManagedBuildManager.getBuildInfo(p);
			return buildInfo.getManagedProject().getName().equals(McoreNatureCore.MCORE_EXECUTABLE_NAME);
		}).toArray(IProject[]::new);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
