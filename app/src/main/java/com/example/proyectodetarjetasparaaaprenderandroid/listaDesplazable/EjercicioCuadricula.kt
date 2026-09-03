package com.example.proyectodetarjetasparaaaprenderandroid.listaDesplazable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectodetarjetasparaaaprenderandroid.R
import com.example.proyectodetarjetasparaaaprenderandroid.listaDesplazable.data.DataSourceCurso
import com.example.proyectodetarjetasparaaaprenderandroid.listaDesplazable.model.Topic
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.ProyectoDeTarjetasParaaAprenderAndroidTheme

class EjercicioCuadricula {
}

@Composable
fun TopicApp() {
    TopicGrid(
        topicList = DataSourceCurso.topics,
        modifier = Modifier.padding(
            start = dimensionResource(R.dimen.padding_small),
            top = dimensionResource(R.dimen.padding_small),
            end = dimensionResource(R.dimen.padding_small),
        )
    )
}

@Composable
fun TopicGrid(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(topicList) { topic ->
            TopicCard(
                topic = topic,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(topic.imageResourceId),
                    contentDescription = stringResource(topic.stringResourceId),
                    modifier = Modifier.size(width = 68.dp, height = 68.dp).aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium)
                        )
                    )
                    Text(
                        text = topic.coursesCount.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_small)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Cualquier nombre")
@Composable
fun TopicCardPreview() {
    ProyectoDeTarjetasParaaAprenderAndroidTheme {
        //AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
        TopicApp()
    }
}