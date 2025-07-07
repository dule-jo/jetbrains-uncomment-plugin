package com.dulejo.uncommentplugin.commentStyles

interface ICommentStyle {
    fun uncommentLine(line: String): String
}