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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
private val TextDark = Color(0xFF111827)
private val TextGray = Color(0xFF64748B)

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

@Composable
fun QuizScreen(
    className: String,
    subject: String,
    chapter: String,
    questions: List<QuizQuestion>,
    onBack: () -> Unit
) {

    var currentQuestion by remember {
        mutableIntStateOf(0)
    }

    var selectedAnswer by remember {
        mutableStateOf<Int?>(null)
    }

    var score by remember {
        mutableIntStateOf(0)
    }

    var quizFinished by remember {
        mutableStateOf(false)
    }

    if (quizFinished) {

        QuizResultScreen(
            score = score,
            total = questions.size,
            onBack = onBack
        )

        return
    }

    if (questions.isEmpty()) {
        Text(
            text = "No questions available.",
            modifier = Modifier.padding(20.dp)
        )
        return
    }

    val question = questions[currentQuestion]

    Scaffold(
        containerColor = Background
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(padding)
        ) {

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                androidx.compose.material3.IconButton(
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

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null,
                        tint = Blue
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "15:00",
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )
                }
            }

            Text(
                text = "Question ${currentQuestion + 1} / ${questions.size}",
                modifier = Modifier.padding(
                    horizontal = 18.dp,
                    vertical = 12.dp
                ),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Blue
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {

                item {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Text(
                            text = question.question,
                            modifier = Modifier.padding(20.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    question.options.forEachIndexed { index, option ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            onClick = {
                                selectedAnswer = index
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor =
                                    if (selectedAnswer == index)
                                        LightBlue
                                    else
                                        Color.White
                            )
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                RadioButton(
                                    selected = selectedAnswer == index,
                                    onClick = {
                                        selectedAnswer = index
                                    }
                                )

                                Text(
                                    text = option,
                                    modifier = Modifier.padding(
                                        start = 6.dp,
                                        end = 10.dp
                                    ),
                                    fontSize = 15.sp,
                                    color = TextDark
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {

                            if (selectedAnswer == question.correctAnswer) {
                                score++
                            }

                            if (currentQuestion < questions.lastIndex) {

                                currentQuestion++
                                selectedAnswer = null

                            } else {

                                quizFinished = true
                            }
                        },
                        enabled = selectedAnswer != null,
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Blue
                        )
                    ) {

                        Text(
                            text =
                                if (currentQuestion == questions.lastIndex)
                                    "Finish Test"
                                else
                                    "Next Question",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun QuizResultScreen(
    score: Int,
    total: Int,
    onBack: () -> Unit
) {

    val percentage =
        if (total > 0)
            (score * 100) / total
        else
            0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.height(80.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Test Completed 🎉",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Navy
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "$score / $total",
            fontSize = 42.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Blue
        )

        Text(
            text = "$percentage% Score",
            fontSize = 17.sp,
            color = TextGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onBack,
            shape = RoundedCornerShape(16.dp)
        ) {

            Text("Back to Chapter")
        }
    }
}