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
import org.talend.dataprofiler.core.ui.wizard.analysis.CreateNewAnalysisWizard;


/**
 * DOC zqin  class global comment. Detailled comment
 * <br/>
 *
 * $Id: talend.epf 1 2006-09-29 17:06:40Z zqin $
 *
 */
public class CreateNewAnalysisAction extends Action implements ICheatSheetAction {

    public CreateNewAnalysisAction() {
        super("New Analysis");
        setImageDescriptor(ImageLib.getImageDescriptor(ImageLib.ACTION_NEW_ANALYSIS));
    }
    
    
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {

        try {
            CreateNewAnalysisWizard wizard = new CreateNewAnalysisWizard(PlatformUI.getWorkbench(), true, null, null);
            wizard.setForcePreviousAndNextButtons(true);
            
            WizardDialog dialog = new WizardDialog(null, wizard);
            dialog.setPageSize(500, 340);
            dialog.create();

            
            dialog.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /* (non-Javadoc)
     * @see org.eclipse.ui.cheatsheets.ICheatSheetAction#run(java.lang.String[], org.eclipse.ui.cheatsheets.ICheatSheetManager)
     */
    public void run(String[] params, ICheatSheetManager manager) {
        // TODO Auto-generated method stub
        run();
    }

}
