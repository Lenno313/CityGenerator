package de.lenno.citygenerator

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.text.TextContent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.coroutines.coroutineContext

class TestCityGenerator : ModInitializer {
    override fun onInitialize() {
        LOGGER.info("Mod loaded! Hello Fabric world!")

        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback {
            dispatcher, _, _ ->
                dispatcher.register(
                    CommandManager.literal("abc").executes {
                        coroutineContext ->
                        val player = coroutineContext.source.player ?: return@executes 0

                        player.sendMessage(Text.of("Test erfolgreich!"))

                        1
                    }
                )
        })
    }

    companion object {
        const val MOD_ID: String = "citygenerator"

        // This logger is used to write text to the console and the log file.
        // It is considered best practice to use your mod id as the logger's name.
        // That way, it's clear which mod wrote info, warnings, and errors.
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}
