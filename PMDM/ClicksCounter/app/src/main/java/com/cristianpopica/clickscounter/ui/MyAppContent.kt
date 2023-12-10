package com.cristianpopica.clickscounter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cristianpopica.clickscounter.ui.theme.ClicksCounterTheme


    @Composable
    fun MyAppContent(content :  @Composable () -> Unit) {
        ClicksCounterTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                content()
            }
        }
    }