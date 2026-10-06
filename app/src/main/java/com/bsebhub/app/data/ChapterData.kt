package com.bsebhub.app.data

object ChapterData {

    fun getChapters(
        className: String,
        subject: String
    ): List<String> {

        return when (className) {

            "10th" -> when (subject) {

                "Mathematics" -> listOf(
                    "Real Numbers",
                    "Polynomials",
                    "Pair of Linear Equations",
                    "Quadratic Equations",
                    "Arithmetic Progressions",
                    "Triangles",
                    "Coordinate Geometry",
                    "Introduction to Trigonometry",
                    "Applications of Trigonometry",
                    "Circles",
                    "Areas Related to Circles",
                    "Surface Areas and Volumes",
                    "Statistics",
                    "Probability"
                )

                "Science" -> listOf(
                    "Chemical Reactions and Equations",
                    "Acids, Bases and Salts",
                    "Metals and Non-metals",
                    "Carbon Compounds",
                    "Life Processes",
                    "Control and Coordination",
                    "How do Organisms Reproduce?",
                    "Heredity",
                    "Light",
                    "Human Eye and Colourful World",
                    "Electricity",
                    "Magnetic Effects of Electric Current",
                    "Our Environment"
                )

                "Social Science" -> listOf(
                    "Resources and Development",
                    "Forest and Wildlife Resources",
                    "Water Resources",
                    "Agriculture",
                    "Manufacturing Industries",
                    "Power Sharing",
                    "Federalism",
                    "Gender, Religion and Caste",
                    "Development",
                    "Sectors of the Indian Economy",
                    "Money and Credit"
                )

                "Hindi" -> listOf(
                    "गद्य खंड",
                    "पद्य खंड",
                    "व्याकरण",
                    "लेखन कौशल"
                )

                "English" -> listOf(
                    "Prose",
                    "Poetry",
                    "Grammar",
                    "Writing"
                )

                "Sanskrit" -> listOf(
                    "गद्य",
                    "पद्य",
                    "व्याकरण",
                    "अनुवाद"
                )

                else -> emptyList()
            }

            "12th" -> when (subject) {

                "Physics" -> listOf(
                    "Electric Charges and Fields",
                    "Electrostatic Potential",
                    "Current Electricity",
                    "Moving Charges and Magnetism",
                    "Electromagnetic Induction",
                    "Alternating Current",
                    "Electromagnetic Waves",
                    "Ray Optics",
                    "Wave Optics",
                    "Dual Nature of Radiation",
                    "Atoms",
                    "Nuclei",
                    "Semiconductor Electronics"
                )

                "Chemistry" -> listOf(
                    "Solutions",
                    "Electrochemistry",
                    "Chemical Kinetics",
                    "d and f Block Elements",
                    "Coordination Compounds",
                    "Haloalkanes and Haloarenes",
                    "Alcohols, Phenols and Ethers",
                    "Aldehydes, Ketones and Carboxylic Acids",
                    "Amines",
                    "Biomolecules"
                )

                "Mathematics" -> listOf(
                    "Relations and Functions",
                    "Inverse Trigonometric Functions",
                    "Matrices",
                    "Determinants",
                    "Continuity and Differentiability",
                    "Applications of Derivatives",
                    "Integrals",
                    "Applications of Integrals",
                    "Differential Equations",
                    "Vector Algebra",
                    "Three Dimensional Geometry",
                    "Probability"
                )

                "Biology" -> listOf(
                    "Sexual Reproduction in Flowering Plants",
                    "Human Reproduction",
                    "Reproductive Health",
                    "Principles of Inheritance",
                    "Molecular Basis of Inheritance",
                    "Evolution",
                    "Human Health and Disease",
                    "Biotechnology",
                    "Organisms and Populations",
                    "Ecosystem"
                )

                "Hindi" -> listOf(
                    "गद्य खंड",
                    "पद्य खंड",
                    "व्याकरण",
                    "लेखन"
                )

                "English" -> listOf(
                    "Prose",
                    "Poetry",
                    "Grammar",
                    "Writing"
                )

                else -> emptyList()
            }

            "11th" -> when (subject) {

                "Physics" -> listOf(
                    "Units and Measurements",
                    "Motion in a Straight Line",
                    "Motion in a Plane",
                    "Laws of Motion",
                    "Work, Energy and Power",
                    "System of Particles",
                    "Gravitation",
                    "Properties of Bulk Matter",
                    "Thermodynamics",
                    "Oscillations",
                    "Waves"
                )

                "Chemistry" -> listOf(
                    "Some Basic Concepts of Chemistry",
                    "Structure of Atom",
                    "Classification of Elements",
                    "Chemical Bonding",
                    "Thermodynamics",
                    "Equilibrium",
                    "Redox Reactions",
                    "Organic Chemistry",
                    "Hydrocarbons"
                )

                "Mathematics" -> listOf(
                    "Sets",
                    "Relations and Functions",
                    "Trigonometric Functions",
                    "Complex Numbers",
                    "Linear Inequalities",
                    "Permutations and Combinations",
                    "Binomial Theorem",
                    "Sequences and Series",
                    "Straight Lines",
                    "Statistics",
                    "Probability"
                )

                "Biology" -> listOf(
                    "The Living World",
                    "Biological Classification",
                    "Plant Kingdom",
                    "Animal Kingdom",
                    "Morphology of Flowering Plants",
                    "Cell Structure",
                    "Biomolecules",
                    "Photosynthesis",
                    "Respiration",
                    "Plant Growth"
                )

                else -> emptyList()
            }

            else -> listOf(
                "Chapter 1",
                "Chapter 2",
                "Chapter 3",
                "Chapter 4",
                "Chapter 5"
            )
        }
    }
}