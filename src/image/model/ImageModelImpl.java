package image.model;

import image.Image;
import image.ImageImpl;
import image.model.channel.ColorChannelImpl;
import image.model.pixel.Pixel;
import image.model.pixel.PixelImpl;
import image.model.utils.ImageFiltersUtils;
import image.model.utils.ImageModelUtils;
import image.model.utils.ImageTransformationUtils;
import image.model.utils.ImageUtilities;

import java.io.IOException;

/**
 * Abstract implementation class for the {@link ImageModel} interface. Contains
 * the common features required for the operations defined in the
 * {@link ImageModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class ImageModelImpl implements ImageModel {

  protected Image image;

  /**
   * Constructor for the abstract implementation class of {@link ImageModel}.
   */
  protected ImageModelImpl(Image image) {
    if (null == image) {
      throw new IllegalArgumentException("Image is invalid.");
    }
    this.image = image;
  }

  @Override
  public void blurImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void sharpenImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void greyscaleImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void sepiatoneImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void colorDitherImage(int numberOfColors) {
    // Method to be overridden in child class.
  }

  @Override
  public void greyscaleDitherImage(int numberOfColors) {
    // Method to be overridden in child class.
  }

  @Override
  public void colorDitherImageWithoutEssence(int numberOfColors) {
    // Method to be overridden in child class.
  }

  @Override
  public void greyscaleDitherImageWithoutEssence(int numberOfColors) {
    // Method to be overridden in child class.
  }

  /**
   * Helper method for the filtering operation on the {@link Image}.
   * 
   * @param filter which is the filter matrix to be applied to the {@link Image}.
   */
  protected void filterImage(double[][] filter) {
    if (null == filter) {
      throw new IllegalArgumentException("Invalid filter matrix.");
    }
    if (filter.length % 2 == 0 || filter.length != filter[0].length) {
      throw new IllegalArgumentException("Invalid filter matrix.");
    }
    int[][][] newImage = new int[image.getHeight()][image.getWidth()][3];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel curPixel = new PixelImpl(i, j, new ColorChannelImpl(image.getImage()[i][j]));
        ImageModelUtils filterUtils = new ImageFiltersUtils();
        newImage[i][j] = filterUtils.applyFilterToImage(image, filter, curPixel);
      }
    }
    this.image = new ImageImpl(newImage);
  }

  /**
   * Helper method for the transformation operation on the {@link Image}.
   * 
   * @param filter which is the transformation matrix to be applied to the
   *               {@link Image}.
   */
  protected void transformImage(double[][] transformation) {
    if (null == transformation) {
      throw new IllegalArgumentException("Invalid transformation matrix.");
    }
    int[][][] newImage = new int[image.getHeight()][image.getWidth()][3];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel curPixel = new PixelImpl(i, j, new ColorChannelImpl(image.getImage()[i][j]));
        ImageModelUtils transformationUtils = new ImageTransformationUtils();
        newImage[i][j] = transformationUtils.applyTransformationToImage(transformation, curPixel);
      }
    }
    this.image = new ImageImpl(newImage);
  }

  @Override
  public void saveImage(String filename) throws IOException {
    if (null == filename || filename.isBlank()) {
      throw new IllegalArgumentException("Filename cannot be empty.");
    }
    try {
      ImageUtilities.writeImage(this.image.getImage(), this.image.getWidth(),
          this.image.getHeight(), filename);
    } catch (IOException e) {
      throw new IOException("Unable to write image.");
    }
  }

}
