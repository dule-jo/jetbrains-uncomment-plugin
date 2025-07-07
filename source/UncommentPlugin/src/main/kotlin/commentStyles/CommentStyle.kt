package commentStyles

import com.dulejo.uncommentplugin.commentStyles.ICommentStyle

abstract class CommentStyle : ICommentStyle {
    abstract val comment: String

    override fun uncommentLine(line: String): String {
        val leadingWhitespace = line.takeWhile { it == ' ' || it == '\t' }
        val trimmed = line.trimStart()
        return if (trimmed.startsWith(comment)) {
            leadingWhitespace + trimmed.removePrefix(comment).trimStart()
        } else {
            line
        }
    }
}