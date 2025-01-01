package fr.lhaven.lhaventoolbox;
import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.pokemon.PokemonCapturedEvent;
import com.cobblemon.mod.common.api.events.pokemon.PokemonFaintedEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import kotlin.Unit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.text.MutableText;


public class Lhaventoolbox implements ModInitializer {

    @Override
    public void onInitialize() {
        // Inscription a l'event PokemonFainted de cobblemon
        CobblemonEvents.POKEMON_FAINTED.subscribe(Priority.NORMAL, this::onKilledPokemon);
            }

    private Unit onKilledPokemon(PokemonFaintedEvent pokemonfaintedEvent) {
        // Fonction lancé quand cobblemon lance l'event PokemonFainted par notre mods
        System.out.println("test" + pokemonfaintedEvent.getPokemon());
        // On récupère le nom du pokemon
        MutableText PokemonName = pokemonfaintedEvent.getPokemon().getDisplayName();
        System.out.println("PokemonName" + PokemonName);
        // Si le pokemon est sauvage
        if(pokemonfaintedEvent.getPokemon().isWild())
        {
            // Si le pokemon est tué par un joueur
            if(pokemonfaintedEvent.getPokemon().getEntity().getKiller() instanceof ServerPlayerEntity)
            {
                // On récupère le joueur qui a tué le pokemon
                ServerPlayerEntity player = (ServerPlayerEntity) pokemonfaintedEvent.getPokemon().getEntity().getKiller();
                // On envoie un message au joueur qui a tué le pokemon
                player.sendMessage(PokemonName.append("killed by " + player.getName()), false);
            }
        }
        return Unit.INSTANCE;

    }
}







