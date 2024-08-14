package org.jetbrains.jewel.markdown.extensions.tables

import org.commonmark.ext.gfm.tables.TableBody
import org.commonmark.ext.gfm.tables.TableHead
import org.jetbrains.jewel.markdown.MarkdownBlock

public sealed interface Table : MarkdownBlock.CustomBlock {

    // TODO should we make these our own TableHead and TableBody objects?
    public data class TableBlock(val header: TableHead, val body: TableBody?) : Table

}