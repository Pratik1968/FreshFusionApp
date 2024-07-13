package com.pratikshekhar.myproject.freshfusion.presentation.screens.login.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.pratikshekhar.myproject.freshfusion.presentation.viewmodel.LoginViewModel
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Dark
import com.pratikshekhar.myproject.freshfusion.presentation.theme.LightGrey
import com.pratikshekhar.myproject.freshfusion.presentation.theme.Typography

@Preview
@Composable
private  fun Preview(){
    PhoneNumberInput(viewModel = LoginViewModel())
}
@Composable
  fun PhoneNumberInput(modifier: Modifier=Modifier,viewModel: LoginViewModel){

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically){
        Text("+91", style = Typography.titleLarge.copy(if (viewModel.states.placeholderVisible)  LightGrey else Dark))

        InnerInput(value = viewModel.states.phoneNumber, updateValue = {
            viewModel.setPhoneNumber(it)
        }, textStyle = Typography.titleLarge.copy(if (viewModel.states.placeholderVisible)  LightGrey else Dark))
       
    }
}
@Composable
private  fun InnerInput(
    modifier: Modifier = Modifier,
    value:String,
    updateValue:(String)->Unit,
    onValueChange: (String) -> Unit={},
    enabled: Boolean = false,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    cursorBrush: Brush = SolidColor(Color.Black),
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit = @Composable { innerTextField -> innerTextField() }
) {



            BasicTextField(modifier = modifier,
        value = value,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        maxLines = maxLines,
        minLines = minLines,
        visualTransformation = visualTransformation,
        onTextLayout = onTextLayout,
        cursorBrush = cursorBrush,
        decorationBox = decorationBox,
        onValueChange = {
            updateValue(it)
            onValueChange(it)
        },
    )

}