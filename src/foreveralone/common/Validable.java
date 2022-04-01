package foreveralone.common;

public interface Validable 
{

	String getErrors();
	
	default boolean isValid()
	{
		return getErrors().length()==0;
	}
	
}
