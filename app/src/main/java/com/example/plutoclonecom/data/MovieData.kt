package com.example.plutoclonecom.data

import com.example.plutoclonecom.R


val movieList = listOf(
    Category(
        name = "Acción",
        movies = listOf(
            Movie("Película 1", R.drawable.guerr),
            Movie("La guerra del mañana", R.drawable.furi),
            Movie("Película 3", R.drawable.tere),
            Movie("Película 3", R.drawable.sp)
        )
    ),
    Category(
        name = "Comedia",
        movies = listOf(
            Movie("Película A", R.drawable.aye),
            Movie("padre", R.drawable.padr),
            Movie("Película C", R.drawable.pap),
            Movie("Película 3", R.drawable.todo)
        )
    ),
    Category(
        name = "Aventura",
        movies = listOf(
            Movie("Película X", R.drawable.ava),
            Movie("Piratas ", R.drawable.pira),
            Movie("aven", R.drawable.und),
            Movie("futuro", R.drawable.vol)
        )
    ),
    Category(
        name = "Terror",
        movies = listOf(
            Movie("Película X", R.drawable.si),
            Movie("Película Y", R.drawable.conj),
            Movie("Película Z", R.drawable.son),
            Movie("Película 3", R.drawable.lega)
        )
    )
)
