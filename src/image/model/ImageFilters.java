package image.model;

import image.Image;

/**
 * This class extends the abstract {@link ImageModelImpl} class and implements
 * the {@link ImageModel} interface. Contains the operations related to the
 * filtering of an image defined in the {@link ImageModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageFilters extends ImageModelImpl {

  /**
   * Constructor for the {@link ImageFilters} class which takes the {@link Image}
   * as argument to provide the model with the {@link Image} that has to be
   * operated on.
   * 
   * @param image which is the image on which the filter is to be applied.
   */
  public ImageFilters(Image image) {
    super(image);
  }

  @Override
  public void blurImage() {
    double[][] blurFilterMatrix = { { 0.0625, 0.125, 0.0625 }, { 0.125, 0.25, 0.125 },
        { 0.0625, 0.125, 0.0625 } };
    this.filterImage(blurFilterMatrix);
  }

  @Override
  public void sharpenImage() {
    double[][] sharpenFilterMatrix = { { -0.125, -0.125, -0.125, -0.125, -0.125 },
        { -0.125, 0.25, 0.25, 0.25, -0.125 }, { -0.125, 0.25, 1, 0.25, -0.125 },
        { -0.125, 0.25, 0.25, 0.25, -0.125 }, { -0.125, -0.125, -0.125, -0.125, -0.125 } };
    this.filterImage(sharpenFilterMatrix);
  }

}
