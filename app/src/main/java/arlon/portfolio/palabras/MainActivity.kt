package arlon.portfolio.palabras

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import arlon.portfolio.palabras.ui.theme.DarkRed
import arlon.portfolio.palabras.ui.theme.PalabrasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PalabrasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen {
                        Toast.makeText(MainActivity@this, "TESTING", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(clickFunction: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var state by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_conversation),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .aspectRatio(1.0f)
            )

            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(top = 12.dp),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = DarkRed,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (speakerIcon) = createRefs()

            if (!state) {
                IconButton(
                    onClick = { /*state = !state*/clickFunction() },
                    modifier = Modifier.constrainAs(speakerIcon) {
                        top.linkTo(parent.top, margin = 12.dp)
                        end.linkTo(parent.end, margin = 12.dp)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        tint = DarkRed,
                        contentDescription = null,
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp),
                    )
                }
            }
        }

        if (state) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .aspectRatio(1.0f),
                elevation = CardDefaults.cardElevation(8.0.dp),
                shape = RoundedCornerShape(4.0.dp),
                border = BorderStroke(4.0.dp, Color.Yellow),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.End
                ) {
                    IconButton(
                        onClick = { state = !state },
                        modifier = Modifier.padding(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            tint = DarkRed,
                            contentDescription = null,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp),
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    PalabrasTheme {
        SplashScreen({})
    }
}