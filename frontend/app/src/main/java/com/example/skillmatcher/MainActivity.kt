package com.example.skillmatcher

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api

import com.example.skillmatcher.api.getLocalUserEmail
import com.example.skillmatcher.ui.theme.SkillMatcherTheme


import com.example.skillmatcher.components.*
import com.ramcosta.composedestinations.DestinationsNavHost
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.client.token.TokenProvider
import io.getstream.chat.android.offline.model.message.attachments.UploadAttachmentsNetworkType
import io.getstream.chat.android.offline.plugin.configuration.Config
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

/*
You can use the following code for commercial purposes with some restrictions.
Read the full license here: https://semicolonspace.com/semicolonspace-license/
For more designs with source code, visit:
https://semicolonspace.com/jetpack-compose-samples/
 */
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillMatcherTheme {

                val offlinePluginFactory = StreamOfflinePluginFactory(
                    config = Config(
                        backgroundSyncEnabled = true,
                        userPresence = true,
                        persistenceEnabled = true,
                        uploadAttachmentsNetworkType = UploadAttachmentsNetworkType.NOT_ROAMING,
                    ),
                    appContext = applicationContext,
                )
                //ChatClient gebildet
                val client = ChatClient.Builder("kx7pts2bumyf", applicationContext)
                    .withPlugin(offlinePluginFactory)
                    .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
                    .build()


                DestinationsNavHost(navGraph = NavGraphs.root)

            }


        }

    }
}

//test