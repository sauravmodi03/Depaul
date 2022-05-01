package shop.data;

import java.util.*;

import shop.command.*;

/**
 * Implementation of Inventory interface.
 * @see Data
 */
final class InventorySet implements Inventory {
  private Map<Video,Record> _data;
  private final CommandHistory _history;

  InventorySet() {
    _data = new HashMap<>();
    _history = new CommandHistoryObj();
  }

  /**
   * If <code>record</code> is null, then delete record for <code>video</code>;
   * otherwise replace record for <code>video</code>.
   */
  void replaceEntry(Video video, Record record) {
    _data.remove(video);
    if (record != null)
      _data.put(video,((RecordObj)record).copy());
    else {
      _data.remove(video);
    }
  }

  /**
   * Overwrite the map.
   */
  void replaceMap(Map<Video,Record> data) {
    _data = data;
  }

  public int size() {
    return _data.size();
  }

  public Record get(Video video) {
    return _data.get(video);
  }

  public Iterator<Record> iterator() {
    return Collections.unmodifiableCollection(_data.values()).iterator();
  }

  public Iterator<Record> iterator(Comparator<Record> comparator) {
    List list = new ArrayList(_data.values());
    Collections.sort(list,comparator);
    return list.iterator();
  }

  /**
   * Add or remove copies of a video from the inventory.
   * If a video record is not already present (and change is
   * positive), a record is created. 
   * If a record is already present, <code>numOwned</code> is
   * modified using <code>change</code>.
   * If <code>change</code> brings the number of copies to be zero,
   * the record is removed from the inventory.
   * @param video the video to be added.
   * @param change the number of copies to add (or remove if negative).
   * @return A copy of the previous record for this video (if any)
   * @throws IllegalArgumentException if video null, change is zero, if attempting to remove more copies than are owned, or if attempting to remove copies that are checked out. 
   */
  Record addNumOwned(Video video, int change) {
    if (video == null || change == 0) {
      throw new IllegalArgumentException("Video is null or change is zero");
    }
    Record record = _data.get(video);
    if (record != null) {
      if ((record.numOwned() + change) < record.numOut()) {
        throw new IllegalArgumentException("Attempting to remove copies that are checked out.");
      }
      if ((record.numOwned() + change) > record.numOut()) {
        if ((record.numOwned() + change) >= 1) {
          _data.replace(video,new RecordObj(video,record.numOwned() + change,record.numOut(),record.numRentals()));
        }
      } else if ((record.numOwned() + change) <= 0 ) {
        _data.remove(video);
      }
    } else {
      if(change > 0 ) {
        Record _rec = new RecordObj(video, change, 0, 0);
        _data.put(video, _rec);
      }
    }
    return record;
  }

  /**
   * Check out a video.
   * @param video the video to be checked out.
   * @return A copy of the previous record for this video
   * @throws IllegalArgumentException if video has no record or numOut
   * equals numOwned.
   */
  Record checkOut(Video video) {
    if (_data.containsValue(_data.get(video)) == false || (_data.get(video).numOut()) == (_data.get(video).numOwned())) {
      throw new IllegalArgumentException("Video has no record or numOut equals numOwned.");
    }
    Record record = new RecordObj(video,_data.get(video).numOwned(),_data.get(video).numOut(), _data.get(video).numRentals());
    _data.replace(video,new RecordObj(video,record.numOwned(),record.numOut() + 1, record.numRentals() + 1));
    return record;
  }
  
  /**
   * Check in a video.
   * @param video the video to be checked in.
   * @return A copy of the previous record for this video
   * @throws IllegalArgumentException if video has no record or numOut
   * non-positive.
   */
  Record checkIn(Video video) {
    if (_data.containsValue(_data.get(video)) == false || (_data.get(video).numOut() <= 0)) {
      throw new IllegalArgumentException("Video has no record or numOut non-positive.");
    }
    Record record = new RecordObj(video,_data.get(video).numOwned(),_data.get(video).numOut(), _data.get(video).numRentals());
    _data.replace(video, new RecordObj(video, record.numOwned(),record.numOut() - 1, record.numRentals()));
    return record;
  }
  
  /**
   * Remove all records from the inventory.
   * @return A copy of the previous inventory as a Map
   */
  Map<Video,Record> clear() {
    Map<Video,Record> copy = new HashMap<>();
    for (Map.Entry<Video, Record> entry : _data.entrySet()) {
      copy.put(entry.getKey(), entry.getValue());
    }
    _data.clear();
    return copy;
  }

  /**
   * Return a reference to the history.
   */
  CommandHistory getHistory() {
    return _history;
  }
  
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append("Database:\n");
    Iterator i = _data.values().iterator();
    while (i.hasNext()) {
      buffer.append("  ");
      buffer.append(i.next());
      buffer.append("\n");
    }
    return buffer.toString();
  }


  /**
   * Implementation of Record interface.
   *
   * <p>This is a utility class for Inventory.  Fields are immutable and
   * package-private.</p>
   *
   * <p><b>Class Invariant:</b> No two instances may reference the same Video.</p>
   *
   * @see Record
   */
  private static final class RecordObj implements Record {
    final Video video; // the video
    final int numOwned;   // copies owned
    final int numOut;     // copies currently rented
    final int numRentals; // total times video has been rented
    
    RecordObj(Video video, int numOwned, int numOut, int numRentals) {
      this.video = video;
      this.numOwned = numOwned;
      this.numOut = numOut;
      this.numRentals = numRentals;
    }
    RecordObj copy() {
      return new RecordObj(video, numOwned, numOut, numRentals);
    }
    public Video video() {
      return video;
    }
    public int numOwned() {
      return numOwned;
    }
    public int numOut() {
      return numOut;
    }
    public int numRentals() {
      return numRentals;
    }
    public boolean equals(Object thatObject) {
      return video.equals(((Record)thatObject).video());
    }
    public int hashCode() {
      return video.hashCode();
    }
    public String toString() {
      StringBuilder buffer = new StringBuilder();
      buffer.append(video);
      buffer.append(" [");
      buffer.append(numOwned);
      buffer.append(",");
      buffer.append(numOut);
      buffer.append(",");
      buffer.append(numRentals);
      buffer.append("]");
      return buffer.toString();
    }
  }
}