package pl.mjedynak.idea.plugins;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;

import java.awt.datatransfer.StringSelection;


public class CopyFileNameToClipboardAction extends AnAction implements DumbAware {
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file != null) {
            StringSelection stringSelection = new StringSelection(file.getName());
            CopyPasteManager instance = getCopyPasteManager();
            instance.setContents(stringSelection);
        }
    }

    CopyPasteManager getCopyPasteManager() {
        return CopyPasteManager.getInstance();
    }
}
