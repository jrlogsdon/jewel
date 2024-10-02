package org.jetbrains.jewel.markdown.extensions.tables

import junit.framework.TestCase.assertTrue
import org.commonmark.ext.gfm.tables.TableBlock
import org.commonmark.ext.gfm.tables.TableCell
import org.commonmark.ext.gfm.tables.TableHead
import org.commonmark.ext.gfm.tables.TableRow
import org.commonmark.node.BlockQuote
import org.commonmark.node.Document
import org.commonmark.node.Node
import org.commonmark.node.Paragraph
import org.commonmark.node.Text
import org.commonmark.parser.Parser
import org.commonmark.renderer.text.TextContentRenderer
import org.jetbrains.jewel.markdown.processing.MarkdownProcessor
import org.junit.Test

class GitHubTableProcessorExtensionTest {

    private val processor = MarkdownProcessor(listOf(GitHubTableProcessorExtension))

    /**
     * Make sure we can parse examples from [https://github.github.com/gfm/#tables-extension](gfm tables) correctly
     */
    @Test
    fun `should parse GFM table example 198`() {
        val parsed  = processor.processMarkdownDocument("""
            | foo | bar |
            | --- | --- |
            | baz | bim |
        """.trimIndent()
        )
        /*
         * Expected HTML:
         * <table>
         *  <thead>
         *      <tr>
         *          <th>foo</th>
         *          <th>bar</th>
         *      </tr>
         *  </thead>
         *  <tbody>
         *      <tr>
         *          <td>baz</td>
         *          <td>bim</td>
         *      </tr>
         *  </tbody>
         * </table>
         */
        val table = parsed[0] as Table.TableBlock

        assertTrue((table.header.firstChild.firstChild.firstChild as Text).literal == "foo")
        assertTrue((table.header.firstChild.lastChild.firstChild as Text).literal == "bar")
        assertTrue((table.body!!.firstChild.firstChild.firstChild as Text).literal == "baz")
        assertTrue((table.body!!.firstChild.lastChild.firstChild as Text).literal == "bim")
    }

    @Test
    fun `github table processor can process common mark TableBlocks`() {
        assertTrue(GitHubTableProcessorExtension.blockProcessorExtension.canProcess(TableBlock()))
    }

    @Test
    fun `table without body is still a Table$TableBlock`() {
        val rawMarkDown = """
            |Header 1|
            |:-------:|
        """.trimIndent()
        val parsed = processor.processMarkdownDocument(rawMarkDown)

        assertTrue((parsed[0] as Table.TableBlock).body == null)
    }

}
