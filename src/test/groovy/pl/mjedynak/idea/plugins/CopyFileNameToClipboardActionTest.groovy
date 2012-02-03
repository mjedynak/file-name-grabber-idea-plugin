package pl.mjedynak.idea.plugins

import com.intellij.openapi.actionSystem.AnActionEvent
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.springframework.test.util.ReflectionTestUtils
import static org.mockito.Mockito.verify

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

    @Ignore //http://code.google.com/p/mockito/issues/detail?id=303
    @Test
    void shouldDelegateHandlingActionToFileNameCopier() {
        // when
        copyFileNameToClipboardAction.actionPerformed(event)

        // then
        verify(fileNameCopier).copyFileName(event)
    }
}
