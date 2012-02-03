package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.vfs.VirtualFile
import java.awt.datatransfer.StringSelection
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import static org.mockito.BDDMockito.given
import static org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner.class)
class FileNameCopierTest {

    FileNameCopier copier;

    @Mock AnActionEvent event
    @Mock VirtualFile file
    @Mock CopyPasteManager copyPasteManager

    @Before
    void setUp() {
        copier = new FileNameCopier()
    }

    @Test
    void shouldCopyFileNameWhenFileExists() {
        // given
        given(event.getData(PlatformDataKeys.VIRTUAL_FILE)).willReturn file
        CopyPasteManager.metaClass.'static'.getInstance = { copyPasteManager }

        // when
        copier.copyFileName event

        // then
        verify(copyPasteManager).setContents any(StringSelection)
    }

    @Test
    void shouldDoNothingWhenFileDoesNotExist() {
        // when
        copier.copyFileName event

        // then
        verifyZeroInteractions(copyPasteManager)
    }
}
