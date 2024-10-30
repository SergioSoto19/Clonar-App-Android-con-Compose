package com.example.plutoclonecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlutoTVCloneApp()
        }
    }
}

@Composable
fun PlutoTVCloneApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(0.dp)
        ) {
            TopBar()
            VideoContainer()
            MenuCategories()
            ChannelList()
        }
        BottomBar()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pluto),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.transmitir),
                contentDescription = "Transmitir",
                modifier = Modifier.size(31.dp),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.usuario),
                contentDescription = "Perfil",
                modifier = Modifier.size(31.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun VideoContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.south),
            contentDescription = "Imagen del video",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun MenuCategories() {
    val buttonNames = listOf("Pluto TV", "Películas", "Series", "Retro", "Novelas", "Reality", "Competencia")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(buttonNames.size) { index ->
            Box(
                modifier = Modifier
                    .background(Color.Gray)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {  }
            ) {
                Text(
                    text = buttonNames[index],
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ChannelList() {
    val channels = listOf(
        ChannelData("Acción", R.drawable.cineaccion),
        ChannelData("Terror", R.drawable.cineterror),
        ChannelData("Suspenso", R.drawable.cinesuspenso),
        ChannelData("Drama", R.drawable.cinedrama),
        ChannelData("Comedia", R.drawable.cinecomedia),
        ChannelData("Romance", R.drawable.cineromance),
        ChannelData("South Park", R.drawable.southp),
        ChannelData("Detectives", R.drawable.dea),
        ChannelData("Naruto", R.drawable.naruto)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        items(channels.size) { index ->
            ChannelItem(channel = channels[index])
        }
    }
}
data class ChannelData(val name: String, val imageRes: Int)


@Composable
fun ChannelItem(channel: ChannelData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFF212020),  shape = RoundedCornerShape(2.dp))
                .padding(2.dp)
        ) {
            Image(
                painter = painterResource(id = channel.imageRes),
                contentDescription = channel.name,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFF212020),  shape = RoundedCornerShape(2.dp))
                .padding(22.dp)
        ) {
            Text(
                text = channel.name,
                color = Color.White
            )
        }
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(5.dp))

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.tv),
                contentDescription = "TV",
                modifier = Modifier.size(33.dp),
                tint = Color.White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "Play",
                tint = Color.White
            )
        }
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id = R.drawable.lupa),
                contentDescription = "Buscar",
                modifier = Modifier.size(31.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
    }
}