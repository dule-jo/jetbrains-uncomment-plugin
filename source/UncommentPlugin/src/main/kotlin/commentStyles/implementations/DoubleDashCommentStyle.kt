package commentStyles.implementations

import commentStyles.CommentStyle

class DoubleDashCommentStyle : CommentStyle() {
    override val comment: String
        get() = "--"
}