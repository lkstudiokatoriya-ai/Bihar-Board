package com.bsebhub.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
private val LightBlue = Color(0xFFEAF2FF)
private val Background = Color(0xFFF5F7FB)
private val TextDark = Color(0xFF111827)
private val TextGray = Color(0xFF64748B)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                BSEBHubApp()
            }
        }
    }
}

@Composable
fun BSEBHubApp() {

    var screen by remember {
        mutableStateOf("home")
    }

    var selectedClass by remember {
        mutableStateOf("")
    }

    when (screen) {

        "home" -> {
            HomeScreen(
                onClassSelected = {
                    selectedClass = it
                    screen = "subjects"
                }
            )
        }

        "subjects" -> {
            SubjectScreen(
                className = selectedClass,
                onBack = {
                    screen = "home"
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    onClassSelected: (String) -> Unit
) {

    Scaffold(
        containerColor = Background,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Home, null)
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.MenuBook, null)
                    },
                    label = {
                        Text("Study")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.CheckCircle, null)
                    },
                    label = {
                        Text("Practice")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Description, null)
                    },
                    label = {
                        Text("Papers")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, null)
                    },
                    label = {
                        Text("Profile")
                    }
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "BSEB",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Navy
                    )

                    Text(
                        text = "HUB",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Blue
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Navy
                )
            ) {

                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "Hello, Student 👋",
                        color = Color.White,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "Learn. Practice.\nAchieve. 🎯",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Bihar Board preparation made simple.",
                        color = Color(0xFFCBD5E1),
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "🎓 Choose Your Class",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(260.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(
                    listOf(
                        "10th",
                        "12th",
                        "9th",
                        "11th",
                        "6th–8th",
                        "1st–5th"
                    )
                ) { className ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(115.dp),
                        onClick = {
                            onClassSelected(className)
                        },
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "CLASS",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Blue
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = className,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = TextDark
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "View Subjects →",
                                fontSize = 12.sp,
                                color = TextGray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "🔥 Quick Study",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Spacer(modifier = Modifier.height(10.dp))

            QuickRow(
                icon = Icons.Default.Book,
                title = "Notes",
                subtitle = "Chapter-wise notes"
            )

            Spacer(modifier = Modifier.height(8.dp))

            QuickRow(
                icon = Icons.Default.EmojiEvents,
                title = "VVI Questions",
                subtitle = "Important questions"
            )

            Spacer(modifier = Modifier.height(8.dp))

            QuickRow(
                icon = Icons.Default.Timer,
                title = "Mock Test",
                subtitle = "Practice & improve"
            )
        }
    }
}

@Composable
fun QuickRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(46.dp)
                    .background(
                        LightBlue,
                        RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    icon,
                    contentDescription = null,
                    tint = Blue
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )

                Text(
                    subtitle,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }

            Icon(
                Icons.Default.ArrowForward,
                contentDescription = null,
                tint = TextGray
            )
        }
    }
}

@Composable
fun SubjectScreen(
    className: String,
    onBack: () -> Unit
) {

    val subjects = when (className) {

        "10th" -> listOf(
            "Hindi",
            "English",
            "Mathematics",
            "Science",
            "Social Science",
            "Sanskrit"
        )

        "12th" -> listOf(
            "Hindi",
            "English",
            "Physics",
            "Chemistry",
            "Mathematics",
            "Biology"
        )

        "9th" -> listOf(
            "Hindi",
            "English",
            "Mathematics",
            "Science",
            "Social Science"
        )

        "11th" -> listOf(
            "Hindi",
            "English",
            "Physics",
            "Chemistry",
            "Mathematics",
            "Biology"
        )

        else -> listOf(
            "Hindi",
            "English",
            "Mathematics",
            "Science",
            "Social Science"
        )
    }

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
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Navy
                    )
                }

                Column {

                    Text(
                        text = className,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )

                    Text(
                        text = "Select Subject",
                        fontSize = 13.sp,
                        color = TextGray
                    )
                }
            }

            Text(
                text = "📚 Subjects",
                modifier = Modifier.padding(
                    start = 18.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(subjects.size) { index ->

                    SubjectCard(
                        subject = subjects[index]
                    )
                }
            }
        }
    }
}

@Composable
fun SubjectCard(
    subject: String
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        LightBlue,
                        RoundedCornerShape(15.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Blue
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = subject,
                modifier = Modifier.weight(1f),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Icon(
                Icons.Default.ArrowForward,
                contentDescription = null,
                tint = TextGray
            )
        }
    }
}