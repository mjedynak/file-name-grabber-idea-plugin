package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.vfs.VirtualFile
import spock.lang.Specification
import com.intellij.openapi.actionSystem.PlatformDataKeys
import java.awt.datatransfer.StringSelection

class FileNameCopierSpecification extends Specification {

    FileNameCopier copier = new FileNameCopier()
    AnActionEvent event = Mock()
    VirtualFile file = Mock()
    CopyPasteManager copyPasteManager = Mock()

    def "copies filename when file exists"() {
        event.getData(PlatformDataKeys.VIRTUAL_FILE) >> file
        CopyPasteManager.metaClass.'static'.getInstance = { copyPasteManager }

        when:
        copier.copyFileName event

        then:
        1 * copyPasteManager.setContents(_ as StringSelection)
    }

    def "does nothing when file does not exist"() {
        when:
        copier.copyFileName event

        then:
        0 * copyPasteManager._ // no (more) method call
    }
}
