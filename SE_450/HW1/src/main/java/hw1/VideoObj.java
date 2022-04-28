package hw1;
// TODO: complete the methods
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * Immutable Data Class
 * Title is non-null, no leading or final spaces, not empty string.
 * Year is greater than 1800, less than 5000.
 * Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {
  /** non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** greater than 1800, less than 5000 */
  private final int    _year;
  /** non-null, no leading or final spaces, not empty string */
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {
    // TODO
    _title = title;
    _year = year;
    _director = director;
     
  }

  /**
   * Return the value of the attribute.
   */
  public String director() {
    return this._director;
  }

  /**
   * Return the value of the attribute.
   */
  public String title() {
    return this._title;
  }

  /**
   * Return the value of the attribute.
   * @return
   */
  public int year() {
    return this._year;
  }

  /**
   * Compare the attributes of this object with those of thatObject.
   * @param thatObject the Object to be compared.
   * @return deep equality test between this and thatObject.
   */
  public boolean equals(Object thatObject) {
    if(super.equals(thatObject)){
      return true;
    }
    return false;
  }

  /**
   * Return a hash code value for this object using the algorithm from Bloch:
   * fields are added in the following order: title, year, director.
   */
  public int hashCode() {

      int result = 17;
      result = 37*result + ((this._title != null) ? this._title.hashCode() : 0);
      result = 37*result + ((this._year != 0) ? String.valueOf(this._year).hashCode() : 0);
      result = 37*result + ((this._director != null) ? this._director.hashCode() : 0);
      return result;
  }

  /**
   * Compares the attributes of this object with those of thatObject, in
   * the following order: title, year, director.
   * @param that the VideoObj to be compared.
   * @return a negative integer, zero, or a positive integer as this
   *  object is less than, equal to, or greater than that object.
   */
  public int compareTo(VideoObj that) {
      return this._title.compareTo(that._title) + Integer.valueOf(this._year).compareTo(Integer.valueOf(that._year))
              + this._director.compareTo(that._director);
  }

  /**
   * Return a string representation of the object in the following format:
   * <code>"title (year) : director"</code>.
   */
  public String toString() {
    String res = this.title() + " (" + this.year() + ") : " + this._director;
    return res;
  }
}
