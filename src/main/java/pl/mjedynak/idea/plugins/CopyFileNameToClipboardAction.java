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
        VirtualFile file = PlatformDataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        if (file != null) {
            StringSelection stringSelection = new StringSelection(file.getName());
            CopyPasteManager.getInstance().setContents(stringSelection);
        }
    }
}
