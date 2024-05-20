package com.pratikshekhar.myproject.freshfusion.ui.screens.Composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathEffect.Companion.dashPathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.pratikshekhar.myproject.freshfusion.ui.theme.Typography

@Preview(showBackground =true)
@Composable
fun PreviewDotted(){
  //  DottedBorderInput(setValue = null)
}
@Composable
fun DottedBorderInput(
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    onValueChange:(String)->Unit,
    color: Color = Color.Black,
    fontSize :TextUnit = Typography.bodyMedium.fontSize
    ){
    val stroke = Stroke(width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    Box(
        modifier
            .padding(vertical = 10.dp)
            .drawBehind {
                val strokeWidth = 4f // Adjust stroke width as needed
                val y = size.height - strokeWidth / 2f // Calculate bottom position
                val pathEffect = dashPathEffect(
                    intervals = floatArrayOf(4f, 8f),
                    phase = 0f
                ) // Dotted line pattern

                drawLine(
                    color = Color.Gray, // Change color as desired
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth,
                    pathEffect = pathEffect
                )
            },
        contentAlignment = Alignment.Center
    ){BasicInput(onValueChange ={
       onValueChange(it)
    }
        ,placeholder = "", modifier = Modifier, maxLines = maxLines, textStyle = Typography.bodyMedium.copy(color = color,fontSize = fontSize))}
}

