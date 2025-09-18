package com.nllamo.jetpackcomposefrom0.old.projects.superhero

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nllamo.jetpackcomposefrom0.R
import com.nllamo.jetpackcomposefrom0.old.model.SuperHero
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun SuperHeroScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                WindowInsets.statusBars.asPaddingValues()
            )
            .padding(
                WindowInsets.navigationBars.asPaddingValues()
            )
            .padding(horizontal = 4.dp)
            .background(Color.White),
    ) {
//        SuperHeroWithSpecialControlsView()
        SuperHeroStickyView()
    }
}

@Composable
private fun SuperHeroListView() {
    val context = LocalContext.current

    // LIST VERTICAL
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(4.dp),
//        ) {
    // LIST HORIZONTAL
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(getSuperHero()) { superHero ->
            ItemHero(
                superHero = superHero,
                onItemSelected = {
                    Toast.makeText(context, "Selected: ${it.alias}", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
private fun SuperHeroGridView() {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(getSuperHero()) { superHero ->
                ItemHero(
                    superHero = superHero,
                    onItemSelected = {
                        Toast.makeText(context, "Selected: ${it.alias}", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    )
}

@ExperimentalFoundationApi
@Composable
private fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superHeroesByPublisher: Map<String, List<SuperHero>> =
        getSuperHero().groupBy { it.publisher }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        superHeroesByPublisher.forEach { (publisher, superHeroes) ->
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    text = publisher
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    items(superHeroes) { superHero ->
                        ItemHero(
                            superHero = superHero,
                            onItemSelected = {
                                Toast.makeText(context, "Selected: ${it.alias}", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            state = rvState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            content = {
                items(getSuperHero()) { superHero ->
                    ItemHero(
                        superHero = superHero,
                        onItemSelected = {
                            Toast.makeText(context, "Selected: ${it.alias}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
                }
            }
        )

        val showButton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }

        if (showButton)
            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .background(shape = RoundedCornerShape(8.dp), color = Color.Magenta),
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(index = 0)
                    }

                },
                colors = ButtonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Gray,
                )
            ) {
                Text(
                    text = "Ir al Inicio"
                )
            }
    }
}

@Composable
private fun ItemHero(
    superHero: SuperHero,
    onItemSelected: (SuperHero) -> Unit,
) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .clickable(
                onClick = { onItemSelected(superHero) }
            ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Magenta
        ),
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                painter = painterResource(superHero.photo),
                contentDescription = superHero.alias,
                contentScale = ContentScale.Crop,
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = superHero.alias,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = superHero.name,
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .align(Alignment.End),
                text = superHero.publisher,
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperHero() =
    listOf(
        SuperHero(
            alias = "Spiderman",
            name = "Petter Parker",
            publisher = "Marvel",
            photo = R.drawable.spiderman
        ),
        SuperHero(
            alias = "Wolverine",
            name = "James Howlett",
            publisher = "Marvel",
            photo = R.drawable.logan
        ),
        SuperHero(
            alias = "Batman",
            name = "Bruce Wayne",
            publisher = "DC",
            photo = R.drawable.batman
        ),
        SuperHero(
            alias = "Thor",
            name = "Thor Odinson",
            publisher = "Marvel",
            photo = R.drawable.thor
        ),
        SuperHero(
            alias = "Flash",
            name = "Jay Garric",
            publisher = "DC",
            photo = R.drawable.flash
        ),
        SuperHero(
            alias = "Green Lantern",
            name = "Alan Scott",
            publisher = "DC",
            photo = R.drawable.green_lantern
        ),
        SuperHero(
            alias = "Wonder Woman",
            name = "Princess Diana",
            publisher = "DC",
            photo = R.drawable.wonder_woman
        ),
    )