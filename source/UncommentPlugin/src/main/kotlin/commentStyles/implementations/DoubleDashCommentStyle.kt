package commentStyles.implementations

import com.dulejo.uncommentplugin.commentStyles.ICommentStyle
import commentStyles.CommentStyle

class DoubleDashCommentStyle : CommentStyle() {
    override val comment: String
        get() = "--"
}