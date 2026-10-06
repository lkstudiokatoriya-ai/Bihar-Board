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

data class NoteSection(
    val title: String,
    val content: String
)

@Composable
fun NotesScreen(
    className: String,
    subject: String,
    chapter: String,
    onBack: () -> Unit
) {

    val notes = listOf(

        NoteSection(
            title = "Introduction",
            content = "इस chapter का basic introduction यहाँ उपलब्ध होगा।"
        ),

        NoteSection(
            title = "Important Concepts",
            content = "Chapter के मुख्य concepts और definitions यहाँ दिए जाएँगे।"
        ),

        NoteSection(
            title = "Important Formulas",
            content = "परीक्षा के लिए महत्वपूर्ण formulas और उनके उपयोग यहाँ दिए जाएँगे।"
        ),

        NoteSection(
            title = "Key Points",
            content = "इस chapter के महत्वपूर्ण points को revision के लिए यहाँ रखा जाएगा।"
        ),

        NoteSection(
            title = "Exam Preparation",
            content = "Board examination में पूछे जाने वाले महत्वपूर्ण topics यहाँ मिलेंगे।"
        )
    )

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
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }

                IconButton(
                    onClick = {}
                ) {

                    Icon(
                        imageVector = Icons.Default.BookmarkBorder,
                        contentDescription = "Bookmark",
                        tint = Navy
                    )
                }
            }

            Text(
                text = "📖 Chapter Notes",
                modifier = Modifier.padding(
                    horizontal = 18.dp,
                    vertical = 12.dp
                ),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 16.dp,
                    vertical = 6.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(notes) { section ->

                    NoteCard(section)
                }
            }
        }
    }
}

@Composable
private fun NoteCard(
    section: NoteSection
) {

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
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Blue
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = section.title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = section.content,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = TextGray
            )
        }
    }
}