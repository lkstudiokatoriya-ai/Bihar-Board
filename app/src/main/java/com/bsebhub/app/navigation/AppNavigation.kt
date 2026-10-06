package com.bsebhub.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.bsebhub.app.data.ChapterData
import com.bsebhub.app.data.SubjectData
import com.bsebhub.app.screens.ChapterScreen
import com.bsebhub.app.screens.SubjectScreen

@Composable
fun AppNavigation() {

    var screen by remember {
        mutableStateOf("subjects")
    }

    var selectedClass by remember {
        mutableStateOf("10th")
    }

    var selectedSubject by remember {
        mutableStateOf("")
    }

    when (screen) {

        "subjects" -> {

            SubjectScreen(
                className = selectedClass,
                subjects = SubjectData.getSubjects(selectedClass),

                onBack = {
                    // Home navigation बाद में जोड़ा जाएगा
                },

                onSubjectClick = { subject ->

                    selectedSubject = subject
                    screen = "chapters"
                }
            )
        }

        "chapters" -> {

            ChapterScreen(
                className = selectedClass,
                subject = selectedSubject,

                chapters = ChapterData.getChapters(
                    className = selectedClass,
                    subject = selectedSubject
                ),

                onBack = {
                    screen = "subjects"
                },

                onChapterClick = { chapter ->

                    // Chapter content अगले चरण में खुलेगा.
                }
            )
        }
    }
}