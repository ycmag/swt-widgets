/*******************************************************************************
 * Copyright (c) 2011 Laurent CARON
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Laurent CARON (laurent.caron at gmail dot com) - initial API and implementation
 *     Haixing Hu (https://github.com/Haixing-Hu/)  - Modification for personal use.
 *******************************************************************************/
package com.github.haixing_hu.swt.window;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.github.haixing_hu.swt.utils.SWTResourceManager;
import com.github.haixing_hu.swt.utils.SWTUtils;

/**
 * This snippet demonstrates the {@link PanelHeader} widget.
 */
public class PanelHeaderExample {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));

		final Image icon = SWTResourceManager.getImage(PanelHeaderExample.class,
		    "/images/configure.png");

		shell.setText("PanelHeader Example");
		shell.setLayout(new GridLayout(2, false));

		final PanelHeader header = new PanelHeader(shell, SWT.NONE);
		header.setTitle("PanelHeader Title");
		header.setImage(icon);
		header.setDescription("Description area for the header. You can put all "
		    + "<b>additional</b>, <i>relevant information</i> to the "
		    + "description panel (or <u>jokes</u>, citations, "
		    + "... <color=red>what you want!</color>)");
		header.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, 2, 1));

		createRow(shell, "First Name");
		createRow(shell, "Last Name");
		createRow(shell, "E-mail");
		createRow(shell, "Phone number");

		shell.setSize(640, 350);
		SWTUtils.centerShell(shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		SWTResourceManager.dispose();
		display.dispose();
	}

	private static void createRow(final Shell shell, final String label) {
		final Label lbl = new Label(shell, SWT.NONE);
		lbl.setText(label);
		lbl.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));

		final Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

}
