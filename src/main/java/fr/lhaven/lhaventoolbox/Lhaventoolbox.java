package fr.lhaven.lhaventoolbox;
import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.pokemon.PokemonCapturedEvent;
import net.minecraft.server.network.ServerPlayerEntity;
import kotlin.Unit;
import net.fabricmc.api.ModInitializer;


public class Lhaventoolbox implements ModInitializer {

    @Override
    public void onInitialize() {
        CobblemonEvents.POKEMON_CAPTURED.subscribe(Priority.NORMAL, this::onCaptured);


            }

    private Unit onCaptured(PokemonCapturedEvent pokemonCapturedEvent) {
        System.out.println("test");
        System.out.println("test" + pokemonCapturedEvent.getPokemon());
        ServerPlayerEntity player = pokemonCapturedEvent.getPlayer();
        System.out.println("test" + player);
        return Unit.INSTANCE;

    }
}







