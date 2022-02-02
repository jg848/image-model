package image.model;

import image.Image;
import image.ImageImpl;
import image.model.channel.ColorChannel;
import image.model.channel.ColorChannelImpl;
import image.model.utils.ImageDensityUtils;
import image.model.utils.ImageModelUtils;

/**
 * This class extends the abstract {@link ImageModelImpl} class and implements
 * the {@link ImageModel} interface. Contains the operations related to the
 * density of an image defined in the {@link ImageModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageDensity extends ImageModelImpl {

  private int[][][] newImage;
  private ColorChannel oldColor;
  private final ImageModelUtils ditherUtils;

  /**
   * Constructor for the {@link ImageDensity} class which takes the {@link Image}
   * as argument to provide the model with the {@link Image} that has to be
   * operated on.
   * 
   * @param image which is the image on which the filter is to be applied.
   */
  public ImageDensity(Image image) {
    super(image);
    newImage = deepClone(image.getImage());
    oldColor = new ColorChannelImpl(new int[3]);
    ditherUtils = new ImageDensityUtils();
  }

  @Override
  public void colorDitherImage(int numberOfColors) {
    if (numberOfColors <= 0) {
      throw new IllegalArgumentException("Number of colors to be reduced to has to be positive.");
    }
    newImage = deepClone(image.getImage());
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        newImage[i][j] = ditherHelper(i, j, numberOfColors);
        for (int k = 0; k < newImage[i][j].length; k++) {
          int error = oldColor.getColorChannel()[k] - newImage[i][j][k];
          newImage = ditherUtils.calculateErrors(newImage, i, j, k, error);
        }
      }
    }
    this.image = new ImageImpl(newImage);

  }

  @Override
  public void greyscaleDitherImage(int numberOfColors) {
    if (numberOfColors <= 0) {
      throw new IllegalArgumentException("Number of colors to be reduced to has to be positive.");
    }
    newImage = deepClone(image.getImage());
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int[] newColor = ditherHelper(i, j, numberOfColors);
        newImage[i][j] = new int[] { newColor[0], newColor[0], newColor[0] };
        int error = oldColor.getColorChannel()[0] - newColor[0];
        for (int k = 0; k < newColor.length; k++) {
          newImage = ditherUtils.calculateErrors(newImage, i, j, k, error);
        }
      }
    }
    this.image = new ImageImpl(newImage);

  }

  @Override
  public void colorDitherImageWithoutEssence(int numberOfColors) {
    if (numberOfColors <= 0) {
      throw new IllegalArgumentException("Number of colors to be reduced to has to be positive.");
    }
    newImage = deepClone(image.getImage());
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        newImage[i][j] = ditherHelper(i, j, numberOfColors);
      }
    }
    this.image = new ImageImpl(newImage);

  }

  @Override
  public void greyscaleDitherImageWithoutEssence(int numberOfColors) {
    if (numberOfColors <= 0) {
      throw new IllegalArgumentException("Number of colors to be reduced to has to be positive.");
    }
    newImage = deepClone(image.getImage());
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        int[] newColor = ditherHelper(i, j, numberOfColors);
        newImage[i][j] = new int[] { newColor[0], newColor[0], newColor[0] };
      }
    }
    this.image = new ImageImpl(newImage);

  }

  /**
   * Helper method to clone the {@link Image} given as input to the class to
   * perform the required density operations.
   * 
   * @param matrix which is the {@link Image} represented as a matrix.
   * @return a matrix which is a copy of the original {@link Image}.
   */
  private int[][][] deepClone(int[][][] matrix) {
    if (null == matrix) {
      throw new IllegalArgumentException("Invalid image matrix.");
    }
    int[][][] clone = new int[matrix.length][matrix[0].length][matrix[0][0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.arraycopy(matrix[i][j], 0, clone[i][j], 0, matrix[0][0].length);
      }
    }
    return clone;
  }

  /**
   * Helper method to apply the dither to an {@link Image}.
   * 
   * @param i              which is the height index of the {@link Image}.
   * @param j              which is the width index of the {@link Image}.
   * @param numberOfColors which is the number of colors the dithering has to be
   *                       applied to the {@link Image}.
   * @return an array containing the color channels.
   */
  private int[] ditherHelper(int i, int j, int numberOfColors) {
    if (i < 0 || j < 0 || numberOfColors <= 0) {
      throw new IllegalArgumentException("Invalid dithering arguments.");
    }
    oldColor = new ColorChannelImpl(newImage[i][j]);
    return ditherUtils.applyColorDitherToImage(oldColor, numberOfColors);
  }

}
