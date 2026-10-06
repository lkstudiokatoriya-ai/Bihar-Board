package com.bsebhub.app.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF07111F)
private val Blue = Color(0xFF2563EB)
private val Background = Color(0xFFF5F7FB)
private val LightBlue = Color(0xFFEAF2FF)
private val TextDark = Color(0xFF111827)
private val TextGray = Color(0xFF64748B)

data class PdfMaterial(
    val title: String,
    val description: String,
    val pdfUrl: String
)

@Composable
fun PdfMaterialScreen(
    className: String,
    subject: String,
    chapter: String,
    materials: List<PdfMaterial>,
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

                IconButton(onClick = onBack) {
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

                Icon(
                    imageVector = Icons.Default.PictureAsPdf,
                    contentDescription = null,
                    tint = Blue
                )
            }

            Text(
                text = "📄 PDF Material",
                modifier = Modifier.padding(
                    horizontal = 18.dp,
                    vertical = 12.dp
                ),
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark
            )

            Text(
                text = "$className • $subject",
                modifier = Modifier.padding(horizontal = 18.dp),
                fontSize = 13.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(14.dp))

            if (materials.isEmpty()) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null,
                        tint = TextGray,
                        modifier = Modifier.size(55.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "No PDF available yet",
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )
                }

            } else {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(materials) { material ->

                        PdfMaterialCard(
                            material = material
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PdfMaterialCard(
    material: PdfMaterial
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(17.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = LightBlue,
                            shape = RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.PictureAsPdf,
                        contentDescription = null,
                        tint = Blue
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = material.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )

                    Text(
                        text = material.description,
                        fontSize = 12.sp,
                        color = TextGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                    if (material.pdfUrl.isNotBlank()) {

                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(material.pdfUrl)
                        )

                        context.startActivity(intent)
                    }
                },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                )
            ) {

                Icon(
                    imageVector = Icons.Default.PictureAsPdf,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Open PDF",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}