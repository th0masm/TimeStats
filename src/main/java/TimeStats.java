package main.java;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeStats {

	public static void main(String[] args) {
		try {
			File f = new File(
					"/Users/thomasm/Documents/workspace/TimeStats/src/untitled.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			Rider rider = null;
			String line;
			List<Rider> riders = new ArrayList<Rider>();
			boolean newRider = false;

			try {

				line = br.readLine();

				while (line != null) {
					if (line.isEmpty())
						newRider = true;
					else if (newRider) {
						newRider = false;
						rider = new Rider(line);
						riders.add(rider);
					} else
						rider.addTime(new Time(line));

					line = br.readLine();
				}
				
				Chart c = new Chart(riders,"Manche Superbike Aragon");
				
				System.out.println(c.getChart());
				
				br.close();
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : "
						+ exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}

	}

}
