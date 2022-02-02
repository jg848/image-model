# Image Model

### About/Overview
Image Processing Model which can be used to build a full MVC application.
Overview:
  - Filtering operations can be performed on an image like **_Blurring_** and **_Sharpening_**.
  - Transformation operations can be performed on an image like **_Greyscale_** and **_Sepia Tone_**.
  - Can reduce the color density of the images using _floyd-steinberg_ dithering algorithm to reduce the number of colors used in the image.

### List of features

  - The **_Image_** interface represents an image in the program. **_ImageImpl_** is the implementation class for this interface which implements the operations defined like retrieving image height, image width and a 3D image matrix.
  - The **_ImageModel_** Interface represents the operations that can be performed on the **_Image_**. **_ImageModelImpl_** is an abstract class which is the implementation class of the **_ImageModel_** interface which provides the implementations to the defined operations.
	> **_ImageFilters_** extends the abstract **_ImageModelImpl_** class to implement the filtering operations defined in the **_ImageModel_**.
	> **_ImageTransformations_** extends the abstract **_ImageModelImpl_** class to implement the transformation operations defined in the **_ImageModel_**.
	> **_ImageDensity_** extends the abstract **_ImageModelImpl_** class to implement the density related operations defined in the **_ImageModel_**.
  - The **_ImageModelUtils_** interface represents the utilities that are provided for the **_ImageModel_** to perform the required operations. Abstract class **_ImageModelUtilsImpl_** is the implementation class for this interface which provides the implementations to the defined operations.
	> **_ImageFiltersUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the filtering operation utilities defined in the **_ImageModelUtils_**.
	> **_ImageTransformationsUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the transformation operation utilities defined in the **_ImageModelUtils_**.
	> **_ImageDensityUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the density related operation utilities defined in the **_ImageModelUtils_**.
  - The **_Pixel_** interface represents a pixel in the image. **_PixelImpl_** class is the implementation class which implements the operations defined in the interface. Can provide details of the pixel like the row number, column number and color channels. Also used to modify the pixel based on the operations of the **_ImageModel_** and clamp the values as required.
  - The **_ColorChannel_** interface represents the color channels of a pixel in an image which has 3 color values **_RED, GREEN and BLUE_**. **_ColorChannelImpl_** is the implementation class of this interface which implements the operations defined in the interface. Can provide the details of the color channels, set the color channels of a pixel and find a color closest in the palette and clamp the color values accordingly for a given color.

### How To Run
  Instructions to run the **_JAR_** file provided in the **_res/_** folder
  > Use: **_java -jar .\ImageModel.jar_** in the command prompt(Windows).
  > **jdk-11 Java version** is used to compile and build the application.

### How to Use the Program
  The **_ImageDriver_** class has a **_main_** function that demonstrates all the features of **_ImageModel_**.
> First, the image with the name 'sample1.jpg' in the 'res' source folder is read and the model is initialized with this image. Then, the model is used to perform different operations on the image and save the images accordingly. The order of execution goes as follow:
> Blur operation
> Sharpen operation
> Greyscale operation
> Sepiatone operation
> Color Dither with 2 colors maintaining essence operation
> Color Dither with 2 colors without essence operation
> Color Dither with 8 colors maintaining essence operation
> Color Dither with 8 colors without essence operation
> Greyscale Dither with 2 colors maintaining essence operation
> Greyscale Dither with 2 colors without essence operation
> Greyscale Dither with 8 colors maintaining essence operation
> Greyscale Dither with 8 colors without essence operation

> Second, the image with the name 'sample2.jpg' in the 'res' source folder is read and the model is initialized with this image. Then, the model is used to perform different operations on the image and save the images accordingly. The order of execution goes as follow:
> Blur operation
> Sharpen operation
> Greyscale operation
> Sepiatone operation
> Color Dither with 2 colors maintaining essence operation
> Color Dither with 2 colors without essence operation
> Color Dither with 8 colors maintaining essence operation
> Color Dither with 8 colors without essence operation
> Greyscale Dither with 2 colors maintaining essence operation
> Greyscale Dither with 2 colors without essence operation
> Greyscale Dither with 8 colors maintaining essence operation
> Greyscale Dither with 8 colors without essence operation

