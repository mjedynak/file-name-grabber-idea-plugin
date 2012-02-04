package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import spock.lang.Specification

class CopyFileNameToClipboardActionSpecification extends Specification {

    CopyFileNameToClipboardAction copyFileNameToClipboardAction = new CopyFileNameToClipboardAction()
    FileNameCopier fileNameCopier = Mock(FileNameCopier)
    AnActionEvent event = Mock(AnActionEvent)

    def setup() {
        copyFileNameToClipboardAction.fileNameCopier = fileNameCopier
    }


    def "delegates handling action to file name copier"() {
        when:
        copyFileNameToClipboardAction.actionPerformed(event)

        then:
        1 * fileNameCopier.copyFileName(event)
    }
}
