package com.udemycourse.tipcalculatorapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    label: String,
    enabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {
            valueState.value = it
        },
        modifier = modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp).fillMaxWidth(),
        enabled = enabled,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = MaterialTheme.colors.onBackground
        ),
        label = {
            Text(text = label)
        },
        singleLine = isSingleLine,
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.AttachMoney,
                contentDescription = "Money Icon")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction
    )
}

@Composable
fun RoundIconButton(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit,
    imageVector: ImageVector,
    backgroundColor: Color = MaterialTheme.colors.background,
    tint: Color = Color.Black.copy(alpha = 0.8f),
    elevation: Dp = 4.dp
) {
    Card(
        modifier = modifier.padding(4.dp).clickable { onClicked() }.then(Modifier.size(40.dp)),
        shape = CircleShape,
        backgroundColor = backgroundColor,
        elevation = elevation
    ) {
       Icon(
           imageVector = imageVector,
           contentDescription = "Plus Or Minus Icon",
           tint = tint
       )
    }
}