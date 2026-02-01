package io.github.hendrawd.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.hendrawd.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantScreen(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = Modifier
                .weight(weight = 1F)
        ) {
            ComposeQuadrantBox(
                backgroundColorRes = R.color.top_left,
                titleRes = R.string.top_left_title,
                descRes = R.string.top_left_desc,
                modifier = Modifier
                    .weight(weight = 1F)
            )
            ComposeQuadrantBox(
                backgroundColorRes = R.color.top_right,
                titleRes = R.string.top_right_title,
                descRes = R.string.top_right_desc,
                modifier = Modifier
                    .weight(weight = 1F)
            )
        }
        Row(
            modifier = Modifier
                .weight(weight = 1F)
        ) {
            ComposeQuadrantBox(
                backgroundColorRes = R.color.bottom_left,
                titleRes = R.string.bottom_left_title,
                descRes = R.string.bottom_left_desc,
                modifier = Modifier
                    .weight(weight = 1F)
            )
            ComposeQuadrantBox(
                backgroundColorRes = R.color.bottom_right,
                titleRes = R.string.bottom_right_title,
                descRes = R.string.bottom_right_desc,
                modifier = Modifier
                    .weight(weight = 1F)
            )
        }
    }
}

@Composable
fun ComposeQuadrantBox(
    @ColorRes backgroundColorRes: Int,
    @StringRes titleRes: Int,
    @StringRes descRes: Int,
    modifier: Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                colorResource(backgroundColorRes)
            )
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(titleRes),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(descRes),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantScreenPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantScreen()
    }
}
