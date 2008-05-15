// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.ui.action.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.cheatsheets.ICheatSheetAction;
import org.eclipse.ui.cheatsheets.ICheatSheetManager;
import org.talend.dataprofiler.core.ImageLib;
import org.talend.dataprofiler.core.ui.wizard.database.DatabaseConnectionWizard;


/**
 * DOC zqin  class global comment. Detailled comment
 * <br/>
 *
 * $Id: talend.epf 1 2006-09-29 17:06:40Z zqin $
 *
 */
public class CreateConnectionAction extends Action implements ICheatSheetAction {

    public CreateConnectionAction() {
        super("Create a new connection");
        setImageDescriptor(ImageLib.getImageDescriptor(ImageLib.NEW_CONNECTION));
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {

        DatabaseConnectionWizard wizard = new DatabaseConnectionWizard(PlatformUI.getWorkbench(), true, null, null);
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog dialog = new WizardDialog(null, wizard);
        dialog.setPageSize(600, 355);
        dialog.open();
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.cheatsheets.ICheatSheetAction#run(java.lang.String[], org.eclipse.ui.cheatsheets.ICheatSheetManager)
     */
    public void run(String[] params, ICheatSheetManager manager) {
        // TODO Auto-generated method stub
        run();
    }

}
