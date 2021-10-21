package concurso.filtros;

import concurso.Participante;

public class FiltroGenero implements Filtro{
	private String genero;
	
	@Override
	public boolean cumple(Participante p) {
		return p.prefiereGenero(genero);
	}

	public FiltroGenero(String genero) {
		this.genero = genero;
	}

}