### Description of Example Run
It saves the processed images to respective file locations.
> Blur operation - The image is applied with a blur filter and the resulting image is stored in the 'res' source folder as 'sample1_blur.jpg'.
> Sharpen operation - The image is applied with a sharpen filter and the resulting image is stored in the 'res' source folder as 'sample1_sharpen.jpg'.
> Greyscale operation - The image is applied with a greyscale transformation and the resulting image is stored in the 'res' source folder as 'sample1_greyscale.jpg'.
> Sepiatone operation - The image is applied with a sepiatone transformation and the resulting image is stored in the 'res' source folder as 'sample1_sepiatone.jpg'.
> Color Dither with 2 colors maintaining essence operation - The color image is dithered by reducing the density to 2 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_color_dither_2_with_essence.jpg'**.
> Color Dither with 2 colors without essence operation - The color image is dithered by reducing the density to 2 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_color_dither_2_without_essence.jpg'**.
> Color Dither with 8 colors maintaining essence operation - The color image is dithered by reducing the density to 8 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_color_dither_8_with_essence.jpg'**.
> Color Dither with 8 colors without essence operation - The color image is dithered by reducing the density to 8 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_color_dither_8_without_essence.jpg'**.
> Greyscale Dither with 2 colors maintaining essence operation - The greyscale image is dithered by reducing the density to 2 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_greyscale_dither_2_with_essence.jpg'**.
> Greyscale Dither with 2 colors without essence operation - The greyscale image is dithered by reducing the density to 2 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_greyscale_dither_2_without_essence.jpg'**.
> Greyscale Dither with 8 colors maintaining essence operation - The greyscale image is dithered by reducing the density to 8 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_greyscale_dither_8_with_essence.jpg'**.
> Greyscale Dither with 8 colors without essence operation - The greyscale image is dithered by reducing the density to 8 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample1_greyscale_dither_8_without_essence.jpg'**.

> Blur operation - The image is applied with a blur filter and the resulting image is stored in the 'res' source folder as 'sample2_blur.jpg'.
> Sharpen operation - The image is applied with a sharpen filter and the resulting image is stored in the 'res' source folder as 'sample2_sharpen.jpg'.
> Greyscale operation - The image is applied with a greyscale transformation and the resulting image is stored in the 'res' source folder as 'sample2_greyscale.jpg'.
> Sepiatone operation - The image is applied with a sepiatone transformation and the resulting image is stored in the 'res' source folder as 'sample2_sepiatone.jpg'.
> Color Dither with 2 colors maintaining essence operation - The color image is dithered by reducing the density to 2 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_color_dither_2_with_essence.jpg'**.
> Color Dither with 2 colors without essence operation - The color image is dithered by reducing the density to 2 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_color_dither_2_without_essence.jpg'**.
> Color Dither with 8 colors maintaining essence operation - The color image is dithered by reducing the density to 8 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_color_dither_8_with_essence.jpg'**.
> Color Dither with 8 colors without essence operation - The color image is dithered by reducing the density to 8 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_color_dither_8_without_essence.jpg'**.
> Greyscale Dither with 2 colors maintaining essence operation - The greyscale image is dithered by reducing the density to 2 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_greyscale_dither_2_with_essence.jpg'**.
> Greyscale Dither with 2 colors without essence operation - The greyscale image is dithered by reducing the density to 2 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_greyscale_dither_2_without_essence.jpg'**.
> Greyscale Dither with 8 colors maintaining essence operation - The greyscale image is dithered by reducing the density to 8 colors per channel while maintaining the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_greyscale_dither_8_with_essence.jpg'**.
> Greyscale Dither with 8 colors without essence operation - The greyscale image is dithered by reducing the density to 8 colors per channel without the essence of the image and the resulting image is stored in the 'res' source folder as **'sample2_greyscale_dither_8_without_essence.jpg'**.

### Design/Model Changes
> Methods of the classes that implement the functionalities have been modified and few helper methods have been included but the structure has been the same.

### Assumptions

> Filename has to be a valid string for reading an image.

> For dithering the image, the number of colors per channel has to be positive.

> Filter matrix for filtering an image has to be of odd dimensions.

### Limitations
> Images used to test the program are of size less than 40kb.

> For filtering and transformation operations, the amount of the operation cannot be given and the operations are to be done on the modified images multiple times.

> Currently methods that can be performed on the image are blur, sharpen, greyscale, sepiatone, color dither and greyscale dither.

### Citations
> These images are my own and I authorize to use these images as part of this project.