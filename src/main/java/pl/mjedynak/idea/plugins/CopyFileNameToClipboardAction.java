package pl.mjedynak.idea.plugins;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;


public class CopyFileNameToClipboardAction extends AnAction implements DumbAware {
    private static FileNameCopier fileNameCopier = new FileNameCopier();
    
    public void actionPerformed(AnActionEvent e) {
        fileNameCopier.copyFileName(e);
    }

}
