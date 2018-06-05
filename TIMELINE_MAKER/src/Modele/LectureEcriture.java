package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LectureEcriture {
	public static Object lecture(File parFichier) throws FileNotFoundException, IOException{
		ObjectInputStream flux;
		Object objetLu = null;
		
		//ouverture du fichier en mode lecture
		try{
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch(ClassNotFoundException parException){
			System.err.println(parException.toString());
			System.exit(1);
		}
		catch (IOException parException){
			System.err.println("Erreur lecture du fichier"+ parException.toString());
			System.exit(1);
		}
		return objetLu;
	} //lecture()
	public static void ecriture(File parFichier, Object parObjet){
		ObjectOutputStream flux = null;
		
		//ouverture du fichier en mode ecriture
		try{
			flux = new ObjectOutputStream(new FileOutputStream(parFichier));
			flux.writeObject(parObjet);
			flux.flush();
			flux.close();
		}
		catch (IOException parException){
			System.err.println("Erreur l'ecriture \n"+ parException.toString());
			System.exit(1);
		}
	}//ecriture()
}
