// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.maven.tools.creator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.eclipse.core.resources.IFile;
import org.talend.core.model.general.ModuleNeeded;
import org.talend.core.model.general.ModuleNeeded.ELibraryInstallStatus;
import org.talend.core.runtime.projectsetting.IProjectSettingTemplateConstants;
import org.talend.designer.maven.utils.PomUtil;

/**
 * DOC ggu class global comment. Detailled comment
 */
public abstract class AbstractMavenCodesTemplatePom extends AbstractMavenGeneralTemplatePom {

    public AbstractMavenCodesTemplatePom(IFile pomFile) {
        super(pomFile, IProjectSettingTemplateConstants.POM_CODES_TEMPLATE_FILE_NAME);
    }

    @Override
    protected Model createModel() {
        final Model templateModel = getTemplateModel();

        this.setGroupId(templateModel.getGroupId());
        this.setArtifactId(templateModel.getArtifactId());
        this.setVersion(templateModel.getVersion());
        this.setName(templateModel.getName());

        setAttributes(templateModel);
        addProperties(templateModel);

        PomUtil.checkParent(templateModel, this.getPomFile());

        addDependencies(templateModel);

        return templateModel;
    }

    protected abstract Model getTemplateModel();

    protected void addDependencies(Model model) {
        Set<ModuleNeeded> runningModules = getDependenciesModules();
        if (runningModules != null) {
            List<Dependency> existedDependencies = model.getDependencies();
            if (existedDependencies == null) {
                existedDependencies = new ArrayList<Dependency>();
                model.setDependencies(existedDependencies);
            }

            for (ModuleNeeded module : runningModules) {
                Dependency dependency = null;
                if (module.getStatus() != ELibraryInstallStatus.NOT_INSTALLED) {
                    dependency = PomUtil.createModuleDependency(module.getMavenUri(true));
                }
                if (dependency != null) {
                    existedDependencies.add(dependency);
                }
            }
        }
    }

    protected abstract Set<ModuleNeeded> getDependenciesModules();
}
