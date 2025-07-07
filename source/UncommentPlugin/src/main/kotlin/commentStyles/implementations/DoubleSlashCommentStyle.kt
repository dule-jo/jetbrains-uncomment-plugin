package commentStyles.implementations

import commentStyles.CommentStyle

open class DoubleSlashCommentStyle : CommentStyle() {
    override val comment: String
        get() = "//"
}