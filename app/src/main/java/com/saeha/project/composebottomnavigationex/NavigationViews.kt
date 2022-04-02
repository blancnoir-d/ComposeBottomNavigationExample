package com.saeha.project.composebottomnavigationex

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.developersbreach.jetpackcomposesamples.R
//import com.developersbreach.jetpackcomposesamples.ui.theme.ComposeTheme

import com.saeha.project.composebottomnavigationex.R
import com.saeha.project.composebottomnavigationex.ui.theme.ComposeBottomNavigationExTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteContactsScreen(
    contacts: ArrayList<String> = favoriteContacts() //DataUtils.kt에 있는 데이터를 불러옴
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 28.dp),
    ) {
        items(contacts) { contact ->

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(48.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = contact,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

//Recent탭의 화면?
@Composable
fun RecentContactsScreen(
    recent: ArrayList<String> = recentContacts()
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(28.dp),
        modifier = Modifier
            .padding(top = 28.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //아이템 모양을 설정하는 부분
        items(recent) { contact ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(28.dp))

                Column(
                    modifier = Modifier.weight(7f)
                ) {
                    Text(text = contact, style = MaterialTheme.typography.subtitle1)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = pickRandomTimeData(), style = MaterialTheme.typography.subtitle1)
                }

                Icon(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .weight(1.5f)
                )
            }
        }
    }
}

@Composable
fun ContactsScreen(
    contacts: ArrayList<String> = userData()
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(top = 28.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(contacts) { contact ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 12.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically),
                    backgroundColor = pickRandomColor(),
                ) {
                    Text(
                        text = contact[0].toString(),
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(24.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.width(28.dp))

                Text(text = contact, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun FavoriteContactsPreview() {
    ComposeBottomNavigationExTheme(darkTheme = true) {//ui.theme/Theme.kt 의 ComposeBottomNavigationExTheme로 변경 (본래 ComposeTheme로 되어있었음)
        FavoriteContactsScreen()
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun RecentContactsPreview() {
    ComposeBottomNavigationExTheme(darkTheme = true) {
        RecentContactsScreen()
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ContactsScreenPreview() {
    ComposeBottomNavigationExTheme(darkTheme = true) {
        ContactsScreen()
    }
}