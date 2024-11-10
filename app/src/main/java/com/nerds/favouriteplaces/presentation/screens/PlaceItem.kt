package com.nerds.favouriteplaces.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nerds.favouriteplaces.R
import com.nerds.favouriteplaces.domain.model.Places

@Composable
fun PlaceItem(
    places: Places,
    isFavorite: Boolean,
    onFavoriteClick: (Places) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onFavoriteClick(places) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.droidcon_event_banner),
            contentDescription = places.name,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = places.name, style = MaterialTheme.typography.titleMedium)
            Text(text = places.location, style = MaterialTheme.typography.bodyMedium)
        }

        IconButton(onClick = { onFavoriteClick(places) }) {
            Icon(
                painter = painterResource(
                    id = if (isFavorite) R.drawable.ic_feedback_bad_face else R.drawable.ic_feedback_neutral_face
                ),
                contentDescription = if (isFavorite) "Unfavorite" else "Favorite"
            )
        }
    }
}
