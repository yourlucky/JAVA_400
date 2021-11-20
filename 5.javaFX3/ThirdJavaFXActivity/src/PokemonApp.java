import java.util.List;

public class PokemonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Welcome to Pockemon");
	     List<PokemonDataInterface> pokemons = new PokemonLoader().loadAllFilesInDirectory("./data/");
	     SearchBackEndInterface engine = new SearchBackEnd();
	     for(PokemonDataInterface pokemon : Pokemons) engine.addPokemon(pokemon);
	     SearchFrontEndInterface ui = new SearchFrontEnd();
	     ui.run(engine);	     

	}

}

