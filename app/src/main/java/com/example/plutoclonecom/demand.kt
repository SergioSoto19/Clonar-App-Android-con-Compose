package com.example.plutoclonecom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.plutoclonecom.data.Movie
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plutoclonecom.data.Category
import com.example.plutoclonecom.data.movieList


@Composable
fun Demand(onNavigateToDemand: () -> Unit, onNavigateToHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopBar()

        Text(
            text = "Películas",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            items(movieList) { category ->
                CategoryRow(category = category)
            }
        }

        BottomBar(
            onNavigateToDemand = onNavigateToDemand,
            onNavigateToHome = onNavigateToHome
        )
    }
}

@Composable
fun CategoryRow(category: Category) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = category.name,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(category.movies) { movie ->
                MovieItem(movie)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 8.dp)
            .width(120.dp)
    ) {
        Image(
            painter = painterResource(id = movie.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp))
        )

    }
}


