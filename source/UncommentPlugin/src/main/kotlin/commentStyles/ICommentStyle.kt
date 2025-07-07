package com.dulejo.uncommentlines.commentStyles

interface ICommentStyle {
    fun uncommentLine(line: String): String
}