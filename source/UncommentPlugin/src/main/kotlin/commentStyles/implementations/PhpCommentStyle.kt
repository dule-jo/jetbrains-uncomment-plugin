package commentStyles.implementations

class PhpCommentStyle : DoubleSlashCommentStyle() {
    val commentPossibilities = listOf("#", "//");

    override fun uncommentLine(line: String): String {
        val prefix = commentPossibilities.firstOrNull { line.startsWith(it) }
        return if (prefix != null) line.removePrefix(prefix) else line
    }
}