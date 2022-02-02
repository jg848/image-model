package image.model;

import image.Image;

/**
 * This class extends the abstract {@link ImageModelImpl} class and implements
 * the {@link ImageModel} interface. Contains the operations related to the
 * transformation of an image defined in the {@link ImageModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageTransformations extends ImageModelImpl {

  /**
   * Constructor for the {@link ImageTransformations} class which takes the
   * {@link Image} as argument to provide the model with the {@link Image} that
   * has to be operated on.
   */
  public ImageTransformations(Image image) {
    super(image);
  }

  @Override
  public void greyscaleImage() {
    double[][] greyscaleTransformationMatrix = { { 0.2126, 0.7152, 0.0722 },
        { 0.2126, 0.7152, 0.0722 }, { 0.2126, 0.7152, 0.0722 } };
    this.transformImage(greyscaleTransformationMatrix);
  }

  @Override
  public void sepiatoneImage() {
    double[][] sepiaToneTransformationMatrix = { { 0.393, 0.769, 0.189 }, { 0.349, 0.686, 0.168 },
        { 0.272, 0.534, 0.131 } };
    this.transformImage(sepiaToneTransformationMatrix);
  }
}
