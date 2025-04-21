package com.nllamo.jetpackcomposefrom0.projects.superhero

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.nllamo.jetpackcomposefrom0.practice.model.SuperHero

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
            .background(Color.White)
    ) {
        SuperHeroWithSpecialControlsView()
    }
}

@Composable
private fun SuperHeroListView() {
    val context = LocalContext.current

    // LISTA VERTICAL
//        LazyColumn(
//            verticalArrangement = Arrangement.spacedBy(4.dp),
//        ) {
    // LISTA HORIZONTAL
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

@Composable
private fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()

    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(4.dp),
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

        Button(
            onClick = {

            },
        ) {
            Text(
                text = "Continuar"
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
                    .padding(8.dp)
                    .align(Alignment.End),
                text = superHero.publisher,
                fontSize = 10.sp
            )
        }
    }
}

private fun getSuperHero() =
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