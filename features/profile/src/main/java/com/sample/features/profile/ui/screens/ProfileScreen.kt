package com.sample.features.profile.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sample.features.profile.data.getDummyUserProfile

@Composable
fun ProfileScreen() {
   // val userProfile = remember { Profile() }
    val userProfile = remember { getDummyUserProfile() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Profile",
            color = Color.White,
            style = MaterialTheme.typography.h4
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.White)

        Image(
            painter = painterResource(id = com.core.common.R.drawable.person),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = userProfile.name,
            color = Color.White,
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = userProfile.email,
            color = Color.White,

            style = MaterialTheme.typography.subtitle1
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = userProfile.bio,
            color = Color.White,
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(16.dp))

        val customButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp)),
            colors =customButtonColors
        ) {
            Text(text = "Edit Profile", color= Color.Black)
        }
    }
}


