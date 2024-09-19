package de.lenno.citygenerator

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

class TestClientKotlin: ClientModInitializer {

    override fun onInitializeClient() {
        CityGenerator.LOGGER.info("Kotlin Client started!")

        ServerPlayConnectionEvents.JOIN.register(ServerPlayConnectionEvents.Join {
            handler, _, _ ->
            val player: ServerPlayerEntity = handler.player
            player.sendMessage(Text.of("Hello ${player.gameProfile.name}! Your mod is working :)"))
        })
    }
}