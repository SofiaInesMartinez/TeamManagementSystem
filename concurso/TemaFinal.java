package concurso;

import concurso.filtros.Filtro;

public class TemaFinal extends TemaMusical {
	private int cantidadParticipantes;
	
	public TemaFinal(String titulo, String idioma, Filtro criterio, int cantidadParticipantes) {
		super(titulo, idioma, criterio);
		this.cantidadParticipantes = cantidadParticipantes;
	}
	
	// este metodo verifica si grupo/banda/solista pasado por parametro cumple con 
	// el criterio de interpretacion del tema y si la cantidad de miembros 
	// que saben tocar instrumentos necesarios para el tema es igual o mayor a la requerida
	public boolean puedeSerInterpretado(GrupoAbstracto p) {
		return criterio.cumple(p) && p.cantMiembrosInstrumentos(this) >= cantidadParticipantes;
	}
}
