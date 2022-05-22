package shop.data;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;
  private static Map<Integer,Video> videoCache = new WeakHashMap<>();

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    checkInvariants(title,year,director);
    _title = title.trim();
    _director = director.trim();
    _year = year;
  }

  /**
   *
   * @param title
   * @param year
   * @param director
   * @return
   */
  public static Video getNewVideo(String title, int year, String director) {
    Video newVideo = videoCache.computeIfAbsent(getKey(title,year,director), newKey -> {
          return new VideoObj(title, year, director);
        });
    return newVideo;
  }

  /**
   *
   * @return
   */
  public String director() {
    return this._director;
  }

  /**
   *
   * @return
   */
  public String title() {
    return this._title;
  }

  /**
   *
   * @return
   */
  public int year() {
    return this._year;
  }

  /**
   *
   * @param thatObject the Object to be compared.
   * @return
   */
  public boolean equals(Object thatObject) {
    return super.equals(thatObject);
  }

  /**
   *
   * @return
   */
  public int hashCode() {
    int result = 17;
    result = 37*result + ((this.title() != null) ? this.title().hashCode() : 0);
    result = 37*result + ((this._year != 0) ? String.valueOf(this._year).hashCode() : 0);
    result = 37*result + ((this.director() != null) ? this.director().hashCode() : 0);
    return result;
  }

  /**
   *
   * @param title
   * @param year
   * @param director
   * @return
   */
  private static int getKey(String title, int year, String director) {
    return title != null ? title.hashCode() : 0
            + String.valueOf(year).hashCode()
            + director != null ? director.hashCode() : 0;
  }

  /**
   *
   * @param that the Video to be compared.
   * @return
   */
  public int compareTo(Video that) {
    return this._title.compareTo(that.title()) + Integer.valueOf(this._year).compareTo(Integer.valueOf(that.year()))
            + this._director.compareTo(that.director());
  }

  /**
   *
   * @return
   */
  public String toString() {
    return this._title + " (" + this.year() + ") : " + this._director;
  }

  /**
   *
   * @param title
   * @param year
   * @param director
   * @return
   */
  private boolean checkInvariants(String title, int year, String director) {
    if ((year > 1800 && year < 5000)
            && director != null && !director.trim().isEmpty()
            && title != null && !title.trim().isEmpty()) {
      return true;
    } else
      throw new IllegalArgumentException();
  }
}
