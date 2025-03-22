package com.example.androidlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidlab2.ui.theme.AndroidLab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val artwork = rememberSaveable { mutableIntStateOf(R.drawable.apple_image) }
            val artworkTitle = rememberSaveable { mutableIntStateOf(R.string.apple_title) }
            val artworkAuthor = rememberSaveable { mutableIntStateOf(R.string.apple_author) }
            AndroidLab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(artwork,
                        artworkTitle,
                        artworkAuthor,
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpace(artwork: MutableIntState,
             artworkTitle: MutableIntState,
             artworkAuthor: MutableIntState,
             modifier: Modifier = Modifier) {
    val image = painterResource(artwork.intValue)
    val title = stringResource(artworkTitle.intValue)
    val author = stringResource(artworkAuthor.intValue)
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
    ) {
        var W = maxWidth
        var P = 10.dp
        if (maxWidth > maxHeight)
        {
            W = 400.dp
            P = 0.dp
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(
                    start = 25.dp,
                    end = 25.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .weight(5f)
                    .width(W)
            ) {
                Surface(
                    tonalElevation = 5.dp,
                    shadowElevation = 5.dp,
                    shape = CutCornerShape(5),
                    border = BorderStroke(2.dp, Brush.sweepGradient(
                        0.0f to Color. Red,
                        0.3f to Color. Green,
                        1.0f to Color. Blue,
                        center = Offset(0.0f, 100.0f)
                    )),
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(20.dp)
                            .width(W)
                    )
                }
            }
//            Spacer(
//                modifier = Modifier.size(90.dp)
//            )
            Surface(
                tonalElevation = 5.dp,
                shape = CutCornerShape(5),
                border = BorderStroke(2.dp, Brush.sweepGradient(
                    0.0f to Color. Red,
                    0.3f to Color. Green,
                    1.0f to Color. Blue,
                    center = Offset(0.0f, 100.0f)
                )),
                modifier = Modifier
                    .width(W)
                    .weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = author
                    )
                }
            }
            Spacer(
                modifier = Modifier.size(P)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Button(
                    onClick = {
                        when(artwork.intValue) {
                            R.drawable.apple_image -> {
                                artwork.intValue = R.drawable.ship
                                artworkTitle.intValue = R.string.ship_title
                                artworkAuthor.intValue = R.string.ship_author
                            }
                            R.drawable.stranger -> {
                                artwork.intValue = R.drawable.apple_image
                                artworkTitle.intValue = R.string.apple_title
                                artworkAuthor.intValue = R.string.apple_author
                            }
                            R.drawable.island -> {
                                artwork.intValue = R.drawable.stranger
                                artworkTitle.intValue = R.string.stranger_title
                                artworkAuthor.intValue = R.string.stranger_author
                            }
                            R.drawable.ophelia -> {
                                artwork.intValue = R.drawable.island
                                artworkTitle.intValue = R.string.island_title
                                artworkAuthor.intValue = R.string.island_author
                            }
                            R.drawable.ship -> {
                                artwork.intValue = R.drawable.ophelia
                                artworkTitle.intValue = R.string.ophelia_title
                                artworkAuthor.intValue = R.string.ophelia_author
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Назад"
                    )
                }
                Button(
                    onClick = {
                        when(artwork.intValue) {
                            R.drawable.apple_image -> {
                                artwork.intValue = R.drawable.stranger
                                artworkTitle.intValue = R.string.stranger_title
                                artworkAuthor.intValue = R.string.stranger_author
                            }
                            R.drawable.stranger -> {
                                artwork.intValue = R.drawable.island
                                artworkTitle.intValue = R.string.island_title
                                artworkAuthor.intValue = R.string.island_author
                            }
                            R.drawable.island -> {
                                artwork.intValue = R.drawable.ophelia
                                artworkTitle.intValue = R.string.ophelia_title
                                artworkAuthor.intValue = R.string.ophelia_author
                            }
                            R.drawable.ophelia -> {
                                artwork.intValue = R.drawable.ship
                                artworkTitle.intValue = R.string.ship_title
                                artworkAuthor.intValue = R.string.ship_author
                            }
                            R.drawable.ship -> {
                                artwork.intValue = R.drawable.apple_image
                                artworkTitle.intValue = R.string.apple_title
                                artworkAuthor.intValue = R.string.apple_author
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Вперёд"
                    )
                }
            }
//            Spacer(
//                modifier = Modifier.size(30.dp)
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    AndroidLab2Theme {
        ArtSpace(
            rememberSaveable { mutableIntStateOf(R.drawable.apple_image) },
            rememberSaveable { mutableIntStateOf(R.string.apple_title) },
            rememberSaveable { mutableIntStateOf(R.string.apple_author) }
        )
    }
}