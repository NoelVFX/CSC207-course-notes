/** A rectangle with a width and a height that can be scaled and compared by area. */
public class Rectangle {
  private double width;
  private double height;

  /**
   * Creates a rectangle with the given dimensions.
   *
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Returns the area of this rectangle.
   *
   * @return the width multiplied by the height
   */
  public double area() {
    return width * height;
  }

  /**
   * Scales both dimensions of this rectangle by the given factor.
   *
   * @param factor the amount to multiply the width and height by
   */
  public void scale(double factor) {
    width = width * factor;
    height = height * factor;
  }

  /**
   * Returns whether this rectangle has a strictly larger area than another.
   *
   * @param other the rectangle to compare against
   * @return true if this rectangle's area is greater than other's area
   */
  public boolean isLargerThan(Rectangle other) {
    return area() > other.area();
  }
}
