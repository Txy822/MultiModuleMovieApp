package com.sample.features.setting.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SettingItem(
            title = "Notifications",
            icon = Icons.Default.Notifications
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.White)

        SettingItem(
            title = "Dark Mode",
            icon = Icons.Default.DarkMode
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.White)

        SettingItem(
            title = "Language",
            icon = Icons.Default.Language
        )

    }
}

@Composable
fun SettingItem(title: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Setting Icon",
            modifier = Modifier.size(24.dp),
            tint= Color.White
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f),
            color = Color.White
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow Icon",
            modifier = Modifier.size(24.dp),
            tint =Color.White
        )
    }
}