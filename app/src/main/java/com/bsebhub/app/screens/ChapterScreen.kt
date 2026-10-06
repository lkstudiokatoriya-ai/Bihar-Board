package com.bsebhub.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF07111F)
private val Blue = Color(0xFF2563EB)
private val Background = Color(0xFFF5F7FB)
private val LightBlue = Color(0xFFEAF2FF)
private val TextDark = Color(0xFF111827)
private val TextGray = Color(0xFF64748B)

@Composable
fun ChapterScreen(
    className: String,
    subject: String,
    chapters: List<String>,
    onBack: () -> Unit,
    onChapterClick: (String) -> Unit
) {

    Scaffold(
        containerColor = Background
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(padding)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Navy
                    )
                }

                Column {

                    Text(
                        text = subject,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )

                    Text(
                        text = className,
                        fontSize = 13.sp,
                        color = TextGray
                    )
                }
            }

            Text(
                text = "📚 Chapters",
                modifier = Modifier.padding(
                    start = 18.dp,
                    top = 12.dp,
                    bottom = 5.dp
                ),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Text(
                text = "${chapters.size} chapters available",
                modifier = Modifier.padding(
                    start = 18.dp,
                    bottom = 14.dp
                ),
                fontSize = 13.sp,
                color = TextGray
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 16.dp,
                    vertical = 6.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                itemsIndexed(chapters) { index, chapter ->

                    ChapterCard(
                        number = index + 1,
                        chapter = chapter,
                        onClick = {
                            onChapterClick(chapter)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ChapterCard(
    number: Int,
    chapter: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = LightBlue,
                        shape = RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = number.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Chapter $number",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Blue
                )

                Text(
                    text = chapter,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = TextGray
            )
        }
    }
}