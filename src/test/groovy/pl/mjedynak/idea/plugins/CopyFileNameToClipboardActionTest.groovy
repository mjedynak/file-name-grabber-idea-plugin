package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.vfs.VirtualFile
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import static org.mockito.BDDMockito.given
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.verify
import static org.mockito.BDDMockito.*
import java.awt.datatransfer.StringSelection

@RunWith(MockitoJUnitRunner)
class CopyFileNameToClipboardActionTest extends GroovyTestCase {

    CopyFileNameToClipboardAction action

    @Mock
    AnActionEvent event

    @Test
    void copies_file_name_when_file_exists() {
        // given
        CopyPasteManager copyPasteManager = mock(CopyPasteManager)
        action = new CopyFileNameToClipboardAction() {
            @Override
            CopyPasteManager getCopyPasteManager() {
                copyPasteManager
            }
        }
        VirtualFile file = mock(VirtualFile)

        given(event.getData(PlatformDataKeys.VIRTUAL_FILE)).willReturn(file)

        // when
        action.actionPerformed(event)
        
        // then
        verify(copyPasteManager).setContents(any(StringSelection))
    }
}
