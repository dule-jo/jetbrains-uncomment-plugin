package com.dulejo.uncommentplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import commentStyles.implementations.DoubleDashCommentStyle
import commentStyles.implementations.DoubleSlashCommentStyle
import commentStyles.implementations.HashCommentStyle
import commentStyles.implementations.PhpCommentStyle

class UncommentAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val project = e.getData(CommonDataKeys.PROJECT) ?: return
        val document = editor.document
        val selectionModel = editor.selectionModel

        val startOffset = selectionModel.selectionStart
        val endOffset = selectionModel.selectionEnd

        val startLine = document.getLineNumber(startOffset)
        val endLine = document.getLineNumber(endOffset)

        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        val lang = psiFile.language.id.lowercase()
        val commentStyle = when (lang) {
            "sql", "hs", "lua", "rb" -> DoubleDashCommentStyle()
            "cs", "csharp", "java", "kt", "c", "cpp", "js", "ts" -> DoubleSlashCommentStyle()
            "py", "sh", "pl" -> HashCommentStyle()
            "php" -> PhpCommentStyle()
            else -> null
        }

        if (commentStyle != null) {
            WriteCommandAction.runWriteCommandAction(project) {
                for (lineNum in startLine..endLine) {
                    val lineStartOffset = document.getLineStartOffset(lineNum)
                    val lineEndOffset = document.getLineEndOffset(lineNum)
                    val lineText = document.getText(com.intellij.openapi.util.TextRange(lineStartOffset, lineEndOffset))

                    val uncommented = commentStyle.uncommentLine(lineText)

                    document.replaceString(lineStartOffset, lineEndOffset, uncommented)
                }
            }
        }
    }
}