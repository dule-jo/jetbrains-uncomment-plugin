package commentStyles.implementations

import commentStyles.CommentStyle

class HashCommentStyle : CommentStyle() {
    override val comment: String
        get() = "#"
}