package commentStyles.implementations

import com.dulejo.uncommentplugin.commentStyles.ICommentStyle
import commentStyles.CommentStyle

open class DoubleSlashCommentStyle : CommentStyle() {
    override val comment: String
        get() = "//"
}