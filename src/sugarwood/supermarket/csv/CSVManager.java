package sugarwood.supermarket.csv;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVManager {

	
	@SuppressWarnings("unchecked")
	public static <T extends AbstractModel> void persist (T model)  {
		
		ArrayList <T> formerModels = (ArrayList<T>) fetch(model.getClass());
		
		Iterator<T> iterator = formerModels.iterator();
		
		while (iterator.hasNext()) {
			T old = iterator.next();
			
			if (old.getId() == model.getId()) {
				formerModels.remove(old);
				break;
			}
		}
		
		formerModels.add(model);
		
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(model.getArchiveName()));
			for (T item : formerModels) {
				writer.writeNext(item.getFieldValues());
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Archive opening problem:" + model.getArchiveName());
			e.printStackTrace();
		}
	}

	public static <T extends AbstractModel> ArrayList <T> fetch (Class <T> clazz) {
		
		T model = null;
		ArrayList <T> models = new ArrayList <T> ();
		
		try {
			model = clazz.newInstance();

			File csv = new File(model.getArchiveName());
			if(!csv.exists())
				csv.createNewFile();

			CSVReader csvReader = new CSVReader(new FileReader(csv));
				String[] values;
				while((values = csvReader.readNext()) != null) {
					model.setFieldValues (values);
					models.add(model);
					model = clazz.newInstance();
				}

				csvReader.close();
		} catch (InstantiationException | IllegalAccessException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return models;
	}
}