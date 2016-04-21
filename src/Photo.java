import java.io.Serializable;

public class Photo implements Serializable{

	protected String Image;
	protected String Title;
	protected String Annotation;
	
	//Photo has title and annotation , whereas image is just the image<no title, like in the picture books>
	public void setImage(String pic)
	{
		this.Image = pic;
	}
	public String getImage()
	{
		return Image;
	}
	
	
	public void setTitle(String name)
	{
		this.Title = name;
	}
	public String getTitle()
	{
		return Title;
	}
	
	
	public void setAnnotation(String description)
	{
		this.Annotation = description;
	}
	public String getAnnotation()
	{
		return Annotation;
	}
	
}
