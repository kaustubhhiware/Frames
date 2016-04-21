------------------------------------------------------------------------
This is the project README file
------------------------------------------------------------------------

PROJECT TITLE:Photo_Album
PURPOSE OF PROJECT:Assignment
VERSION or DATE:10 Feb 2016

HOW TO START THIS PROJECT:
Initially , try to run PictureGallery.jar .In ubuntu , you might have to write this in terminal
cd <location>
sudo chmod a+x CourseHandler.jar
If none of this works , start it in the default way by running in Eclipse/NetBeans

AUTHORS:Kaustubh Hiware , 14CS30011
USER INSTRUCTIONS:

>>Gallery.java is the main file.The name are displayed in a list so that the user may be able to delete an image.

>>On clicking titles , a clickable format of titles is obtained , for individual viewing.The displayAll frame goes off temporarily , once you press back on individual images.

>>Slide show (Continuous viewing of images) is possible by clicking the left and right buttons.

>>On clicking a title on Gallery frame, the user may delete/view it . If no image is selected , the program proceeds as if "Gallery !" button is pressed.

>>"Gallery !" generates sort-of thumbnail for each image <GridLayout is used here>.

>>Images are added by clicking on Add button . Upto 10 photos can be loaded . I have used FileChooser here.Valid Title<upto 20 chars> and Annotation<100 chars > is taken from the user.

>>I am reading the path name , title and annotation in a file.The complete path is stored , so if an image is shifted to another location , that image is deleted , if a request is made to view the image.I have not saved the image in file ,

>>I am checking if the user is choosing an actual image of format{".png",".jpg",".jpeg",".gif",".bmp"	   ,".PNG",".JPG",".JPEG",".GIF",".BMP"} and only then the image is selected.

>>Image is resized in both viewImage and displayAll

>>A stock set of images is provided.
							-X-