package com.example.plutoclonecom


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.plutoclonecom.data.ChannelData


@Composable
fun HomeScreen(onNavigateToDemand: () -> Unit, onNavigateToHome: () -> Unit = {}) {
    var selectedChannel by remember { mutableStateOf<ChannelData?>(null) }
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
            VideoContainer(selectedChannel)
            MenuCategories()
            ChannelList(onChannelSelected = { channel ->
                selectedChannel = channel
            })
        }
        BottomBar(
            onNavigateToDemand = onNavigateToDemand,
            onNavigateToHome = onNavigateToHome
        )
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
fun VideoContainer(selectedChannel: ChannelData?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = selectedChannel?.contentImageRes ?: R.drawable.south),
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
                    .background(Color.Black, shape = RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White, shape = RoundedCornerShape(16.dp))
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
fun ChannelList(onChannelSelected: (ChannelData) -> Unit) {
    val channels = listOf(
        ChannelData("Acción", R.drawable.cineaccion,R.drawable.conac),
        ChannelData("Terror", R.drawable.cineterror,R.drawable.cont),
        ChannelData("Suspenso", R.drawable.cinesuspenso,R.drawable.consus),
        ChannelData("Drama", R.drawable.cinedrama,R.drawable.condram),
        ChannelData("Comedia", R.drawable.cinecomedia,R.drawable.conco),
        ChannelData("Romance", R.drawable.cineromance,R.drawable.conroma),
        ChannelData("South Park", R.drawable.southp,R.drawable.south),
        ChannelData("Detectives", R.drawable.dea,R.drawable.condea),
        ChannelData("Naruto", R.drawable.naruto,R.drawable.conna)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        items(channels.size) { index ->
            ChannelItem(channel = channels[index],
                onClick = {
                onChannelSelected(channels[index])
            })
        }
    }
}



@Composable
fun ChannelItem(channel: ChannelData, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(60.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFF212020), shape = RoundedCornerShape(2.dp))
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
                .background(Color(0xFF212020), shape = RoundedCornerShape(2.dp))
                .padding(horizontal = 8.dp, vertical = 20.dp)
        ) {
            Text(
                text = channel.name,
                color = Color.White
            )
        }
    }
}

@Composable
fun BottomBar(onNavigateToDemand: () -> Unit, onNavigateToHome: () -> Unit,modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(5.dp))

        IconButton(onClick = {
            onNavigateToHome()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.tv),
                contentDescription = "TV",
                modifier = Modifier.size(33.dp),
                tint = Color.White
            )
        }

        IconButton(onClick = {
            onNavigateToDemand()
        }) {

        Icon(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "Play",
                tint = Color.White
            )
        }


        IconButton(onClick = { }) {
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