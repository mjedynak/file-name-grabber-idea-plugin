package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.vfs.VirtualFile
import java.awt.datatransfer.StringSelection
import static com.intellij.openapi.actionSystem.PlatformDataKeys.VIRTUAL_FILE

class FileNameCopier {

    void copyFileName(AnActionEvent event) {
        VirtualFile file = event.getData(VIRTUAL_FILE)
        if (file != null) {
            StringSelection stringSelection = new StringSelection(file.name)
            CopyPasteManager copyPasteManager = CopyPasteManager.getInstance()
            copyPasteManager.contents = stringSelection
        }
    }
}
