package pl.mjedynak.idea.plugins

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import org.springframework.test.util.ReflectionTestUtils
import org.mockito.Mock
import com.intellij.openapi.actionSystem.AnActionEvent
import static org.mockito.Mockito.verify
import org.junit.Ignore

@RunWith(MockitoJUnitRunner)
class CopyFileNameToClipboardActionTest {

    CopyFileNameToClipboardAction copyFileNameToClipboardAction
    @Mock FileNameCopier fileNameCopier
    @Mock AnActionEvent event

    @Before
    void setUp() {
        copyFileNameToClipboardAction = new CopyFileNameToClipboardAction()
        ReflectionTestUtils.setField(copyFileNameToClipboardAction, "fileNameCopier", fileNameCopier)

    }


    @Ignore
    @Test
    void shouldDelegateHandlingActionToFileNameCopier() {
        // when
        copyFileNameToClipboardAction.actionPerformed(event)

        // then
        verify(fileNameCopier).copyFileName(event)
    }
}
