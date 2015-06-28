package sugarwood.supermarket.csv;

import java.util.HashMap;

public interface AbstractModel {
	
	public Integer getId ();
	
	public String[] getFieldValues();
	
	public void setFieldValues(String [] fieldValues);
	
	public String getArchiveName ();
}
