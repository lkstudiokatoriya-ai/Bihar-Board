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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.QuestionAnswer
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

data class StudyOption(
    val title: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Composable
fun ChapterContentScreen(
    className: String,
    subject: String,
    chapter: String,
    onBack: () -> Unit,
    onOptionClick: (String) -> Unit
) {

    val options = listOf(

        StudyOption(
            title = "Chapter Notes",
            subtitle = "Complete chapter notes",
            icon = Icons.Default.MenuBook
        ),

        StudyOption(
            title = "Objective Questions",
            subtitle = "MCQ practice questions",
            icon = Icons.Default.CheckCircle
        ),

        StudyOption(
            title = "VVI Questions",
            subtitle = "Most important questions",
            icon = Icons.Default.EmojiEvents
        ),

        StudyOption(
            title = "Subjective Questions",
            subtitle = "Long & short answer questions",
            icon = Icons.Default.QuestionAnswer
        ),

        StudyOption(
            title = "PDF Material",
            subtitle = "Study material in PDF",
            icon = Icons.Default.Description
        ),

        StudyOption(
            title = "Chapter Test",
            subtitle = "Test your preparation",
            icon = Icons.Default.CheckCircle
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
                        fontSize = 14.sp,
                        color = TextGray
                    )

                    Text(
                        text = chapter,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "📖 Study This Chapter",
                modifier = Modifier.padding(
                    horizontal = 18.dp
                ),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "$className • $subject",
                modifier = Modifier.padding(
                    horizontal = 18.dp
                ),
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(18.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 16.dp,
                    vertical = 6.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(options) { option ->

                    StudyOptionCard(
                        option = option,
                        onClick = {
                            onOptionClick(option.title)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun StudyOptionCard(
    option: StudyOption,
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
                .padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(
                        color = LightBlue,
                        shape = RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = option.icon,
                    contentDescription = null,
                    tint = Blue,
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = option.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = option.subtitle,
                    fontSize = 12.sp,
                    color = TextGray
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