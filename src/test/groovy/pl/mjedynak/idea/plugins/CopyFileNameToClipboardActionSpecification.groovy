package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import org.springframework.test.util.ReflectionTestUtils
import spock.lang.Specification

class CopyFileNameToClipboardActionSpecification extends Specification {

    def "delegates handling action to file name copier"() {
        FileNameCopier fileNameCopier = Mock(FileNameCopier)
        AnActionEvent event = Mock(AnActionEvent)
        CopyFileNameToClipboardAction copyFileNameToClipboardAction = new CopyFileNameToClipboardAction()
        ReflectionTestUtils.setField(copyFileNameToClipboardAction, "fileNameCopier", fileNameCopier)

        when:
        copyFileNameToClipboardAction.actionPerformed(event)

        then:
        1 * fileNameCopier.copyFileName(event)
    }
}
