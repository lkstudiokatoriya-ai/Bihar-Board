package com.bsebhub.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
private val Green = Color(0xFF16A34A)
private val TextDark = Color(0xFF111827)
private val TextGray = Color(0xFF64748B)

data class VVIQuestion(
    val question: String,
    val answer: String
)

@Composable
fun VVIQuestionsScreen(
    className: String,
    subject: String,
    chapter: String,
    questions: List<VVIQuestion>,
    onBack: () -> Unit
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

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = subject,
                        fontSize = 13.sp,
                        color = TextGray
                    )

                    Text(
                        text = chapter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }

                Icon(
                    imageVector = Icons.Default.EmojiEvents,
                    contentDescription = null,
                    tint = Blue
                )
            }

            Text(
                text = "⭐ VVI Questions",
                modifier = Modifier.padding(
                    horizontal = 18.dp,
                    vertical = 12.dp
                ),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Text(
                text = "$className • Most Important Questions",
                modifier = Modifier.padding(
                    horizontal = 18.dp
                ),
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 16.dp,
                    vertical = 6.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(questions) { item ->

                    VVIQuestionCard(item)
                }
            }
        }
    }
}

@Composable
private fun VVIQuestionCard(
    item: VVIQuestion
) {

    var showAnswer by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.Top
            ) {

                Icon(
                    imageVector = Icons.Default.EmojiEvents,
                    contentDescription = null,
                    tint = Blue
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = item.question,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )

                IconButton(
                    onClick = {}
                ) {

                    Icon(
                        imageVector = Icons.Default.BookmarkBorder,
                        contentDescription = "Bookmark",
                        tint = TextGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showAnswer = !showAnswer
                },
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightBlue
                )
            ) {

                Text(
                    text = if (showAnswer)
                        "Answer: ${item.answer}"
                    else
                        "Tap to view answer",
                    modifier = Modifier.padding(14.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (showAnswer)
                        Green
                    else
                        Blue
                )
            }
        }
    }
}