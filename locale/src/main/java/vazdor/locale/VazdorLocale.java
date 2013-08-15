package vazdor.locale;

import java.util.List;
import java.util.Locale;

public interface VazdorLocale {
	
	public List<String> localesSuportados();
	public List<String> localesNomeAmigavel();
	public Locale localeSelecionado();
	public void setLocalesSuportados(List<String> locales);
	public void setLocalesNomeAmigavel(List<String> nomes);
	public void setLocaleSelecionado(String locale);
}
