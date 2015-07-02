package sugarwood.supermarket.csv;

public interface AbstractModel {
	
	public Integer getId ();
	
	public String[] getFieldValues();
	
	public void setFieldValues(String [] fieldValues);
	
	public String getArchiveName ();
}
