package commentStyles.implementations

import com.dulejo.uncommentplugin.commentStyles.ICommentStyle
import commentStyles.CommentStyle

class HtmlCommentStyle : ICommentStyle {
    override fun uncommentLine(line: String): String {
        val leadingWhitespace = line.takeWhile { it == ' ' || it == '\t' }
        val trimmed = line.trimStart()

        return if (trimmed.startsWith("<!--") && trimmed.endsWith("-->")) {
            val uncommentedContent = trimmed
                .removePrefix("<!--")
                .removeSuffix("-->")
                .trim()
            leadingWhitespace + uncommentedContent
        } else {
            line
        }
    }
}