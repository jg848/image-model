package image;

import java.io.File;
import java.io.IOException;

import image.model.ImageDensity;
import image.model.ImageFilters;
import image.model.ImageModel;
import image.model.ImageTransformations;

/**
 * Driver class which contains the main method to test the {@link ImageModel}.
 * Performs all the operations in the {@link ImageModel}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageDriver {

  /**
   * Main method for the driver class.
   * 
   * @param args which is the command line arguments to the main method.
   * @throws IOException when failed to read or write the files.
   */
  public static void main(String[] args) throws IOException {

    File file = new File("");

    System.out.println("Reading sample1.jpg");
    Image image = new ImageImpl(file.getAbsolutePath() + "\\sample1.jpg");

    ImageModel model = new ImageFilters(image);
    model.blurImage();
    System.out.println("Saving blur image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_blur.jpg");

    model = new ImageFilters(image);
    model.sharpenImage();
    System.out.println("Saving sharpened image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_sharpen.jpg");

    model = new ImageTransformations(image);
    model.greyscaleImage();
    System.out.println("Saving greyscale image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_greyscale.jpg");

    model = new ImageTransformations(image);
    model.sepiatoneImage();
    System.out.println("Saving sepiatone image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_sepiatone.jpg");

    model = new ImageDensity(image);
    model.colorDitherImage(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_color_dither_8_with_essence.jpg");

    model = new ImageDensity(image);
    model.colorDitherImageWithoutEssence(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_color_dither_8_without_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImage(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_greyscale_dither_8_with_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImageWithoutEssence(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_greyscale_dither_8_without_essence.jpg");

    model = new ImageDensity(image);
    model.colorDitherImage(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_color_dither_2_with_essence.jpg");

    model = new ImageDensity(image);
    System.out.println("Saving dither image.");
    model.colorDitherImageWithoutEssence(2);
    model.saveImage(file.getAbsolutePath() + "\\sample1_color_dither_2_without_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImage(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_greyscale_dither_2_with_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImageWithoutEssence(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample1_greyscale_dither_2_without_essence.jpg");

    System.out.println("Reading sample2.jpg.");
    image = new ImageImpl(file.getAbsolutePath() + "\\sample2.jpg");

    model = new ImageFilters(image);
    model.blurImage();
    System.out.println("Saving blur image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_blur.jpg");

    model = new ImageFilters(image);
    model.sharpenImage();
    System.out.println("Saving sharpened image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_sharpen.jpg");

    model = new ImageTransformations(image);
    model.greyscaleImage();
    System.out.println("Saving greyscale image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_greyscale.jpg");

    model = new ImageTransformations(image);
    model.sepiatoneImage();
    System.out.println("Saving sepiatone image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_sepiatone.jpg");

    model = new ImageDensity(image);
    model.colorDitherImage(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_color_dither_8_with_essence.jpg");

    model = new ImageDensity(image);
    model.colorDitherImageWithoutEssence(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_color_dither_8_without_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImage(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_greyscale_dither_8_with_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImageWithoutEssence(8);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_greyscale_dither_8_without_essence.jpg");

    model = new ImageDensity(image);
    model.colorDitherImage(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_color_dither_2_with_essence.jpg");

    model = new ImageDensity(image);
    model.colorDitherImageWithoutEssence(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_color_dither_2_without_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImage(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_greyscale_dither_2_with_essence.jpg");

    model = new ImageDensity(image);
    model.greyscaleDitherImageWithoutEssence(2);
    System.out.println("Saving dither image.");
    model.saveImage(file.getAbsolutePath() + "\\sample2_greyscale_dither_2_without_essence.jpg");

    System.out.println("Operations complete.");
  }
}
