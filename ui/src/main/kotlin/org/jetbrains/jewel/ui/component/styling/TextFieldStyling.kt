package org.jetbrains.jewel.ui.component.styling

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import org.jetbrains.jewel.foundation.GenerateDataFunctions

@Stable
@GenerateDataFunctions
class TextFieldStyle(
    override val colors: TextFieldColors,
    override val metrics: TextFieldMetrics,
    override val textStyle: TextStyle,
) : InputFieldStyle {

    companion object
}

@Immutable
@GenerateDataFunctions
class TextFieldColors(
    override val background: Color,
    override val backgroundDisabled: Color,
    override val backgroundFocused: Color,
    override val backgroundPressed: Color,
    override val backgroundHovered: Color,
    override val content: Color,
    override val contentDisabled: Color,
    override val contentFocused: Color,
    override val contentPressed: Color,
    override val contentHovered: Color,
    override val border: Color,
    override val borderDisabled: Color,
    override val borderFocused: Color,
    override val borderPressed: Color,
    override val borderHovered: Color,
    override val caret: Color,
    override val caretDisabled: Color,
    override val caretFocused: Color,
    override val caretPressed: Color,
    override val caretHovered: Color,
    val placeholder: Color,
) : InputFieldColors {

    companion object
}

@Stable
@GenerateDataFunctions
class TextFieldMetrics(
    override val borderWidth: Dp,
    override val contentPadding: PaddingValues,
    override val cornerSize: CornerSize,
    override val minSize: DpSize,
) : InputFieldMetrics {

    companion object
}

val LocalTextFieldStyle = staticCompositionLocalOf<TextFieldStyle> {
    error("No TextFieldStyle provided")
}