import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.imageio.IIOException;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Gallery implements Serializable{

	private JFrame frame;
    static ArrayList<Photo> album = new ArrayList<Photo>();
    private JTable table;
	String filename = "Images.dat";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gallery window = new Gallery();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public Gallery () 
	{
		int savedSize =0 ;
        ArrayList<Photo> album1 = new ArrayList<Photo>();

		try   {
            FileInputStream infile = new FileInputStream(filename);
            ObjectInputStream outfile = new ObjectInputStream(infile);
           
            savedSize = (int) outfile.readInt();

            try {
            	album1 = (ArrayList<Photo>) outfile.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
            
            
			infile.close();
			outfile.close();
		}
        catch (FileNotFoundException e) 
		{
           // System.err.println("File not found");
            try{
                File f = new File(filename);
                
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(Exception ex){
                e.printStackTrace();
             }
        }  
        catch (IOException e)
		{ 
        //	System.err.println("Read failed"); 
        }
		
		if(savedSize!=0)
		{
			album = album1;
		}
		
		frame = new JFrame();
		frame.setTitle("Photo Album");
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(scrollPane);
		
		int size = album.size();
		Object[][] album_object  = new String[size][2];
    	
    	int i;
		for(i = 0; i < size ; i++)
		{
			album_object[i][0] = album.get(i).getTitle();
			album_object[i][1] = album.get(i).getAnnotation();
		}
		
		String[] columns = {"Title","Description"};
		
		table = new JTable(album_object,columns);
		table.enableInputMethods(true);	
		table.setBounds(10, 40, 464, 200);
		frame.getContentPane().add(table);
		
		JButton btnTitles = new JButton("Titles !");
		btnTitles.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				displayAll dA = new displayAll(album,filename,0,frame);//0 for titles , 1 for images
																//because a picture is worth 1K words
			}
		});
		btnTitles.setBounds(10, 10, 80, 30);
		frame.getContentPane().add(btnTitles);
		
		JLabel lblAnnotation = new JLabel("Annotation");
		lblAnnotation.setBounds(396, 11, 78, 18);
		frame.getContentPane().add(lblAnnotation);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int found = 0;
				 String path = " ";
				/*
				if(album.size()==10)
				{
					JOptionPane.showMessageDialog(null, "Only 10 photos can be saved at a time !");
				}
				else
				{ 
                                 */   
					 final JFileChooser  fileDialog = new JFileChooser();
						int returnVal = fileDialog.showOpenDialog(frame);

				        if (returnVal == JFileChooser.APPROVE_OPTION)
				        {
				    		
				            String filename=fileDialog.getSelectedFile().getName();
				           java.io.File file = fileDialog.getSelectedFile();
				           
				            path=fileDialog.getSelectedFile().getAbsolutePath();
				          // String extension = file.getFileExtension(path);
				           
				           String validate = filename.substring(filename.lastIndexOf("."),filename.length());

				    	   //JOptionPane.showMessageDialog(null,"Path = "+path);

				    	   
				           String[] validTypes = {".png",".jpg",".jpeg",".gif",".bmp"
				        		   ,".PNG",".JPG",".JPEG",".GIF",".BMP"};//allowed photo types
				           int possible_size = validTypes.length;
				          
				           for(int i = 0; i < possible_size ; i++)
				           {
				        	   if(validate.equals(validTypes[i]))
				        	   {
				        		   found = 1;
				        		   break;
				        	   }
				           }
				           if(found==1)
				           {
				        	   JOptionPane.showMessageDialog(null,"Image selected
