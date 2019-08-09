package bouboule.model.score;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * Cette classe g�re la lecture et l'�criture d'un fichier de meilleurs scores
 * @author labbeh
 * @version 2019-08-06
 * */

public class FichierScore {
	/**
	 * chemin d'acc�s au fichier
	 * */
	private static final String XML_SCORE_FILENAME = "./datas/scores.xml";
	
	/**
	 * Ensemble des meilleurs scores
	 * Clef == nom du joueur
	 * Valeur == score obtenu
	 * */
	private Map<String, Integer> scoresByNames;

	public FichierScore() {
		scoresByNames = new HashMap<String, Integer>();
	}
	
	public void loadFile(){
		Document document;
		Element  racine	 ;

		SAXBuilder builder = new SAXBuilder();

		//Map<String, Map<String, String>> modules = new HashMap<>();
		List<Element> scores;
		//List<Element> after ;

		try{
			document = builder.build(new File(XML_SCORE_FILENAME));
			racine 	 = document.getRootElement();

			scores = racine.getChildren("score");
			
			// on parcours l'ensemble des balises scores et on garde celles
			// qui ont du contenu
			for(Element elt: scores) {
				//int id = elt.getAttribute("id").getIntValue();
				String name = elt.getChildText("name");
				String value = elt.getChildText("value");
				
				if(!name.equals(""))
					scoresByNames.put(name, Integer.parseInt(value));
			} // fin du for

		}// fin du try
		catch(Exception evt){evt.printStackTrace();}
	}
	
	public int size() {return scoresByNames.size();}
	
	public void addScore(int id, String name, int value) {
		Document document;
		Element  racine	 ;
		Element  score   ;

		SAXBuilder builder = new SAXBuilder();
		XMLOutputter out = new XMLOutputter();
		
		// v�rification du score
		Collection<Integer> values = scoresByNames.values();

		try{
			document = builder.build(new File(XML_SCORE_FILENAME));
			racine 	 = document.getRootElement();
			
			//score = racine.set

		}// fin du try
		catch(Exception evt){evt.printStackTrace();}
	}
	
	
	
	public static void main(String[] args) {
		FichierScore fs = new FichierScore();
		fs.loadFile();
		System.out.println(fs.scoresByNames.size());
	}

}
