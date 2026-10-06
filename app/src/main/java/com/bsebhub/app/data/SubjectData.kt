package com.bsebhub.app.data

object SubjectData {

    fun getSubjects(className: String): List<String> {

        return when (className) {

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

            "11th" -> listOf(
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

            "6th–8th" -> listOf(
                "Hindi",
                "English",
                "Mathematics",
                "Science",
                "Social Science"
            )

            "1st–5th" -> listOf(
                "Hindi",
                "English",
                "Mathematics",
                "Environmental Studies"
            )

            else -> emptyList()
        }
    }
}